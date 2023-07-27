package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginElements {
    public SelenideElement userField() {return $("#form-username");}
    public SelenideElement passwordField() {return $("#form-password");}
    public SelenideElement submitButton() {return $(".btn.btn-blue");}
    public SelenideElement alertError() {return $("[class='alert alert-error']");}
}
