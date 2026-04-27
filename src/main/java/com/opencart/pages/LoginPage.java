package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Page Object class for the OpenCart Login Page.
 * Contains all the elements and actions related to user login.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Page Elements
    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(linkText = "Forgotten Password")
    private WebElement forgottenPasswordLink;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement errorMessage;

    /**
     * Constructor to initialize the page elements.
     *
     * @param driver WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Enters the email address.
     *
     * @param email Email address
     */
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
        emailField.sendKeys(email);
    }

    /**
     * Enters the password.
     *
     * @param password Password
     */
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).clear();
        passwordField.sendKeys(password);
    }

    /**
     * Clicks the login button.
     *
     * @return MyAccountPage instance if login successful
     */
    public MyAccountPage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new MyAccountPage(driver);
    }

    /**
     * Performs login with email and password.
     *
     * @param email Email address
     * @param password Password
     * @return MyAccountPage instance
     */
    public MyAccountPage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        return clickLoginButton();
    }

    /**
     * Clicks on the forgotten password link.
     *
     * @return ForgottenPasswordPage instance
     */
    public ForgottenPasswordPage clickForgottenPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgottenPasswordLink)).click();
        return new ForgottenPasswordPage(driver);
    }

    /**
     * Gets the error message if login fails.
     *
     * @return Error message text
     */
    public String getErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Checks if the login page is displayed.
     *
     * @return true if login page is displayed
     */
    public boolean isLoginPageDisplayed() {
        return driver.getTitle().contains("Account Login");
    }
}