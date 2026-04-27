package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Page Object class for the OpenCart Product Page.
 */
public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "button-cart")
    private WebElement addToCartButton;

    @FindBy(id = "input-quantity")
    private WebElement quantityField;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement successMessage;

    @FindBy(id = "tab-description")
    private WebElement descriptionTab;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterQuantity(String quantity) {
        wait.until(ExpectedConditions.elementToBeClickable(quantityField)).clear();
        quantityField.sendKeys(quantity);
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public String getSuccessMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isProductPageDisplayed() {
        return addToCartButton.isDisplayed();
    }
}