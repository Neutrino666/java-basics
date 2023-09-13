package utils.srvices;

import io.restassured.http.Cookies;
import pojos.UserPojoFull;

import java.util.List;

import static io.restassured.RestAssured.given;

public class OrderService extends RestService {

    @Override
    protected String getBasePath() {
        return "/orders";
    }

    public OrderService(Cookies cookies) {
        super(cookies);
    }

    public List<UserPojoFull> getOrders(){
        return given().spec(REQ_SPEC)
                .basePath(getBasePath())
                .get()
                .jsonPath().getList("data", UserPojoFull.class);
    }
}
