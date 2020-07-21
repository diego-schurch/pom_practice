package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestClass {

    @Test
    public void loginTest() {
        System.out.println("This is the test for SecondTestClass");
        Assert.assertEquals(1,1);
    }
}
