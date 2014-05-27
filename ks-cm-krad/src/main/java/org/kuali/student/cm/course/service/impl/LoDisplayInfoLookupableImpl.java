package org.kuali.student.cm.course.service.impl;

import org.apache.commons.lang.StringUtils;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;
import org.kuali.rice.krad.lookup.LookupableImpl;
import org.kuali.rice.krad.lookup.LookupForm;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.student.cm.common.util.CurriculumManagementConstants;
import org.kuali.student.cm.course.form.LoCategoryInfoWrapper;
import org.kuali.student.cm.course.form.LoDisplayInfoWrapper;
import org.kuali.student.cm.course.form.OrganizationInfoWrapper;
import org.kuali.student.cm.course.service.util.CourseCodeSearchUtil;
import org.kuali.student.cm.course.service.util.CourseCodeSearchWrapper;
import org.kuali.student.cm.course.service.util.LoCategorySearchUtil;
import org.kuali.student.cm.course.service.util.OrganizationSearchUtil;
import org.kuali.student.lum.lu.ui.course.keyvalues.LoSearchByValuesFinder.SearchByKeys;
import org.kuali.student.r2.common.dto.RichTextInfo;
import org.kuali.student.common.util.security.ContextUtils;
import org.kuali.student.r2.common.util.constants.LearningObjectiveServiceConstants;
import org.kuali.student.r2.core.organization.service.OrganizationService;
import org.kuali.student.r2.core.search.dto.SearchParamInfo;
import org.kuali.student.r2.core.search.dto.SearchRequestInfo;
import org.kuali.student.r2.core.search.dto.SearchResultCellInfo;
import org.kuali.student.r2.core.search.dto.SearchResultInfo;
import org.kuali.student.r2.core.search.dto.SearchResultRowInfo;
import org.kuali.student.r2.lum.clu.service.CluService;
import org.kuali.student.r2.lum.lo.service.LearningObjectiveService;
import org.kuali.student.r2.lum.util.constants.CluServiceConstants;
import org.kuali.student.r2.lum.util.constants.CourseServiceConstants;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Lookupable service class for {@link LoDisplayInfoWrapper} "Search for Learning Objectives" link
 * 
 * @author OpenCollab/rSmart KRAD CM Conversion Alliance!
 */
public class LoDisplayInfoLookupableImpl extends LookupableImpl {

    private static final long serialVersionUID = 3381719326948770678L;
    public static final String QNAME = "http://student.kuali.org/wsdl/organization";
    public static final String ORGANIZATION_SERVICE = "OrganizationService";
    
    private LearningObjectiveService learningObjectiveService;
    private CluService cluService;
    private OrganizationService organizationService;
    
    public enum ProgramStates {
        BACCALAUREATE("kuali.lu.type.credential.Baccalaureate"),
        MASTERS("kuali.lu.type.credential.Masters"),
        PROFESSIONAL("kuali.lu.type.credential.Professional"),
        DOCTORAL("kuali.lu.type.credential.Doctoral"),
        UNDERGRADUATE_CERTIFICATE("kuali.lu.type.credential.UndergraduateCertificate"),
        GRADUATE_CERTIFICATE("kuali.lu.type.credential.GraduateCertificate"),
        CONTINUING_ED("kuali.lu.type.credential.ContinuingEd"),
        MAJOR_DISCIPLINE("kuali.lu.type.MajorDiscipline"),
        VARIATION("kuali.lu.type.Variation"),
        MINOR_DISCIPLINE("kuali.lu.type.MinorDiscipline"),
        CORE_PROGRAM("kuali.lu.type.CoreProgram"),
        HONORS("kuali.lu.type.Honors"),
        LIVING_LEARNING("kuali.lu.type.LivingLearning");
        
        private String key;
        
        ProgramStates(String key) {
            this.key = key;
        }
        
        public String getKey() {
            return key;
        }
        
        public static List<String> getStateKeys() {
            List<String> stateKeys = new ArrayList<String>();
            for (ProgramStates state : values()) {
                stateKeys.add(state.getKey());
            }
            return stateKeys;
        }
    }

    @Override
    public List<?> performSearch(LookupForm form, Map<String, String> searchCriteria, boolean bounded) {
        List<LoDisplayInfoWrapper> loCategories = new ArrayList<LoDisplayInfoWrapper>();
        SearchRequestInfo searchRequest = new SearchRequestInfo();
        searchRequest.setSearchKey(CourseServiceConstants.LO_BY_CATEGORY_CLU_CROSS_SEARCH);
        searchRequest.setSortColumn(CourseServiceConstants.LU_CLU_OFFICIAL_IDENTIFIER_CLU_CODE_RESULT);
        
        List<SearchParamInfo> queryParamValueList = new ArrayList<SearchParamInfo>();
        SearchByKeys searchByKey = SearchByKeys.valueOf(searchCriteria.get(CourseServiceConstants.SEARCHBY_SEARCH));
        String loSearchBy = searchCriteria.get("name");
        String orgType = searchCriteria.get("orgType");

        if(StringUtils.isNotBlank(loSearchBy)){
            if (searchByKey == SearchByKeys.CATEGORY) {
                SearchParamInfo loCategoryParam = new SearchParamInfo(CourseServiceConstants.OPTIONAL_LO_CATEGORY_NAME_PARAM, loSearchBy);
                queryParamValueList.add(loCategoryParam);
            } else if (searchByKey == SearchByKeys.DEPARTMENT) {
                SearchParamInfo codeParam = new SearchParamInfo(CourseServiceConstants.OPTIONAL_CODE_PARAM, loSearchBy);
                queryParamValueList.add(codeParam);
            } else if (searchByKey == SearchByKeys.COURSE){
                SearchParamInfo titleParam = new SearchParamInfo(CourseServiceConstants.SUBJECTCODE_CODE_PARAM, loSearchBy);
                queryParamValueList.add(titleParam);
            } else if (searchByKey == SearchByKeys.KEYWORD){
                SearchParamInfo keywordInLoParam = new SearchParamInfo(CourseServiceConstants.LO_DESC_PLAIN_PARAM, loSearchBy);
                queryParamValueList.add(keywordInLoParam);
            }
        } else if (searchByKey == SearchByKeys.ORGANIZATIONTYPE && StringUtils.isNotBlank(orgType)) {
            SearchParamInfo orgTypeParam = new SearchParamInfo(CourseServiceConstants.OPTIONAL_LU_OPTIONAL_ADMIN_ORG_TYPES_PARAM, orgType);
            queryParamValueList.add(orgTypeParam);
        }

        SearchParamInfo stateParam = new SearchParamInfo(CourseServiceConstants.OPTIONAL_STATE_PARAM, "Active");
        queryParamValueList.add(stateParam);
        
        SearchParamInfo typeParam = new SearchParamInfo();
        typeParam.setKey(CourseServiceConstants.OPTIONAL_TYPE_PARAM);
        if (searchByKey == SearchByKeys.COURSE) {
            typeParam.getValues().add(CluServiceConstants.CREDIT_COURSE_LU_TYPE_KEY);
        } else if (searchByKey == SearchByKeys.DEPARTMENT) {
            typeParam.setValues(ProgramStates.getStateKeys());
        }
        queryParamValueList.add(typeParam);
        
        searchRequest.setParams(queryParamValueList);
        try {
            SearchResultInfo searchResult = getLearningObjectiveService().search(searchRequest, ContextUtils.getContextInfo());
            if (searchResult.getRows()== null || searchResult.getRows().isEmpty()){
                GlobalVariables.getMessageMap().putError(KRADConstants.GLOBAL_ERRORS, CurriculumManagementConstants.L0_MSG_ERROR_NO_LO_IS_FOUND);
            }else {
                for (SearchResultRowInfo result : searchResult.getRows()) {
                    List<SearchResultCellInfo> cells = result.getCells();
                    LoDisplayInfoWrapper loWrapper = new LoDisplayInfoWrapper();
                    for (SearchResultCellInfo cell : cells) {
                        if (CourseServiceConstants.LO_CLU_CODE_RESULT.equals(cell.getKey())) {
                            loWrapper.setCode(cell.getValue());
                        }
                        else if (CourseServiceConstants.LO_CLU_TYPE_RESULT.equals(cell.getKey())) {
                            loWrapper.setTypeName(cell.getValue());
                        }
                        else if (CourseServiceConstants.LO_CLU_STATE_RESULT.equals(cell.getKey())) {
                            loWrapper.setStateKey(cell.getValue());
                        }
                        else if (CourseServiceConstants.LO_CATEGORY_NAME_RESULT.equals(cell.getKey())) {
                            loWrapper.setName(cell.getValue());
                        }
                        else if (CourseServiceConstants.LO_DESC_PLAIN_RESULT.equals(cell.getKey())) {
                            loWrapper.setDescr(new RichTextInfo(cell.getValue(), null));
                        }
                    }
                    loCategories.add(loWrapper);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while searching for Learning Objectives", e);
        }
        return loCategories;
    }
    
    public List<CourseCodeSearchWrapper> searchForCourseCodes(String courseNumber) {
        return CourseCodeSearchUtil.searchForCourseNumbers(courseNumber, getCluService());
    }
    
    public List<OrganizationInfoWrapper> searchForOrganizations(String orgName) {
        return OrganizationSearchUtil.searchForOrganizations(orgName, getOrganizationService());
    }
    
    public List<LoCategoryInfoWrapper> searchForLoCategories(String categoryName) {
        return LoCategorySearchUtil.searchForLoCategories(categoryName, getLearningObjectiveService());
    }
    
    protected LearningObjectiveService getLearningObjectiveService() {
        if (learningObjectiveService == null) {
            learningObjectiveService = GlobalResourceLoader.getService(new QName(LearningObjectiveServiceConstants.NAMESPACE, LearningObjectiveService.class.getSimpleName()));
        }
        return learningObjectiveService;
    }
    
    protected CluService getCluService() {
        if (cluService == null) {
            cluService = GlobalResourceLoader.getService(new QName(CluServiceConstants.CLU_NAMESPACE, CluService.class.getSimpleName()));
        }
        return cluService;
    }   
    
    protected OrganizationService getOrganizationService() {
        if (organizationService == null) {
            organizationService = (OrganizationService) GlobalResourceLoader
                .getService(new QName(QNAME,ORGANIZATION_SERVICE));
        }
        return organizationService;
    }

}
