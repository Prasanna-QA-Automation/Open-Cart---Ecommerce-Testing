package com.opencart.tests;

import com.opencart.utils.WebDriverManagerUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

/**
 * Base test class that handles WebDriver setup and teardown for all test classes.
 * This class provides common functionality for initializing the browser and cleaning up after tests.
 */
public class BaseTest {
    protected WebDriver driver;

    /**
     * Setup method that runs before each test method.
     * Initializes the WebDriver and sets up the browser.
     */
    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver using WebDriverManager
        driver = WebDriverManagerUtil.getDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to OpenCart demo site
        driver.get("https://demo.opencart.com/");
    }

    /**
     * Teardown method that runs after each test method.
     * Closes the browser and cleans up resources.
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}