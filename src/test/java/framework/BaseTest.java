package framework;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseTest {
    private static WebDriver driver;
    private static Properties prop;
    public static ExtentReports report;
    public static ExtentTest test;
    public BaseTest() {
        PageFactory.initElements(driver, this);
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/" + "test/resources/config.properties");
            prop.load(ip);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {

        return driver;
    }

    protected WebDriverWait getWait10() {

        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void login() {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(prop.getProperty("username"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
            driver.get(prop.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            System.out.println(driver.getTitle());
        }
//        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(375, 812));
//        driver.manage().deleteAllCookies();
    }

    public String failed(String methodName) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File(System.getProperty("user.dir") + "/screenshots/" + methodName + "_" + getCurrentTimeStamp() + "_out.png");
        FileUtils.copyFile(srcFile, Dest);
        String errflpath = Dest.getAbsolutePath();
        return errflpath;
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd_MM_yyyy_HH_ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}
