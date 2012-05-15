/*
 * Copyright 2011 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 1.0 (the
 * "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.kuali.student.r2.common.util.constants;

import org.kuali.student.enrollment.courseoffering.dto.ActivityOfferingInfo;
import org.kuali.student.enrollment.courseoffering.dto.CourseOfferingInfo;
import org.kuali.student.enrollment.courseoffering.dto.RegistrationGroupInfo;
import org.kuali.student.enrollment.courseoffering.dto.SeatPoolDefinitionInfo;
import org.kuali.student.r2.common.constants.CommonServiceConstants;

/**
 * Course Offering Service Constants
 * @see LuiServiceConstants
 *
 * @author nwright
 */
public class CourseOfferingServiceConstants {

    public static final String NAMESPACE = CommonServiceConstants.REF_OBJECT_URI_GLOBAL_PREFIX + "courseOffering";
    public static final String SERVICE_NAME_LOCAL_PART = "coService";
    public static final String REF_OBJECT_URI_COURSE_OFFERING = NAMESPACE + "/" + CourseOfferingInfo.class.getSimpleName();
    public static final String REF_OBJECT_URI_ACTIVITY_OFFERING = NAMESPACE + "/" + ActivityOfferingInfo.class.getSimpleName();
    public static final String REF_OBJECT_URI_REGISTRATION_GROUP = NAMESPACE + "/" + RegistrationGroupInfo.class.getSimpleName();
    public static final String REF_OBJECT_URI_SEAT_POOL_DEFINITION = NAMESPACE + "/" + SeatPoolDefinitionInfo.class.getSimpleName();


    //dynamic attribute keys
    public static final String WAIT_LIST_LEVEL_TYPE_KEY_ATTR = "kuali.attribute.wait.list.level.type.key";
    public static final String GRADE_ROSTER_LEVEL_TYPE_KEY_ATTR = "kuali.attribute.grade.roster.level.type.key";
    public static final String COURSE_EVALUATION_INDICATOR_ATTR = "kuali.attribute.course.evaluation.indicator";
    public static final String FINAL_EXAM_INDICATOR_ATTR = "kuali.attribute.final.exam.indicator ";
    public static final String FUNDING_SOURCE_ATTR = "kuali.attribute.finding.source";
    public static final String FEES_ATTACHED_FLAG_ATTR = "kuali.attribute.where.fees.attached.flag";
    public static final String MAX_ENROLLMENT_IS_ESTIMATED_ATTR = "kuali.attribute.max.enrollment.is.estimate";
    public static final String WHERE_FEES_ATTACHED_FLAG_ATTR = "kuali.attribute.where.fees.attached.flag ";
    public static final String IS_MAX_ENROLLMENT_ESTIMATE_ATTR = "kuali.attribute.max.enrollment.is.estimate";
    public static final String HONORS_OFFERING_INDICATOR_ATTR = "kuali.attribute.honors.offering.indicator";
    public static final String WAIT_LIST_INDICATOR_ATTR = "kuali.attribute.wait.list.indicator";


    // The type/states are defined in LuiServiceConstants.java
}
