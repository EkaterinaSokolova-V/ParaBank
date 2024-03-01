package framework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;

public class BaseClass extends BaseTest{

    @BeforeClass
    public void beforeClass() {
        report = new ExtentReports(System.getProperty("user.dir") + "/reports/" + "Report_" + getCurrentTimeStamp() + ".html");
        test = report.startTest("Selenium tests");
    }

    @BeforeMethod
    public void beforeMethod() {
        initialization();
    }

    @AfterMethod
    public void afterMethod() {
        getDriver().close();
        getDriver().quit();
        System.out.println("Driver close and quit");
    }

    @AfterClass
    public void afterClass() {
        report.endTest(test);
        report.flush();
    }
}
