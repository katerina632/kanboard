package api.tests.users;

import api.enums.UserRoles;
import api.steps.UserApiSteps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static api.enums.UserRoles.USER;

public class CreateUserTests {

    private static final String USERNAME = "bob_black";
    private static final String PASSWORD = "123456";
    private static final String NAME = "Bob";
    private static final UserRoles ROLE = USER;
    private static String user_id;

    UserApiSteps userApiSteps = new UserApiSteps();

    @Test(description = "Checks positive user creation.")
    public void testCreateUser(){
        user_id = userApiSteps.createUser(USERNAME, PASSWORD, NAME,ROLE);
        Assert.assertNotEquals(user_id,"false", "User wasn't created.");
        System.out.println("Actual result: " + user_id);
    }

    @AfterMethod(alwaysRun = true)
    public void removeDataAfterTest(){
        userApiSteps.removeUser(Integer.parseInt(user_id));
    }
}
