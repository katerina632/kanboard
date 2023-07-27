package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardElements {
    public SelenideElement mainSection() {
        return $("#main");
    }
    public SelenideElement newProjectHeader () {
        return $("section section a[href=\"/project/create\"]");
    }



}
