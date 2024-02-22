package pageobjects;

import framework.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass {
    @FindBy(xpath = "//li[@class = 'captionone']")
    private WebElement ATMServicesHeader;

    public String getATMServicesHeader() {
        return ATMServicesHeader.getText();
    }
}
