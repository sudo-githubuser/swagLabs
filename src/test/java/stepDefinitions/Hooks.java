package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import cucumber.TestContext;
import io.cucumber.java.*;
import utility.ExtentReportManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Base64;

public class Hooks {

    TestContext testContext;
    ExtentReports extent = ExtentReportManager.getReportInstance();
    public Hooks (TestContext context) { testContext = context; }

    @Before
    public void setUp(Scenario scenario){
        // Extent test initialization
        ExtentTest test = ExtentReportManager.getReportInstance().createTest(scenario.getName());
        ExtentReportManager.setTest(test);
    }

    @After
    public void tearDown(Scenario scenario) {
        testContext.getWebDriverManager().closeDriver();
        if (scenario.isFailed()) {
            ExtentReportManager.getTest().log(Status.FAIL, "Test Failed: " + scenario.getName());
        } else {
            ExtentReportManager.getTest().log(Status.PASS, "Test Passed: " + scenario.getName());
        }
        extent.flush();
    }

    @BeforeStep
    public void beforeStep(){
    }

    @AfterStep
    public void getScreenshot(Scenario scenario){
        String base64Screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
                .getScreenshotAs(OutputType.BASE64);

        final byte[] screenshotBytes = Base64.getDecoder().decode(base64Screenshot);
        scenario.attach(screenshotBytes, "image/png", scenario.getName());

        ExtentTest currentTest = ExtentReportManager.getTest();

        // Prevents NullPointer Exception
        if (currentTest == null) {
            System.err.println("ExtentTest instance is null! Skipping screenshot logging.");
            return;
        }

        if (scenario.isFailed()) {
            currentTest.log(Status.FAIL, "Step Failed:<br><img src='data:image/png;base64," + base64Screenshot + "'/>");
        } else {
            currentTest.log(Status.PASS, "Step Passed:<br><img src='data:image/png;base64," + base64Screenshot + "'/>");
        }
    }
}
