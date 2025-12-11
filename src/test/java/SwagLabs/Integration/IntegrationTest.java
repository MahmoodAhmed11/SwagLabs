package SwagLabs.Integration;

import SwagLabs.drivers.ChromeDriverFactory;
import SwagLabs.pages.ShopingCart;
import SwagLabs.pages.integration;
import SwagLabs.utils.BrowserActions;
import SwagLabs.utils.LoginDetails;
import SwagLabs.utils.OperationsBeforCheckout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class IntegrationTest {


    private WebDriver driver;
    integration Integration ;
    LoginDetails loginDetails;
    OperationsBeforCheckout operationsBeforCheckout;

    @BeforeTest
    public void beforeTest() {
        System.out.println("=== Test Suite Started ===");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = ChromeDriverFactory.createDriver();
        loginDetails = new LoginDetails(driver);
        Integration = new integration(driver);
        operationsBeforCheckout = new OperationsBeforCheckout(driver);

        Integration.navigateToLoginPage();
        loginDetails.standerUser();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1, description = " End-to-End Checkout Test")
    public void endToEndCheckoutTest() {
        Integration.clickAddToCart(By.id("add-to-cart-sauce-labs-backpack"));
        Integration.clickAddToCart(By.id("add-to-cart-sauce-labs-bike-light"));

        Integration.navigateToCart();
        Integration.navigateToCheckOutPage();
        operationsBeforCheckout.operationsBeforCheckout("Bassem","Kamal","010");
        Integration.clickFinshButton();

        Assert.assertTrue(
                Integration.getMsg(By.className("complete-header"))
                        .contains("Thank you for your order!")
        );
    }

    @Test(priority = 2, description = " Add and Remove Item Sync Test")
    public void addRemoveItemSyncTest() {
        Integration.clickAddToCart(By.id("add-to-cart-sauce-labs-backpack"));
        Integration.clickRemoveButton();

        Integration.navigateToCart();
        Assert.assertEquals(Integration.getCartItemCount(), 0);
    }

    @Test(priority = 3, description = " Big Cart Stress Test")
    public void bigCartStressTest() {
        Integration.addAllItems();

        Integration.navigateToCart();
        Assert.assertEquals(Integration.getCartItemCount(), 6);

        Integration.navigateToCheckOutPage();
        operationsBeforCheckout.operationsBeforCheckout("Bassem", "Kamal", "010");
        Integration.clickFinshButton();

        Assert.assertTrue(
                Integration.getMsg(By.className("complete-header"))
                        .contains("Thank you for your order!")
        );
    }

    @Test(priority = 4, description = " Sidebar Navigation Test")
    public void sidebarNavigationTest() {

        Integration.clickMenu();
        Integration.clickAbout();

        Assert.assertTrue(BrowserActions.getCuurentURL(driver)
                .contains("saucelabs.com"));

        Integration.navigateToProductsPage();
    }

    @Test(priority = 5, description = " Checkout with Removed Items Negative Test")
    public void checkoutWithRemovedItemsTest() {

        Integration.clickAddToCart(By.id("add-to-cart-sauce-labs-backpack"));
        Integration.clickAddToCart(By.id("add-to-cart-sauce-labs-bike-light"));

        Integration.navigateToCart();
        Integration.clickRemoveButton();

        Assert.assertEquals(Integration.getCartItemCount(), 1);
    }


}
