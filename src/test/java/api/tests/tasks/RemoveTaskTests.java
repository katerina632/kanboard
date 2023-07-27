package api.tests.tasks;

import api.steps.ProjectApiSteps;
import api.steps.TasksApiSteps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveTaskTests {
    private static final String TASK_TITLE = "Test Task Title";
    TasksApiSteps tasksApiSteps = new TasksApiSteps();
    private String task_id,project_id;
    private static final String PROJECT_NAME = "Test Project";
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();

    @BeforeMethod
    public void prepareDataForTest() {
        project_id = projectApiSteps.createProject(PROJECT_NAME);
        task_id = tasksApiSteps.createTask(TASK_TITLE,Integer.parseInt(project_id));}


    @Test(description = "Checks positive task deletion.")
    public void testRemoveTask() {
        String actualResult = tasksApiSteps.removeTask(Integer.parseInt(task_id));
        System.out.println("Actual result: " + actualResult);
        Assert.assertNotEquals(actualResult, "false", "Task wasn't deleted.");
    }

    @AfterMethod(alwaysRun = true)
    public void removeDataAfterTest(){
        projectApiSteps.removeProject(Integer.parseInt(project_id));
    }
}
