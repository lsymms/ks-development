package org.kuali.student.lum.program.client.edit;

import org.kuali.student.common.ui.client.mvc.View;
import org.kuali.student.lum.program.client.ProgramController;
import org.kuali.student.lum.program.client.ProgramSections;
import org.kuali.student.lum.common.client.configuration.AbstractConfiguration;
import org.kuali.student.lum.program.client.properties.ProgramProperties;
import org.kuali.student.lum.program.client.requirements.ProgramRequirementsViewController;

import com.google.gwt.user.client.ui.Widget;

/**
 *
 */
public class ProgramRequirementsEditConfiguration extends AbstractConfiguration {

    private ProgramController viewController;

    @Override
    public View getView() {
        return new ProgramRequirementsViewController(viewController, ProgramProperties.get().program_menu_sections_requirements(), ProgramSections.PROGRAM_REQUIREMENTS_EDIT, false);
    }

    public void setViewController(ProgramController viewController) {
        this.viewController = viewController;
    }

    @Override
    public Widget asWidget() {
        return viewController;
    }

    @Override
    public Enum<?> getName() {
        return ProgramSections.PROGRAM_REQUIREMENTS_EDIT;
    }
}
