package ui.tests.project;

import api.enums.UserRoles;
import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.steps.DashboardPage;
import ui.steps.LoginPage;
import ui.tests.BaseTest;

import static api.enums.UserRoles.ADMIN;

public class ProjectTests extends BaseTest {

    private static final String USERNAME = "bobello";
    private static final String NAME = "Bob";
    private static final String PASSWORD = "123456";

    private static final UserRoles ROLE = ADMIN;
    private static final String PROJECT_NAME = "Test Project";

    UserApiSteps userApiSteps = new UserApiSteps();
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    String user_id;


    @BeforeMethod
    public void prepareDataForTest() {
        user_id = userApiSteps.createUser(USERNAME, PASSWORD, NAME,ROLE);
        // System.out.println(user_id);
    }

    @Test
    public void testCreateProject(){
       String projectTitleActual = new DashboardPage()
                .openUserDashboardPage()
                .loginByUser(USERNAME, PASSWORD)
                .ClickNewProjectButton()
                .createNewProject(PROJECT_NAME)
                .assertProjectTitleIsPresent();
        //System.out.println(projectTitleActual);

        Assert.assertEquals(projectTitleActual,PROJECT_NAME, "Project wasn't created.");
    }

    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {

        userApiSteps.removeUser(Integer.parseInt(user_id));

      /*  String result = projectApiSteps.getProjectPropertiesByName(PROJECT_NAME);
        int indexOfEquals = result.indexOf('=');
        int indexOfComma = result.indexOf(',');
        Integer valueString = Integer.parseInt(result.substring(indexOfEquals + 1, indexOfComma).trim());

        projectApiSteps.removeProject(valueString);*/
    }


}
