package SwagLabs.CartPage;

import SwagLabs.drivers.ChromeDriverFactory;
import SwagLabs.pages.ShopingCart;
import SwagLabs.utils.BrowserActions;
import SwagLabs.utils.LoginDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class S_PerformanceUser {

    private WebDriver driver;
    private ShopingCart shopingcart;
    private LoginDetails loginDetails;

     @BeforeTest
    public void beforeTest() {
        System.out.println("=== Starting Visual User Cart Tests ===");
    }

    @BeforeMethod
    public void setup() {
        driver = ChromeDriverFactory.createDriver();
        shopingcart = new ShopingCart(driver);
        loginDetails = new LoginDetails(driver);

        shopingcart.navigateToLoginPage();
        loginDetails.performanceUser();
    }

    @AfterMethod
    public void tearDown() {
      driver.quit();
    }


    @AfterTest
    public void afterTest() {
        System.out.println("=== Finished Visual User Cart Tests ===");
    }

    @Test(priority = 1, description = "Verify user can navigate to cart page after adding items")
    public void navigateToCartTest() {
        shopingcart.clickAddToCart(By.id("add-to-cart-sauce-labs-backpack"));
        shopingcart.clickAddToCart(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        shopingcart.clickShoppingCart();

        Assert.assertEquals(BrowserActions.getCuurentURL(driver),
                "https://www.saucedemo.com/cart.html");
    }

    @Test(priority = 2, description = "Verify the cart page title is displayed correctly")
    public void titleOfCartTest() {
        shopingcart.clickAddToCart(By.id("add-to-cart-sauce-labs-backpack"));
        shopingcart.clickAddToCart(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        shopingcart.clickShoppingCart();

        Assert.assertEquals(shopingcart.getTitleText(), "Your Cart");
    }

    @Test(priority = 3, description = "Verify cart displays correct number of items after adding")
    public void itemCountOfCartTest() {
        shopingcart.clickAddToCart(By.id("add-to-cart-sauce-labs-backpack"));
        shopingcart.clickAddToCart(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        shopingcart.clickShoppingCart();

        Assert.assertEquals(shopingcart.getCartItemCount(), 2);
    }

    @Test(priority = 4, description = "Verify clicking cart on an empty cart keeps user on product page")
    public void clickOnEmptyCartTest() {
        shopingcart.clickShoppingCart();
        Assert.assertEquals(BrowserActions.getCuurentURL(driver),
                "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 5, description = "Verify cart item count is zero for an empty cart")
    public void checkCartItemsTest() {
        shopingcart.clickShoppingCart();
        Assert.assertEquals(shopingcart.getCartItemCount(), 0);
    }

    @Test(priority = 6, description = "Verify item count decreases after removing an item")
    public void countAfterRemoveTest() {
        shopingcart.navigateToProductsPage();
        shopingcart.clickAddToCart(By.id("add-to-cart-sauce-labs-backpack"));
        shopingcart.clickShoppingCart();
        Assert.assertEquals(shopingcart.getCartItemCount(), 1);

        shopingcart.clickBackFromCart();
        shopingcart.clickRemoveFromCart(By.id("remove-sauce-labs-backpack"));

        shopingcart.clickShoppingCart();
        Assert.assertEquals(shopingcart.getCartItemCount(), 0);
    }

    @Test(priority = 7, description = "Verify adding a second item increases the cart count correctly")
    public void checkCartItemsAfterUpdateTest() {
        shopingcart.navigateToProductsPage();
        shopingcart.clickAddToCart(By.id("add-to-cart-sauce-labs-backpack"));
        shopingcart.clickShoppingCart();
        Assert.assertEquals(shopingcart.getCartItemCount(), 1);

        shopingcart.clickBackFromCart();
        shopingcart.clickAddToCart(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        shopingcart.clickShoppingCart();
        Assert.assertEquals(shopingcart.getCartItemCount(), 2);
    }

    @Test(priority = 8, description = "Verify navigate to cart directly Without login")
    public void navigateToCartDirectly() {
        shopingcart.clickMenu();
        shopingcart.clickLogOut();

        Assert.assertEquals(BrowserActions.getCuurentURL(driver),
                "https://www.saucedemo.com/");
    }


}
