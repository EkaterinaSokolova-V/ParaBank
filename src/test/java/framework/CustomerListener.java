package framework;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CustomerListener extends BaseTest implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Passed Test");
        test.log(LogStatus.PASS, result.getMethod().getMethodName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failed Test");
            try {
                test.log(LogStatus.FAIL,
                        test.addScreenCapture(failed(result.getMethod().getMethodName())) +
                                result.getMethod().getMethodName());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
