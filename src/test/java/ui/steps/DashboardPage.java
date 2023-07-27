package ui.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ui.elements.DashboardElements;


public class DashboardPage extends DashboardElements {
    public LoginPage openUserDashboardPage() {
        Selenide.open("/dashboard");
        return new LoginPage();
    }
    public DashboardPage assertMainPageIsOpened(){
        mainSection().shouldBe(Condition.visible);
        return this;
    }

    public ProjectModalForm ClickNewProjectButton(){
        newProjectHeader().shouldBe(Condition.visible).click();
        return new ProjectModalForm();
    }



}
