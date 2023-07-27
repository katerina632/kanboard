package ui.steps;

import com.codeborne.selenide.Condition;
import ui.elements.ProjectModalFormElements;
import ui.elements.ProjectSummaryElements;

public class ProjectModalForm extends ProjectModalFormElements {
     /* public DashboardPage assertNewProjectFormOpened() {
        newProjectHeader().shouldBe(Condition.visible).click();
        projectCreationForm().shouldBe(Condition.visible);
        return this;
    }*/

    public ProjectSummaryPage createNewProject(String name) {
        projectNameField().shouldBe(Condition.visible).sendKeys(name);
        saveButton().shouldBe(Condition.visible).click();
        return new ProjectSummaryPage();
    }

}
