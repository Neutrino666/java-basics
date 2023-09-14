package rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import rest.pojos.UserRequest;
import rest.pojos.CreateUserResponse;
import rest.pojos.UserPojoFull;
import rest.steps.UsersSteps;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RestTest {

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setBasePath("/users")
                    .setContentType(ContentType.JSON)
                    .build();

    @Test
    public void getUsers() {
//        given()
        List<String> emails = given()
                .spec(REQ_SPEC)
                .when().get()
                .then().statusCode(200)
//                .extract().asString();
                .extract().jsonPath().getList("data.email");    // вернет список строк email
//                .body("data[0].email", equalTo("george.bluth@reqres.in"));
//                .body("data.find{it.email == 'george.bluth@reqres.in'}.first_name",
//                        equalTo("George"));     // в лямбда функции перебирает массив data по email достает имя first_name
//                                                        // и проверяет с именем "George"
    }

    @Test
    public void getUsers1() {
        List<UserPojoFull> users = UsersSteps.getUsers();
        assertThat(users).extracting(UserPojoFull::getEmail).contains("george.bluth@reqres.in");
    }

    @Test public void createUser(){
        UserRequest rq = new UserRequest();
        rq.setName("simple");
        rq.setJob("automation");

        CreateUserResponse rs = given()
                .spec(REQ_SPEC)
                .body(rq)
                .when().post()
                .then().extract().as(CreateUserResponse.class);

        assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(rq.getName());
    }
}
