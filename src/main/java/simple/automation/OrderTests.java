package simple.automation;

import org.junit.Test;

public class OrderTests extends BaseTestWithOrder{

    public void testCreateOrder(){
        System.out.println("Check that order created");
    }

    @Test
    public void testListOrder(){
        System.out.println("list orders");
        System.out.println("check that order is displayed");
    }
}
