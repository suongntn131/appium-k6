package learning.lesson_20;

import org.testng.annotations.*;

public class TestNGHook01 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("\t--> Before Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("\t\t--> Before Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\t\t\t--> Before Method");
    }

    //================
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("\t--> After Test");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("\t\t--> After Class");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("\t\t\t--> After Method");
    }

    @Test
    public void testA(){
        System.out.println("\t\t\t\tTest A");
    }

    @Test
    public void testB(){
        System.out.println("\t\t\t\tTest B");
    }
}
