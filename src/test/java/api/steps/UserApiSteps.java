package api.steps;

import api.enums.UserRoles;
import api.models.args.users.CreateUser;
import api.models.args.users.RemoveUser;

import static api.enums.UserRoles.ADMIN;
import static api.enums.UserRoles.USER;
import static api.methods.Users.CREATE_USER;
import static api.methods.Users.REMOVE_USER;

public class UserApiSteps extends BaseApiSteps{
    public String createUser(String username, String password, String name, UserRoles role) {
        CreateUser bodyModelArgs = CreateUser.builder()
                .username(username)
                .password(password)
                .name(name)
                .email(username + "@test.com")
                .role(role.getRole())
                .build();

        return baseApiStep(CREATE_USER,bodyModelArgs);
    }

    public String removeUser(int user_id) {

        return baseApiStep(REMOVE_USER,new RemoveUser(user_id));
    }

}
