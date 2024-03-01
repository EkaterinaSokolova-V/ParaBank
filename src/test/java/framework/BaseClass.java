package framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass extends BaseTest{

    @BeforeMethod
    public void beforeMethod() {
        initialization();
    }

    @AfterMethod
    public void afterMethod() {
        getDriver().close();
        getDriver().quit();
        System.out.println("Driver close and quit");
    }
}
