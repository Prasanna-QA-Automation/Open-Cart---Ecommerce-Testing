package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Page Object class for the OpenCart Shopping Cart Page.
 */
public class ShoppingCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[text()='Checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='table-responsive']//tbody//tr")
    private WebElement cartItem;

    @FindBy(id = "input-coupon")
    private WebElement couponField;

    @FindBy(id = "button-coupon")
    private WebElement applyCouponButton;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        return new CheckoutPage(driver);
    }

    public boolean hasItemsInCart() {
        try {
            return cartItem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterCoupon(String couponCode) {
        wait.until(ExpectedConditions.elementToBeClickable(couponField)).clear();
        couponField.sendKeys(couponCode);
    }

    public void applyCoupon() {
        wait.until(ExpectedConditions.elementToBeClickable(applyCouponButton)).click();
    }
}