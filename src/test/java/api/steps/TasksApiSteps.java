package api.steps;

import api.models.args.tasks.CreateTask;
import api.models.args.tasks.RemoveTask;

import static api.methods.Tasks.CREATE_TASK;
import static api.methods.Tasks.REMOVE_TASK;

public class TasksApiSteps extends BaseApiSteps{

    public String createTask(String title, Integer project_id){
        CreateTask bodyModelArgs = CreateTask.builder()
                .title(title)
                .project_id(project_id)
                .build();

        return baseApiStep(CREATE_TASK,bodyModelArgs);
    }

    public String removeTask(Integer task_id ) {
        return baseApiStep(REMOVE_TASK,new RemoveTask(task_id));
    }

}
