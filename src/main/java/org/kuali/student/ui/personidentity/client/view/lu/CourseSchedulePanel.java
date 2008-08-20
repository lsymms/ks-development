package org.kuali.student.ui.personidentity.client.view.lu;


import java.util.List;

import org.kuali.student.commons.ui.messages.client.Messages;
import org.kuali.student.commons.ui.mvc.client.ApplicationContext;
import org.kuali.student.commons.ui.mvc.client.Controller;
import org.kuali.student.commons.ui.mvc.client.MVC;
import org.kuali.student.commons.ui.mvc.client.model.Model;
import org.kuali.student.commons.ui.mvc.client.widgets.ModelBinding;
import org.kuali.student.commons.ui.propertychangesupport.PropertyChangeEvent;
import org.kuali.student.commons.ui.propertychangesupport.PropertyChangeListener;
import org.kuali.student.commons.ui.propertychangesupport.PropertyChangeListenerProxy;
import org.kuali.student.commons.ui.widgets.tables.ModelTableSelectionListener;
import org.kuali.student.commons.ui.widgets.tables.PagingModelTable.ExposedStyles;
import org.kuali.student.registration.client.controller.RegistrationController;
import org.kuali.student.registration.client.model.RegistrationModelState;
import org.kuali.student.ui.personidentity.client.ModelState;
import org.kuali.student.ui.personidentity.client.controller.LearningUnitController;
import org.kuali.student.ui.personidentity.client.controller.PersonIdentityController;
import org.kuali.student.ui.personidentity.client.model.GwtPersonInfo;
import org.kuali.student.ui.personidentity.client.model.lu.GwtLuiInfo;
import org.kuali.student.ui.personidentity.client.model.lu.LuModelState;
import org.kuali.student.ui.personidentity.client.view.AdminEditPanel;
import org.kuali.student.ui.personidentity.client.view.PersonSearchResultPanel.SelectPersonEvent;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TableListener;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CourseSchedulePanel extends FlowPanel{

    
    final Model<GwtLuiInfo> scheduleModel = new Model<GwtLuiInfo>();
    ModelBinding<GwtLuiInfo> binding = null;
	
	boolean loaded = false;
	VerticalPanel mainPanel = new VerticalPanel();
	///FlexTable scheduleTable = new FlexTable();
	CourseScheduleTable scheduleTable = new CourseScheduleTable();
	
	
    Messages messages = ApplicationContext.getViews().get(AdminEditPanel.VIEW_NAME).getMessages();
    Label scheduleLabel = new Label();
    /*
	private PropertyChangeListener currUserListener
	= new PropertyChangeListenerProxy(
            "currPerson",
            new PropertyChangeListener() {
                public void propertyChange(
                    PropertyChangeEvent propertyChangeEvent) {
                	System.out.println("User change");
                    //updateView( (List<GwtPersonInfo>)propertyChangeEvent.getNewValue());
                    if (ModelState.getInstance().getCurrPerson() == null) {
                        RegistrationController.getInstance().setCurrentUserLuiRelations(null);
                        updateSchedule(null);
                    } else {
                        RegistrationController.getInstance().setCurrentUserLuiRelations(ModelState.getInstance().getCurrPerson().getPersonId());
                        updateSchedule( RegistrationModelState.getInstance().getCurrUserCourses());
                    }
                }
            });
	*/
	private PropertyChangeListener currUserCoursesListener  
	= new PropertyChangeListenerProxy(
            "currUserCourses",
            new PropertyChangeListener() {
                public void propertyChange(
                    PropertyChangeEvent propertyChangeEvent) {
                    //updateView( (List<GwtPersonInfo>)propertyChangeEvent.getNewValue());
                	updateSchedule( RegistrationModelState.getInstance().getCurrUserCourses());
                }
            });
	
	public CourseSchedulePanel()
	{
		//scheduleTable.setTitle("Schedule");
		//scheduleTable.setStyleName("KS-ModelTable");

		//ModelState.getInstance().addPropertyChangeListener(currUserListener);
		RegistrationModelState.getInstance().addPropertyChangeListener(currUserCoursesListener);
		scheduleLabel.addStyleName("KS-Label");
		scheduleLabel.addStyleName("KS-Search-Message");
		
		this.add(getMainPanel());
	}
	
	public Panel getMainPanel()
	{
		mainPanel.add(scheduleLabel);
		mainPanel.add(scheduleTable);
		
		return mainPanel;
	}
	
	public void onLoad() {
	    if (!loaded) {
	        loaded = true;
	        //Model<GwtLuiInfo> model = (Model<GwtLuiInfo>) MVC.findParentController(this).getModel(GwtLuiInfo.class);
	        binding = new ModelBinding<GwtLuiInfo>(scheduleModel, scheduleTable);
	        
	        scheduleTable.addSelectionListener(new ModelTableSelectionListener<GwtLuiInfo>() {
                public void onSelect(GwtLuiInfo modelObject) {
                    LuModelState.getInstance().setCurrLui(modelObject);
                    if (modelObject !=null){
                        LearningUnitController.displayCourseDetails();
                    }
                }
            });
	        /*
	        scheduleTable.addSelectionListener(new ModelTableSelectionListener<GwtPersonInfo>() {
                public void onSelect(GwtPersonInfo modelObject) {
                    //ModelState.getInstance().setCurrPerson(modelObject);
                    //PersonIdentityController.viewPersonDetailsScreen();
                    //Controller c = MVC.findParentController(me);
                   // c.getEventDispatcher().fireEvent(SelectPersonEvent.class, modelObject);
                    //Show the registration panel, can someone find a more elegant way to do this?
                    //((AdminStudentTab)(panel.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent())).addRegistrationTab();
                }
	        });
	        */
	    }
	}
	
	public void updateSchedule(List<GwtLuiInfo> courses)
	{
		if(courses != null)
		{
			if(courses.size() == 0){
				scheduleLabel.setText(messages.get("noSchedule"));
				scheduleTable.setVisible(false);
			}
			else{
				scheduleLabel.setText(messages.get("scheduleTitle"));
				scheduleTable.setVisible(true);
			}
			
			if ( !(scheduleModel.items().containsAll(courses) && courses.containsAll(scheduleModel.items())) ){	
				scheduleModel.clear();			
				if(courses != null)
				{
					for(GwtLuiInfo course: courses)
					{
						scheduleModel.add(course);
					}
				}	
			}
		}
		else
		{
			scheduleLabel.setText(messages.get("noSchedule"));
			scheduleTable.setVisible(false);
		}
		/*
		int rows = scheduleTable.getRowCount();
		for (int j=0; j < rows; j++)
		{
			scheduleTable.removeRow(0);
		}
		*/
			/*
			scheduleTable.setText(0, 0, messages.get("title"));
			scheduleTable.setText(0, 1, messages.get("luiCode"));
			scheduleTable.setText(0, 2, "Full Name");
			scheduleTable.setText(0, 3, messages.get("description"));
			scheduleTable.setText(0, 4, messages.get("Days & Times"));
			scheduleTable.setText(0, 5, "Credits");
			scheduleTable.setText(0, 6, "Start Date");
			scheduleTable.setText(0, 7, "End Date");
			scheduleTable.getRowFormatter().setStyleName(0, ExposedStyles.MODELTABLE_COLUMN_HEADER.toString());
			scheduleTable.getRowFormatter().addStyleName(0, "KS-Column-Font-Color");
			//scheduleTable.getRowFormatter().addStyleName(0, "KS-Header-Links");
			DateTimeFormat df = DateTimeFormat.getShortDateFormat();
			
			int i = 1;
			*/
			/*
			for(GwtLuiInfo course: courses)
			{
				if(course != null)
				{
					scheduleTable.setText(i, 0, course.getCluDisplay().getCluShortName());
					scheduleTable.setText(i, 1, course.getLuiCode());
					scheduleTable.setText(i, 2, course.getCluInfo().getCluLongName());
					scheduleTable.setText(i, 3, course.getCluInfo().getDescription());
					scheduleTable.setText(i, 4, "");
					scheduleTable.setText(i, 5, course.getCluInfo().getAttributes().get("Credits"));
					scheduleTable.setText(i, 6, df.format(course.getCluInfo().getEffectiveStartDate()));
					scheduleTable.setText(i, 7, df.format(course.getCluInfo().getEffectiveEndDate()));
					scheduleTable.getRowFormatter().setStyleName(i, ExposedStyles.MODELTABLE_ROW.toString());
					i++;
				}
			}
			
		}*/
	}
	
}