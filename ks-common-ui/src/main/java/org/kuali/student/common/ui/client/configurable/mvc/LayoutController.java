package org.kuali.student.common.ui.client.configurable.mvc;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.student.common.ui.client.application.Application;
import org.kuali.student.common.ui.client.event.ValidateResultEvent;
import org.kuali.student.common.ui.client.event.ValidateResultHandler;
import org.kuali.student.common.ui.client.mvc.Controller;
import org.kuali.student.common.ui.client.mvc.View;
import org.kuali.student.common.ui.client.mvc.dto.ModelDTO;
import org.kuali.student.common.ui.client.mvc.dto.ModelDTOValue.ModelDTOType;
import org.kuali.student.common.ui.client.validator.ModelDTOConstraintSetupFactory;
import org.kuali.student.common.ui.client.validator.SectionContraintSetupFactory;
import org.kuali.student.common.validator.ConstraintSetupFactory;
import org.kuali.student.common.validator.Validator;
import org.kuali.student.core.dictionary.dto.ObjectStructure;
import org.kuali.student.core.validation.dto.ValidationResultContainer;
import org.kuali.student.core.validation.dto.ValidationResultInfo;
import org.kuali.student.core.validation.dto.ValidationResultInfo.ErrorLevel;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

public abstract class LayoutController extends Controller  {
    private ModelDTO modelDTO;
    private LayoutController parentLayoutController= null; 
    private Map<String, String> classToObjectKeyMap = new HashMap<String, String>();

    
	protected final HashMap<String, View> sectionViewMap = new HashMap<String, View>();	
	
    public LayoutController(){
		addApplicationEventHandler(ValidateResultEvent.TYPE, new ValidateResultHandler() {
            @Override
            public void onValidateResult(ValidateResultEvent event) {
               List<ValidationResultContainer> list = event.getValidationResult();
               LayoutController.this.processValidationResults(list);
            }
        });
    }
    
    public void processValidationResults(List<ValidationResultContainer> list){
    	Collection<View> sections = sectionViewMap.values();
        for(View v: sections){
     	   if(v instanceof SectionView){
     		   ((SectionView) v).processValidationResults(list);
     	   }
        }
    }
    
    public ErrorLevel checkForErrors(List<ValidationResultContainer> list){
		ErrorLevel errorLevel = ErrorLevel.OK;
		
		for(ValidationResultContainer vr: list){
			if(vr.getErrorLevel().getLevel() > errorLevel.getLevel()){
				errorLevel = vr.getErrorLevel();
			}
			if(errorLevel.equals(ErrorLevel.ERROR)){
				break;
			}
		}
    	
    	return errorLevel;
    	
    }
    
    public void setModelDTO(ModelDTO dto, Map<String, String> classToObjectKeyMap){
        modelDTO = dto;
        this.classToObjectKeyMap = classToObjectKeyMap;
        super.addApplicationEventHandler(ValidateResultEvent.TYPE, new ValidateResultHandler() {
            @Override
            public void onValidateResult(ValidateResultEvent event) {
               List<ValidationResultContainer> list = event.getValidationResult();
               if(list == null || list.size() == 0 ){
                   return;
               }
               String ele = "";
               for(ValidationResultContainer vc: list){
                   ele += vc.getElement()+":";    
                   List<ValidationResultInfo> vrList = vc.getValidationResults();
                   for(ValidationResultInfo vr: vrList){
                       ele += vr.getMessage()+"\n\n";
                   }
               }
               Window.alert("Error:\n"+ele);
              // System.out.println(ele);
            }
        });
    }
    public ModelDTO getModel(){
        return modelDTO;
    }
    public void validate(Section section){
        ModelDTOConstraintSetupFactory bc = new ModelDTOConstraintSetupFactory();
        
//        
//        Validator val = new Validator(bc, true);

        final ValidateResultEvent e = new ValidateResultEvent();
        //getModel().keySet();
        ModelDTO model = getModel();
        for(String key: model.keySet()){
        	ModelDTO currentModel = ((ModelDTOType) model.get(key)).get();
        	String objectKey = classToObjectKeyMap.get(currentModel.getClassName());
        	ObjectStructure objStructure = Application.getApplicationContext().getDictionaryData(objectKey);
            if(objStructure == null){
               Window.alert("Cannot load dictionary(object structure)");
            }
            
            //ConstraintSetupFactory sectionbc = new SectionContraintSetupFactory(section,bc.getDataProvider(currentModel));
            //Validator val = new Validator(sectionbc, true);
            Validator val = new Validator(bc, true);
            
            List<ValidationResultContainer> results = val.validateTypeStateObject(currentModel, objStructure);
            e.addValidationResult(results);// filled by calling the real validate code
        }
        fireApplicationEvent(e);

    }
    public static LayoutController findParentLayout(Widget w){
        LayoutController result = null;
        while (true) {
            w = w.getParent();
            if (w == null) {
                break;
            } else if (w instanceof Controller) {
                result = (LayoutController) w;
                break;
            } 
        }
        return result;
    }
    public void setParentLayout(LayoutController controller) {
        parentLayoutController = controller;
    }
    public LayoutController getParentLayout() {
        if (parentLayoutController == null) {
            parentLayoutController = LayoutController.findParentLayout(this);
        }
        return parentLayoutController;
    }    
}
