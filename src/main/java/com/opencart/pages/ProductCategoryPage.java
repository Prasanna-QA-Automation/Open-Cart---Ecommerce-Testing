package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

/**
 * Page Object class for the OpenCart Product Category Page.
 */
public class ProductCategoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "div.product-layout")
    private List<WebElement> products;

    @FindBy(id = "input-sort")
    private WebElement sortDropdown;

    @FindBy(id = "input-limit")
    private WebElement limitDropdown;

    public ProductCategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public int getProductCount() {
        return products.size();
    }

    public ProductPage clickFirstProduct() {
        if (!products.isEmpty()) {
            products.get(0).findElement(org.openqa.selenium.By.tagName("a")).click();
            return new ProductPage(driver);
        }
        return null;
    }

    public boolean hasProducts() {
        return !products.isEmpty();
    }
}