package pageobjects;

import framework.BaseClass;
import framework.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {

    @FindBy(xpath="//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath="//input[@value='Log In']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@class='error']")
    private WebElement errorMessage;

    public LoginPage enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public <P> P clickLoginButton(P page) {
            loginButton.click();
            return page;
    }

    public String getErrorMessageText() {

        return errorMessage.getText();
    }
}
