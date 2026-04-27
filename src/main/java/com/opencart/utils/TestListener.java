package com.opencart.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * TestNG listener for ExtentReports integration.
 */
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName(),
            result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = ExtentReportManager.getTest();
        if (test != null) {
            test.log(Status.PASS, "Test passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentReportManager.getTest();
        if (test != null) {
            test.log(Status.FAIL, "Test failed: " + result.getThrowable());

            // Capture screenshot on failure
            try {
                WebDriver driver = (WebDriver) result.getTestClass()
                    .getRealClass()
                    .getDeclaredField("driver")
                    .get(result.getInstance());
                if (driver != null) {
                    // You can add screenshot capture here
                    test.addScreenCaptureFromPath("screenshot_path");
                }
            } catch (Exception e) {
                test.log(Status.WARNING, "Could not capture screenshot");
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = ExtentReportManager.getTest();
        if (test != null) {
            test.log(Status.SKIP, "Test skipped");
        }
    }

    @Override
    public void onStart(ITestContext context) {
        // Initialize report
        ExtentReportManager.getInstance();
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush report
        ExtentReportManager.flush();
    }
}