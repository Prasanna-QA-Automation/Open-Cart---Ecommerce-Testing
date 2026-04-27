package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Page Object class for the OpenCart My Account Page.
 */
public class MyAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h2[text()='My Account']")
    private WebElement myAccountHeader;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(linkText = "Edit Account")
    private WebElement editAccountLink;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isMyAccountPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(myAccountHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public HomePage clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
        return new HomePage(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}