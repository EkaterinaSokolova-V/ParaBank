package pageobjects;

import framework.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends BaseClass {
    @FindBy(xpath = "//h1")
    WebElement mainHeader;

    public String getAboutPageHeader() {

        return mainHeader.getText();
    }
}
