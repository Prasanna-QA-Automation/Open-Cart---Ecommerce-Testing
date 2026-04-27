package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Page Object class for the OpenCart Checkout Page.
 */
public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "button-payment-address")
    private WebElement continueBillingButton;

    @FindBy(id = "button-shipping-address")
    private WebElement continueShippingButton;

    @FindBy(id = "button-shipping-method")
    private WebElement continueShippingMethodButton;

    @FindBy(id = "button-payment-method")
    private WebElement continuePaymentMethodButton;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement orderSuccessMessage;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void continueBillingDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBillingButton)).click();
    }

    public void continueShippingDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShippingButton)).click();
    }

    public void continueShippingMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShippingMethodButton)).click();
    }

    public void continuePaymentMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(continuePaymentMethodButton)).click();
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton)).click();
    }

    public String getOrderSuccessMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(orderSuccessMessage)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isCheckoutPageDisplayed() {
        return driver.getTitle().contains("Checkout");
    }
}