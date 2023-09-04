package simple.automation;

public class Main {

    private static final User EXISTED_USER = new User("existed", "");
    private static final User NOT_EXISTED_USER = new User("wrong", "");

    public static void main(String[] args) {
//        Main instance = new Main(); // выделена память в Method Area
        new AuthorizationTests().testLogin();

        OrderTests orderTests = new OrderTests();
        orderTests.testCreateOrder();
        orderTests.testListOrder();
    }
}