import application.Shkaf;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import driver.DesiredCapab;
import io.appium.java_client.ios.IOSDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.GetScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

    public Shkaf shkaf;
    public static IOSDriver driver;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static ExtentHtmlReporter htmlReporter;

    @BeforeSuite
    public void initReport()
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.home")
                + File.separator + "Reports" + File.separator + "AutomatedTestReport_"
                + new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa").format(new Date()) + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Shkaf Tests Report");
        htmlReporter.config().setReportName("IOS: Automated Test Report");
    }

    @BeforeMethod
    public void setupDriver() throws MalformedURLException, IllegalAccessException {
        driver = DesiredCapab.setup();
        shkaf = new Shkaf(driver);
    }

    @AfterMethod
    public void cleanup(ITestResult result) throws IOException, IllegalAccessException {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            logger.fail(result.getThrowable());
            logger.addScreenCaptureFromPath(GetScreenshot.capture(driver));
        }
        else if (result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
            logger.addScreenCaptureFromPath(GetScreenshot.capture(driver));
        }
        else if (result.getStatus() == ITestResult.SKIP)
        {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
        }
        if (shkaf != null)
            driver.quit();
    }

    @AfterSuite
    public void saveReport() throws Exception
    {
        extent.flush();
    }

}
