package api.steps;

import api.models.args.BaseModel;
import api.models.args.baseArgs.BodyArgs;
import api.models.args.baseArgs.ResultArgs;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;
import static utils.EnvProperties.API_URL;

public class BaseApiSteps {
    public Response postRequest( BodyArgs bodyArgs){
        return RestAssured.given()
                .auth().basic(API_USERNAME, API_TOKEN)
                .body(bodyArgs)
                .post(API_URL);
    }

    public String baseApiStep(String method, BaseModel bodyModelArgs) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .method(method)
                .params(bodyModelArgs)
                .build();

        Response response = postRequest(bodyArgs);
        response.then().statusCode(200);

        return response.as(ResultArgs.class).getResult().toString();

    }
}
