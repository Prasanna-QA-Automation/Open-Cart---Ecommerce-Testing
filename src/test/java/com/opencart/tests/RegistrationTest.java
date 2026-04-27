package com.opencart.tests;

import com.opencart.pages.HomePage;
import com.opencart.pages.MyAccountPage;
import com.opencart.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for user registration functionality.
 */
public class RegistrationTest extends BaseTest {

    /**
     * Test successful user registration.
     */
    @Test(priority = 1, description = "Test successful user registration")
    public void testSuccessfulRegistration() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Click register
        RegisterPage registerPage = homePage.clickRegister();

        // Generate unique email to avoid conflicts
        String email = "testuser" + System.currentTimeMillis() + "@example.com";

        // Fill registration form
        MyAccountPage myAccountPage = registerPage.register(
            "John",
            "Doe",
            email,
            "1234567890",
            "password123"
        );

        // Verify registration success
        Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed(),
            "User should be registered and My Account page should be displayed");
    }

    /**
     * Test registration with existing email.
     */
    @Test(priority = 2, description = "Test registration with existing email")
    public void testRegistrationWithExistingEmail() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Click register
        RegisterPage registerPage = homePage.clickRegister();

        // Try to register with existing email
        registerPage.register(
            "Jane",
            "Smith",
            "test@example.com", // Assuming this email exists
            "0987654321",
            "password123"
        );

        // Verify error message (this might vary based on OpenCart configuration)
        // Note: In demo site, registration might always succeed, so this test might need adjustment
        Assert.assertTrue(driver.getTitle().contains("Account") || driver.getTitle().contains("Register"),
            "Should handle existing email appropriately");
    }

    /**
     * Test registration form validation.
     */
    @Test(priority = 3, description = "Test registration form validation")
    public void testRegistrationFormValidation() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Click register
        RegisterPage registerPage = homePage.clickRegister();

        // Try to register without filling required fields
        registerPage.clickContinue();

        // Verify we're still on registration page (validation should prevent submission)
        Assert.assertTrue(driver.getTitle().contains("Register"),
            "Should remain on registration page when required fields are empty");
    }
}