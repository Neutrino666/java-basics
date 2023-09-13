package utils.srvices;

import io.restassured.http.Cookies;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserPojoFull;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService extends RestService {

    @Override
    protected String getBasePath() {
        return "/users";
    }

    public UserService(Cookies cookies) {
        super(cookies);
    }

    public CreateUserResponse createUser(UserRequest rq){
        return given().spec(REQ_SPEC).basePath(getBasePath()).body(rq).post().as(CreateUserResponse.class);
    }

    public List<UserPojoFull> getUsers(){
        return given().spec(REQ_SPEC)
                .basePath(getBasePath())
                .get()
                .jsonPath().getList("data", UserPojoFull.class);
    }
}
