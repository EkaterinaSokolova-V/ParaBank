package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    private static WebDriver driver;
    private static Properties prop;

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

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
            driver.get(prop.getProperty("url"));
//            driver.get("https://parabank.parasoft.com/parabank/index.htm");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            System.out.println(driver.getTitle());
        }
//        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(375, 812));
//        driver.manage().deleteAllCookies();
    }
}
