package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProjectSummaryElements {

    public SelenideElement projectTitleLabel() {return $("span.title");}
}
