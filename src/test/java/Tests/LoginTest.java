package Tests;

import framework.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class LoginTest extends BaseClass {
    @Test
    public void loginCorrectCredentialsTest() {
        String welcomeText = new LoginPage()
                .enterUsername("john")
                .enterPassword("demo")
                .clickLoginButton()
                .getWelcomeText();

        Assert.assertEquals(welcomeText, "Welcome");
    }
}
