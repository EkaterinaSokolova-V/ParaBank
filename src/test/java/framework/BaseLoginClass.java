package framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLoginClass extends BaseTest{
    @BeforeMethod
    public void beforeMethod() {
        initialization();
        login();
    }

    @AfterMethod
    public void afterMethod() {
        getDriver().close();
        getDriver().quit();
    }
}
