package api.tests.users;

import api.enums.UserRoles;
import api.steps.UserApiSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static api.enums.UserRoles.USER;

public class RemoveUserTest {

    private static final String USERNAME = "bob_black";
    private static final String PASSWORD = "123456";
    private static final String NAME = "Bob";
    private static final UserRoles ROLE = USER;
    private static String user_id;

    UserApiSteps userApiSteps = new UserApiSteps();

    @BeforeMethod
    public void prepareDataForTest() {
        user_id = userApiSteps.createUser(USERNAME, PASSWORD, NAME,ROLE);
    }

    @Test(description = "Checks positive user deletion.")
    public void testRemoveUserPositive() {
        user_id = userApiSteps.removeUser(Integer.parseInt(user_id));
        Assert.assertNotEquals(user_id, "false", "User wasn't deleted.");
    }
}
