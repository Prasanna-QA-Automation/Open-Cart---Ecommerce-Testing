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
 * Page Object class for the OpenCart Search Results Page.
 */
public class SearchResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "div.product-layout")
    private List<WebElement> productResults;

    @FindBy(id = "input-search")
    private WebElement searchInput;

    @FindBy(id = "button-search")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement noResultsMessage;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public int getNumberOfResults() {
        return productResults.size();
    }

    public boolean hasResults() {
        return !productResults.isEmpty();
    }

    public ProductPage clickFirstProduct() {
        if (!productResults.isEmpty()) {
            productResults.get(0).findElement(org.openqa.selenium.By.tagName("a")).click();
            return new ProductPage(driver);
        }
        return null;
    }

    public String getNoResultsMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(noResultsMessage)).getText();
        } catch (Exception e) {
            return "";
        }
    }
}