package com.opencart.tests;

import com.opencart.pages.HomePage;
import com.opencart.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for search functionality.
 */
public class SearchTest extends BaseTest {

    /**
     * Test searching for existing products.
     */
    @Test(priority = 1, description = "Test searching for existing products")
    public void testSearchExistingProduct() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Search for a product that exists (e.g., "iPhone")
        SearchResultsPage searchResultsPage = homePage.searchProduct("iPhone");

        // Verify search results are displayed
        Assert.assertTrue(searchResultsPage.hasResults(),
            "Search should return results for existing products");
        Assert.assertTrue(searchResultsPage.getNumberOfResults() > 0,
            "Should have at least one search result");
    }

    /**
     * Test searching for non-existing products.
     */
    @Test(priority = 2, description = "Test searching for non-existing products")
    public void testSearchNonExistingProduct() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Search for a product that doesn't exist
        SearchResultsPage searchResultsPage = homePage.searchProduct("nonexistingproduct12345");

        // Verify no results message is displayed
        String noResultsMessage = searchResultsPage.getNoResultsMessage();
        Assert.assertTrue(noResultsMessage.contains("No results") || searchResultsPage.getNumberOfResults() == 0,
            "Should display no results message for non-existing products");
    }

    /**
     * Test empty search.
     */
    @Test(priority = 3, description = "Test empty search")
    public void testEmptySearch() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Search with empty string
        SearchResultsPage searchResultsPage = homePage.searchProduct("");

        // Verify behavior (might show all products or no results)
        // This depends on OpenCart implementation
        Assert.assertTrue(driver.getTitle().contains("Search") || driver.getCurrentUrl().contains("search"),
            "Should handle empty search appropriately");
    }

    /**
     * Test search with special characters.
     */
    @Test(priority = 4, description = "Test search with special characters")
    public void testSearchWithSpecialCharacters() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);

        // Search with special characters
        SearchResultsPage searchResultsPage = homePage.searchProduct("!@#$%^&*()");

        // Verify no results or appropriate handling
        Assert.assertTrue(searchResultsPage.getNumberOfResults() == 0 ||
            searchResultsPage.getNoResultsMessage().length() > 0,
            "Should handle special characters in search appropriately");
    }
}