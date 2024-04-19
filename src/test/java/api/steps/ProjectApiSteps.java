package api.steps;

import api.models.args.projects.CreateProject;
import api.models.args.projects.ProjectName;
import api.models.args.projects.RemoveProject;

import static api.methods.Projects.*;

public class ProjectApiSteps extends BaseApiSteps{

    public String createProject(String name) {
        CreateProject bodyModelArgs = CreateProject.builder()
                .name(name)
                .build();
        return baseApiStep(CREATE_PROJECT,bodyModelArgs);
    }


    public String removeProject(Integer project_id) {
       return baseApiStep(REMOVE_PROJECT,new RemoveProject(project_id));
    }

    public String getProjectPropertiesByName(String name) {

        return baseApiStep(GET_PROJECT_BY_NAME, new ProjectName(name));
    }


}
