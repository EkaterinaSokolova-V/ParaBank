package tests;

import framework.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.OverviewPage;

public class LoginTest extends BaseClass {
    private static final String VALID_USERNAME = "john";
    private static final String VALID_PASSWORD = "demo";
    private static final String LOGIN_ERROR_MESSAGE = "Please enter a username and password.";

    @Test
    public void loginCorrectCredentialsTest() {
        String welcomeText = new LoginPage()
                .enterUsername(VALID_USERNAME)
                .enterPassword(VALID_PASSWORD)
                .clickLoginButton(new OverviewPage())
                .getWelcomeText();

        Assert.assertEquals(welcomeText, "Welcome");
    }

    @Test
    public void userNameFieldEmptyTest() {
        String errorMessage = new LoginPage()
                .enterPassword(VALID_PASSWORD)
                .clickLoginButton(new LoginPage())
                .getErrorMessageText();

        Assert.assertEquals(errorMessage, LOGIN_ERROR_MESSAGE);
    }

    @Test
    public void passwordFieldEmptyTest() {
        String errorMessage = new LoginPage()
                .enterUsername(VALID_USERNAME)
                .clickLoginButton(new LoginPage())
                .getErrorMessageText();

        Assert.assertEquals(errorMessage, LOGIN_ERROR_MESSAGE);
    }
}
