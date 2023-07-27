package ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.EnvProperties.*;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
       // String browser = System.getProperty("browser");
        //String headless = System.getProperty("headless");

        Configuration.browser = BROWSER;
        Configuration.headless = HEADLESS;
        Configuration.baseUrl = BASE_URL;
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
