package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProjectModalFormElements {
    public SelenideElement projectCreationForm() {return $("#project-creation-form");}
    public SelenideElement projectNameField() {return $("#form-name");}
    public SelenideElement saveButton() {return $(".btn.btn-blue");}

}
