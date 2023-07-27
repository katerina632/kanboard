package ui.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ui.elements.ProjectSummaryElements;

public class ProjectSummaryPage extends ProjectSummaryElements {


    public String assertProjectTitleIsPresent() {
       return projectTitleLabel().shouldBe(Condition.visible).text();
    }

    public LoginPage openProjectSummaryPage(Integer projectId){
        Selenide.open("/project/"+projectId);
        return new LoginPage();
    }
}
