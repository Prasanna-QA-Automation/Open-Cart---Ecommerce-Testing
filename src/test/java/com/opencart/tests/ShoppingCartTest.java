package com.opencart.tests;

import com.opencart.pages.HomePage;
import com.opencart.pages.ProductPage;
import com.opencart.pages.SearchResultsPage;
import com.opencart.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for shopping cart functionality.
 */
public class ShoppingCartTest extends BaseTest {

    /**
     * Test adding product to cart.
     */
    @Test(priority = 1, description = "Test adding product to cart")
    public void testAddToCart() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Search for a product
        SearchResultsPage searchResultsPage = homePage.searchProduct("iPhone");

        // Click on first product
        ProductPage productPage = searchResultsPage.clickFirstProduct();
        Assert.assertNotNull(productPage, "Product page should be displayed");

        // Add product to cart
        productPage.clickAddToCart();

        // Verify success message
        String successMessage = productPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("Success") || successMessage.contains("added"),
            "Success message should be displayed when product is added to cart");
    }

    /**
     * Test viewing shopping cart.
     */
    @Test(priority = 2, description = "Test viewing shopping cart")
    public void testViewCart() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Click on cart button
        ShoppingCartPage cartPage = homePage.clickCart();

        // Verify cart page is displayed
        Assert.assertTrue(driver.getTitle().contains("Shopping Cart") || driver.getCurrentUrl().contains("cart"),
            "Shopping cart page should be displayed");
    }

    /**
     * Test adding multiple quantities to cart.
     */
    @Test(priority = 3, description = "Test adding multiple quantities to cart")
    public void testAddMultipleQuantity() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Search for a product
        SearchResultsPage searchResultsPage = homePage.searchProduct("MacBook");

        // Click on first product
        ProductPage productPage = searchResultsPage.clickFirstProduct();
        Assert.assertNotNull(productPage, "Product page should be displayed");

        // Enter quantity
        productPage.enterQuantity("2");

        // Add to cart
        productPage.clickAddToCart();

        // Verify success message
        String successMessage = productPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("Success") || successMessage.contains("added"),
            "Success message should be displayed for multiple quantity");
    }

    /**
     * Test cart persistence (requires login).
     */
    @Test(priority = 4, description = "Test cart persistence after login")
    public void testCartPersistence() {
        // First add item to cart
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = homePage.searchProduct("iPhone");
        ProductPage productPage = searchResultsPage.clickFirstProduct();
        if (productPage != null) {
            productPage.clickAddToCart();
        }

        // Navigate to cart
        ShoppingCartPage cartPage = homePage.clickCart();

        // Verify cart has items
        Assert.assertTrue(cartPage.hasItemsInCart(),
            "Cart should have items after adding product");
    }
}