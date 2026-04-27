package com.opencart.tests;

import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;
import com.opencart.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for login functionality.
 * Contains test cases for user login scenarios.
 */
public class LoginTest extends BaseTest {

    /**
     * Test successful login with valid credentials.
     */
    @Test(priority = 1, description = "Test successful login with valid credentials")
    public void testValidLogin() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Click login and perform login
        LoginPage loginPage = homePage.clickLogin();
        MyAccountPage myAccountPage = loginPage.login("test@example.com", "password123");

        // Verify login success
        Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed(),
            "User should be logged in and My Account page should be displayed");
    }

    /**
     * Test login with invalid credentials.
     */
    @Test(priority = 2, description = "Test login with invalid credentials")
    public void testInvalidLogin() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Click login and attempt login with invalid credentials
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login("invalid@example.com", "wrongpassword");

        // Verify error message is displayed
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Warning") || errorMessage.contains("No match"),
            "Error message should be displayed for invalid login");
    }

    /**
     * Test navigation to forgotten password page.
     */
    @Test(priority = 3, description = "Test navigation to forgotten password page")
    public void testForgottenPasswordLink() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Click login and then forgotten password
        LoginPage loginPage = homePage.clickLogin();
        loginPage.clickForgottenPassword();

        // Verify we're on the forgotten password page
        Assert.assertTrue(driver.getTitle().contains("Forgotten Password"),
            "Should navigate to Forgotten Password page");
    }

    /**
     * Test login page elements are displayed.
     */
    @Test(priority = 4, description = "Test login page elements are displayed")
    public void testLoginPageElements() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Click login
        LoginPage loginPage = homePage.clickLogin();

        // Verify login page is displayed
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),
            "Login page should be displayed with all elements");
    }
}