package managers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    public static ExtentReports extent;
    public static ExtentTest test;

    public static ExtentReports getReportInstance(){
        if(extent == null){
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = System.getProperty("user.dir")+"/reports/ExtentReport_" + timeStamp + ".html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("SwagLab Test Report");
            reporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Jon Doe");
            extent.setSystemInfo("Environment", "Pre-Validation");
        }
        return extent;
    }

    public static void setTest(ExtentTest testInstance){
        test = testInstance;
    }

    public static ExtentTest getTest(){
        return test;
    }
}
