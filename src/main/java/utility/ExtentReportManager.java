package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ExtentReportManager {
    public static ExtentReports extent;
    public static ExtentTest test;

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

    public static void setTest(ExtentTest testInstance){
        test = testInstance;
    }

    public static ExtentTest getTest(){
        return test;
    }
}
