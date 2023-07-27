package ui.tests.login;

import api.enums.UserRoles;
import api.steps.UserApiSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.steps.LoginPage;
import ui.tests.BaseTest;
import utils.TestDataProvider;

import static api.enums.UserRoles.ADMIN;
import static api.enums.UserRoles.USER;

public class LoginTests extends BaseTest {

    private static final String USERNAME = "bobello";
    private static final String NAME = "Bob";
    private static final String PASSWORD = "123456";
    private static final UserRoles ROLE = USER;

    UserApiSteps userApiSteps = new UserApiSteps();
    private String user_id;

    @BeforeMethod
    public void prepareDataForTest() {
        user_id = userApiSteps.createUser(USERNAME, PASSWORD, NAME, USER);
       // System.out.println(user_id);
    }

    @Test
    public void testLoginByNewUser(){
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD)
                .assertMainPageIsOpened();
    }

    @Test(dataProvider = "nonExistentUsers", dataProviderClass = TestDataProvider.class)
    public void testLoginByUserNegative(String username, String password){
       LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage()
                .loginByUser(username,password);

        loginPage.assertAlertErrorShow();
    }

    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        userApiSteps.removeUser(Integer.parseInt(user_id));
    }






}
