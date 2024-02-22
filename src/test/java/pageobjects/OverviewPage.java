package pageobjects;

import framework.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BaseClass {
    @FindBy(css="p[class='smallText'] b")
    private WebElement welcomeText;
    @FindBy(xpath="//li/a[text() = 'home']")
    private WebElement homePageIcon;

    public String getWelcomeText() {

        return welcomeText.getText();
    }

    public HomePage clickHomePageIcon() {
        homePageIcon.click();
        return new HomePage();
    }

}
