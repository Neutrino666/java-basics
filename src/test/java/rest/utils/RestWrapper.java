package rest.utils;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import rest.pojos.UserLogin;
import rest.utils.srvices.OrderService;
import rest.utils.srvices.UserService;

import static io.restassured.RestAssured.given;

public class RestWrapper {
    private static final String BASE_URL = "https://reqres.in/api";
//    private Cookies cookies; // можно и не хранить, но иногда полезно создать метод для получения cookies

    public UserService user;
    public OrderService order;

    private RestWrapper(Cookies cookies) {
//        this.cookies = cookies;

        user = new UserService(cookies);
        order = new OrderService(cookies);
    }

    public static RestWrapper loginAs(String login, String password){
        Cookies cookies = given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .basePath("/login")
                .body(new UserLogin(login, password))
                .post()
                .getDetailedCookies();

        return new RestWrapper(cookies);
    }
}
