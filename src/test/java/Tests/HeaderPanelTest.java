package Tests;

import framework.BaseLoginClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.OverviewPage;

public class HeaderPanelTest extends BaseLoginClass {
    private static final String ATM_SERVICES = "ATM Services";
    private static final String ABOUT_HEADER = "ParaSoft Demo Website";

    @Test
    public void homePageIconTest() {

        String ATMServicesHeader = new OverviewPage()
                .clickHomePageIcon()
                .getATMServicesHeader();

        Assert.assertEquals(ATM_SERVICES, ATMServicesHeader);
    }

    @Test
    public void aboutIconTest() {
        String mainAboutPageHeader = new OverviewPage()
                .clickAboutIcon()
                .getAboutPageHeader();

        Assert.assertEquals(ABOUT_HEADER, mainAboutPageHeader);
    }
}
