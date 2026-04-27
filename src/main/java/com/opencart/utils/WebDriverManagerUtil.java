package com.opencart.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Utility class for managing WebDriver instances.
 * Handles automatic driver setup and configuration.
 */
public class WebDriverManagerUtil {

    private static final String BROWSER = System.getProperty("browser", "chrome");

    /**
     * Creates and returns a WebDriver instance based on the specified browser.
     * Defaults to Chrome if no browser is specified.
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        WebDriver driver;

        switch (BROWSER.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless"); // Run in headless mode for CI/CD
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                chromeOptions.addArguments("--disable-extensions");
                // Uncomment the next line for headless mode
                // chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        return driver;
    }
}