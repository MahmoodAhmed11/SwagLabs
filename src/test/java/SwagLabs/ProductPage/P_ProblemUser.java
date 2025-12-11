package SwagLabs.ProductPage;

import SwagLabs.drivers.ChromeDriverFactory;
import SwagLabs.pages.ProductsPage;
import SwagLabs.utils.BrowserActions;
import SwagLabs.utils.LoginDetails;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_ProblemUser {

    private WebDriver driver;
    private ProductsPage productsPage;
    private LoginDetails loginDetails;

    @BeforeMethod
    public void setup() {
        driver = ChromeDriverFactory.createDriver();
        productsPage = new ProductsPage(driver);
        loginDetails = new LoginDetails(driver);
        productsPage.navigateToLoginPage();
        loginDetails.problemUser();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test(priority = 1, description = "Add a product to the cart and verify badge and button")
    public void addToCartTest() {
        productsPage.clickAddToCart();
        Assert.assertEquals(productsPage.getRemoveButtonText(), "Remove");
        Assert.assertEquals(productsPage.getCartBadgeCount(), "1");
    }

    @Test(priority = 2, description = "Remove a product from the cart and verify badge and button")
    public void removeFromCartTest() {
        productsPage.clickAddToCart(); // تجهيز العنصر
        productsPage.clickRemoveFromCart();
        Assert.assertEquals(productsPage.getAddButtonText(), "Add to cart");
        Assert.assertEquals(productsPage.getCartBadgeCount(), "");
    }

    @Test(priority = 3, description = "Open product details and verify URL")
    public void productDetailsTest() {
        productsPage.clickProductDetails();
        Assert.assertEquals(BrowserActions.getCuurentURL(driver),
                "https://www.saucedemo.com/inventory-item.html?id=4");
    }

    @Test(priority = 4, description = "Navigate back to products page from product details")
    public void backToProductsTest() {
        productsPage.clickProductDetails();
        productsPage.clickBackToBroducts();
        Assert.assertEquals(BrowserActions.getCuurentURL(driver),
                "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 5, description = "Reset cart and verify buttons return to 'Add to cart'")
    public void convertButtonFromRemoveTest() {
        productsPage.clickAddToCart(); // تجهيز العنصر
        productsPage.clickMenu();
        productsPage.clickResetButton();
        Assert.assertEquals(productsPage.getAddButtonText(), "Add to cart");
    }

    @Test(priority = 6, description = "Verify cart icon shows correct badge")
    public void checkCartIconTest() {
        Assert.assertEquals(productsPage.getCartBadgeCount(), "");
    }

    @Test(priority = 7, description = "Open menu and verify all items page")
    public void allItemsTest() {
        productsPage.clickMenu();
        productsPage.allItems();
        Assert.assertEquals(BrowserActions.getCuurentURL(driver),
                "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 8, description = "Verify items sorted from Z to A")
    public void sortZATest() {
        productsPage.clickSortMenu();
        List<String> actualNames = productsPage.sortZA();
        List<String> expectedNames = new ArrayList<>(actualNames);
        expectedNames.sort(Collections.reverseOrder());
        Assert.assertEquals(actualNames, expectedNames, "Items are not sorted Z→A");
    }

    @Test(priority = 9, description = "Verify items sorted from A to Z")
    public void testSortAZ() {
        productsPage.clickSortMenu();
        List<String> actual = productsPage.sortAZ();
        List<String> expected = new ArrayList<>(actual);
        Collections.sort(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 10, description = "Verify items sorted by price low to high")
    public void testSortLowToHigh() {
        productsPage.clickSortMenu();
        List<Double> actual = productsPage.sortLowToHigh();
        List<Double> expected = new ArrayList<>(actual);
        Collections.sort(expected);
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 11, description = "Verify items sorted by price high to low")
    public void testSortHighToLow() {
        productsPage.clickSortMenu();
        List<Double> actual = productsPage.sortHighToLow();
        List<Double> expected = new ArrayList<>(actual);
        expected.sort(Collections.reverseOrder());
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 12, description = "Logout from the menu and verify URL")
    public void logoutTest() {
        productsPage.clickMenu();
        productsPage.clickLogOut();
        Assert.assertEquals(BrowserActions.getCuurentURL(driver),
                "https://www.saucedemo.com/");
    }
}
