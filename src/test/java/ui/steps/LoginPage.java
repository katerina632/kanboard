package ui.steps;

import com.codeborne.selenide.Selenide;
import ui.elements.LoginElements;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage extends LoginElements {

    public LoginPage openLoginPage() {
        Selenide.open("");
        return new LoginPage();
    }

    public DashboardPage loginByUser(String username, String password) {
        userField().shouldBe(visible).sendKeys(username);
        passwordField().shouldBe(visible).sendKeys(password);
        submitButton().shouldBe(visible).click();
        return new DashboardPage();
    }

    public LoginPage assertAlertErrorShow(){
        alertError().shouldBe(visible);
        return this;
    }
}
