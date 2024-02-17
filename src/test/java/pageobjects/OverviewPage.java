package pageobjects;

import framework.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewPage extends BaseClass {
    @FindBy(css="p[class='smallText'] b")
    private WebElement welcomeText;
    @FindBy(xpath="//li/a[text() = 'home']")
    private WebElement homePageIcon;

    public String getWelcomeText() {

        return getWait10().until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p[class='smallText'] b")))).getText();
    }

}
