package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

//    mvn test
//    mvn test -Dtest=JAVACLASS
//    mvn test -Dtest=JAVACLASS#METHODNAME
//    mvn test -Dgroups=GROUPNAME

    @Test
    public void loginTest() {
        Assert.assertEquals(1,1);
    }

    @Test
    public void failureTest() {
        Assert.assertTrue( true );
    }

    @Test
    public void testTrue() {
        Assert.assertFalse( false );
    }

    @Test
    public void testFalse() {
        Assert.assertNotEquals( 1,2 );
    }

    @Test
    public void dummyTest() {
        Assert.assertTrue( 1 > 0 );
    }

}


