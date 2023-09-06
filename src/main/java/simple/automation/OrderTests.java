package simple.automation;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import javax.management.relation.Role;
import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@Smoke
public class OrderTests{

//    @BeforeAll
    @BeforeEach
    public void createOrder() {
        System.out.println("Create order");
    }
    @Test
    public void testCreateOrder(){
        System.out.println("Check that order created");
    }

    @Test
    @Tag("orders")
    public void testListOrders(){
        System.out.println("list orders");
        System.out.println("check that order is displayed");
        Assertions.assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("test");
        });
    }



    //    @ValueSource(strings = {"manager", "manager of managers", "manager of managers, of managers"})
    @ParameterizedTest
    //    @EnumSource(names = "MANAGER")
    //    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = "MANAGER")
    //    @EnumSource(mode = EnumSource.Mode.MATCH_ALL, names = ".*_MA.*")
    //    public void testListOrdersAsManager(Roles role){
    //@MethodSource("getRoles")
    //public void testListOrdersAsManager(Roles role){
//    @CsvSource
    @MethodSource  // передача больше 1 аргумента
    public void testListOrdersAsManager(Roles role, String orderType){
        System.out.println("list orders as " + role.getDescription());
        System.out.println("check that order is displayed " + orderType);
    }

//    static Stream<Roles> getRoles(){
//        return Stream.of(Roles.MANAGER, Roles.SENIOR_MANAGER);
//    }
    static Stream<Arguments> testListOrdersAsManager(){  // передача больше 1 аргумента
        return Stream.of(
                arguments(Roles.MANAGER, "orders of manager"),
                arguments(Roles.SENIOR_MANAGER, "orders of senior")
        );
    }

    enum Roles{
        MANAGER("manager"),
        SENIOR_MANAGER("manager of managers"),
        LEAD_MANAGER("manager of managers of managers");

        Roles(String description){
            this.description = description;
        }

        private String description;
        public String getDescription(){
            return description;
        }

    }

//    @AfterAll
    @AfterEach
    public void deleteOrder(){
        System.out.println("Delete order");
    }
}
