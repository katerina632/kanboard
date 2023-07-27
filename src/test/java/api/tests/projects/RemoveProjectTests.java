package api.tests.projects;

import api.steps.ProjectApiSteps;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveProjectTests {

    private static final String NAME = "Test Project";
    private String project_id;
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();

    @BeforeMethod
    public void prepareDataForTest() {
        project_id = projectApiSteps.createProject(NAME);
    }

    @Test(description = "Checks positive project deletion.")
    public void testRemoveProject() {
        String actualResult = projectApiSteps.removeProject(Integer.parseInt(project_id));
        System.out.println("Actual result: " + actualResult);
        Assert.assertNotEquals(actualResult, "false", "Project wasn't deleted.");
    }
}
