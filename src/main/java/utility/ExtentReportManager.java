package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ExtentReportManager {
    public static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports getReportInstance(){
        if(extent == null){
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = System.getProperty("user.dir")+"/reports/ExtentReport_" + timeStamp + ".html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

            Map<String, String > excelData = ExcelFileManager.readExcelData();

            reporter.config().setReportName(excelData.getOrDefault("ReportName", "SwagLab Test Report"));
            reporter.config().setDocumentTitle(excelData.getOrDefault("DocumentTitle", "Test Execution Report"));

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Tester", excelData.getOrDefault("Tester", "Unknown Tester"));
            extent.setSystemInfo("Environment", excelData.getOrDefault("Environment", "Unknown Environment"));
        }
        return extent;
    }

    public static ExtentTest createTest(String testName){
        ExtentTest test = getReportInstance().createTest(testName);
        extentTest.set(test);
        return test;
    }

    public static void flush(){
        if(extent != null){
            extent.flush();
        }
    }

    public static ExtentTest getTest(){
        return extentTest.get();
    }
}
