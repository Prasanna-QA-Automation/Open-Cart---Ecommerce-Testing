package com.opencart.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Utility class for ExtentReports configuration and management.
 */
public class ExtentReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    /**
     * Initialize ExtentReports.
     *
     * @return ExtentReports instance
     */
    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
            spark.config().setDocumentTitle("OpenCart Testing Report");
            spark.config().setReportName("E-commerce Test Automation");
            spark.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", System.getProperty("browser", "chrome"));
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }
        return extent;
    }

    /**
     * Create a test in the report.
     *
     * @param testName Test name
     * @param testDescription Test description
     */
    public static void createTest(String testName, String testDescription) {
        test.set(getInstance().createTest(testName, testDescription));
    }

    /**
     * Get the current test.
     *
     * @return Current ExtentTest
     */
    public static ExtentTest getTest() {
        return test.get();
    }

    /**
     * Flush the report.
     */
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}