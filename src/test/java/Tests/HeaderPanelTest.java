package Tests;

import framework.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class HeaderPanelTest extends BaseClass {
    private static final String ATM_SERVICES = "ATM Services";

    @Test
    public void homePageIcon() {

        //здесь должен быть метод login()
        String ATMServicesHeader = new LoginPage()
                .enterUsername("john")
                .enterPassword("demo")
                .clickLoginButton()
                .clickHomePageIcon()
                .getATMServicesHeader();
        Assert.assertEquals(ATM_SERVICES, ATMServicesHeader);

    }
}
