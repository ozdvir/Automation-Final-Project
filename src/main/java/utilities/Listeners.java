package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends CommonOps implements ITestListener {

    public void onStart (ITestContext execution)
    {
        System.out.println("----------------- Starting execution ----------------------");
    }
    public void onFinish(ITestContext executive)
    {
        System.out.println("----------------- Ending execution ----------------------");

    }
    public void onTestFailedButWithinSuccessPercentage (ITestResult arg0)
    //To do implement this....
    {

    }
    public void onTestSkipped(ITestResult test)
    {
        System.out.println("----------------- Skipping Test:" + test.getName() + " ----------------------");

    }
    public void onTestStart(ITestResult test)
    {
        System.out.println("----------------- Starting Test:" + test.getName() + "Passed ----------------------");

    }
    public void onTestSuccess(ITestResult test)
    {

    }
    public void onTestFailure (ITestResult test)
    {
        System.out.println("----------------- Test:" + test.getName() + "Failed ----------------------");
        saveScreenshot();

    }

    @Attachment(value = "Page Screen-shot", type = "image/png")
    public byte[] saveScreenshot()
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
