package api.tests.projects;

import api.steps.ProjectApiSteps;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreateProjectTests {

    private static final String NAME = "Test Project";
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    private static String actualResultProjectId;

    @Test(description = "Checks positive project creation")
    public void testCreateProject() {
        actualResultProjectId = projectApiSteps.createProject(NAME);
        Assert.assertNotEquals(actualResultProjectId, "false", "Project wasn't created.");
        System.out.println("Actual result: " + actualResultProjectId);
    }

    @AfterMethod(alwaysRun = true)
    public void removeDataAfterTest(){
        projectApiSteps.removeProject(Integer.parseInt(actualResultProjectId));
    }


}
