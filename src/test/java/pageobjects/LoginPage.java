package pageobjects;

import framework.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {

    @FindBy(xpath="//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath="//input[@value='Log In']")
    private WebElement loginButton;

    public LoginPage enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public OverviewPage clickLoginButton() {
        loginButton.click();
        return new OverviewPage();
    }
}
