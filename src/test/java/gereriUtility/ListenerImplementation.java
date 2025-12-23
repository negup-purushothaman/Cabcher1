package gereriUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Genericlabaries.BaseClass;

public class ListenerImplementation implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getMethod().getMethodName();
        String time = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());

        try {
            File src = ((TakesScreenshot) BaseClass.driver)
                    .getScreenshotAs(OutputType.FILE);

            File dest = new File("./ScreenShot/" + testName + "_" + time + ".png");
            dest.getParentFile().mkdirs();

            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot captured for failed test: " + testName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("===== Test Execution Started =====");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("===== Test Execution Finished =====");
    }
}
