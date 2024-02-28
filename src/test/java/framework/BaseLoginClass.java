package framework;
import org.testng.annotations.BeforeMethod;

public class BaseLoginClass extends BaseClass{
    @BeforeMethod
    public void beforeMethod() {
        initialization();
        login();
    }
}
