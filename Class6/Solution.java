import org.testng.Assert;
import org.testng.annotations.*;

public class Solution {

    //1
    @BeforeClass
    public static void beforeAll(){
        System.out.println("@BeforeClass");
    }

    @BeforeMethod
    public void beforeEach(){
        System.out.println("@BeforeMethod");
    }

    @Test
    public void firstTest(){
        System.out.println("@Test");
    }

    @AfterMethod
    public void afterEach(){
        System.out.println("@AfterMethod");
    }

    @AfterClass
    public void afterAll(){
        System.out.println("@AfterClass");
    }

    //2
    @Test
    public void assertTest(){
        int x = 1;
        int y = 2;
        Assert.assertNotEquals(x,y);
    }

    //3
    @Test(priority = 1)
    public void printA(){
        System.out.println("A");
    }

    @Test(priority = 2)
    public void printB(){
        System.out.println("B");
    }

    @Test(priority = 3)
    public void printC(){
        System.out.println("C");
    }
}
