package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.BaseClass;

import java.io.IOException;

public class ListenersNG extends BaseClass implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extentReport;
    public ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/MyReport.html");
        sparkReporter.config().setDocumentTitle("Automation Testing Report");
        sparkReporter.config().setReportName("Functional Report");
        sparkReporter.config().setTheme(Theme.DARK);
        extentReport = new ExtentReports();
        extentReport.attachReporter(sparkReporter);
        extentReport.setSystemInfo("System", "Localhost");
        extentReport.setSystemInfo("Environment", "STAGE");
        extentReport.setSystemInfo("Operating System", "Windows");
        extentReport.setSystemInfo("QA Name", "Sunil Kohar");
        extentReport.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return ITestListener.super.isEnabled();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        extentReport.createTest(result.getMethod().getMethodName() + " started execution");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        extentTest = extentReport.createTest(result.getMethod().getMethodName()  );
        extentTest.log(Status.PASS, "Test case passed is: " +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        extentTest = extentReport.createTest(result.getMethod().getMethodName());
        extentTest.fail("the test case" + result.getMethod().getMethodName() + " failed because of the error "
                + result.getThrowable());
//        try {
//            driver = (WebDriver) result.getClass().getField("driver").get(result.getInstance());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        String filepath;
        try {
            filepath = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        extentTest = extentReport.createTest(result.getMethod().getMethodName());
        extentTest.log(Status.SKIP, "Test case skipped is: " +result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        extentReport.flush();
    }
}

