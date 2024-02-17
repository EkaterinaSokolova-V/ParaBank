package pageobjects;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {
//    By enterUserNameField = By.xpath("//input[@name='username']");
    @FindBy(xpath="//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath="//input[@value='Log In']")
    private WebElement loginButton;

    public LoginPage enterUsername(String username) {
        getWait10().until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='username']")))).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        getWait10().until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='password']")))).sendKeys(password);
        return this;
    }

    public OverviewPage clickLoginButton() {
        getWait10().until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@value='Log In']")))).click();
        return new OverviewPage();
    }
}
