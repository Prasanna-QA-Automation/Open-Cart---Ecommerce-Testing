package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Page Object class for the OpenCart Home Page.
 * Contains all the elements and actions related to the home page.
 */
public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Page Elements using @FindBy annotations
    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountLink;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(name = "search")
    private WebElement searchBox;

    @FindBy(css = "button.btn.btn-default.btn-lg")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='cart']//button")
    private WebElement cartButton;

    @FindBy(linkText = "Desktops")
    private WebElement desktopsMenu;

    @FindBy(linkText = "Show All Desktops")
    private WebElement showAllDesktops;

    /**
     * Constructor to initialize the page elements.
     *
     * @param driver WebDriver instance
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on the My Account link.
     */
    public void clickMyAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountLink)).click();
    }

    /**
     * Clicks on the Register link.
     *
     * @return RegisterPage instance
     */
    public RegisterPage clickRegister() {
        clickMyAccount();
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
        return new RegisterPage(driver);
    }

    /**
     * Clicks on the Login link.
     *
     * @return LoginPage instance
     */
    public LoginPage clickLogin() {
        clickMyAccount();
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
        return new LoginPage(driver);
    }

    /**
     * Searches for a product.
     *
     * @param productName Name of the product to search
     * @return SearchResultsPage instance
     */
    public SearchResultsPage searchProduct(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox)).clear();
        searchBox.sendKeys(productName);
        searchButton.click();
        return new SearchResultsPage(driver);
    }

    /**
     * Clicks on the shopping cart button.
     *
     * @return ShoppingCartPage instance
     */
    public ShoppingCartPage clickCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
        return new ShoppingCartPage(driver);
    }

    /**
     * Navigates to the Desktops category.
     *
     * @return ProductCategoryPage instance
     */
    public ProductCategoryPage navigateToDesktops() {
        wait.until(ExpectedConditions.elementToBeClickable(desktopsMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(showAllDesktops)).click();
        return new ProductCategoryPage(driver);
    }

    /**
     * Gets the page title.
     *
     * @return Page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Checks if the home page is displayed.
     *
     * @return true if home page is displayed
     */
    public boolean isHomePageDisplayed() {
        return driver.getTitle().contains("Your Store");
    }
}