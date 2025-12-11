package SwagLabs.testes;

import SwagLabs.drivers.ChromeDriverFactory;
import SwagLabs.pages.CheckOutPage;
import SwagLabs.utils.BrowserActions;
import SwagLabs.utils.LoginDetails;
import SwagLabs.utils.OperationsBeforCheckout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class C_VisualUser {

    private WebDriver driver;
    private CheckOutPage checkOutPage;
    private LoginDetails loginDetails;
    private OperationsBeforCheckout operationsBeforCheckout;

    @BeforeMethod
    public void setup() {
        driver = ChromeDriverFactory.createDriver();
        checkOutPage = new CheckOutPage(driver);
        loginDetails = new LoginDetails(driver);
        operationsBeforCheckout = new OperationsBeforCheckout(driver);

        checkOutPage.navigateToLoginPage();
        loginDetails.visualUser();
    }

    @AfterMethod
    public void tearDown() {
         driver.quit();
    }

    @Test(priority = 1, description = "Verify checkout overview item count")
    public void ch_CountItems() {
        operationsBeforCheckout.allOperationsBeforCheckout("Mohamed", "Ali", "123");
        Assert.assertEquals(checkOutPage.getCheckoutOverviewCount(), 1, "Should have 1 item in cart");
    }

    @Test(priority = 2, description = "Verify successful checkout message")
    public void ch_SuccessMsg() {
        operationsBeforCheckout.allOperationsBeforCheckout("Mohamed", "Ali", "123");
        checkOutPage.clickFinshButton();
        Assert.assertTrue(checkOutPage.getMsg(By.className("complete-header")).contains("Thank you for your order!"));
    }

    @Test(priority = 3, description = "Verify error message for empty first name")
    public void emptyFirstNameShowsError() {
        operationsBeforCheckout.allOperationsBeforCheckout("", "Ali", "123");
        Assert.assertEquals(checkOutPage.getMsg(By.className("error-message-container")), "Error: First Name is required");
    }

    @Test(priority = 4, description = "Verify error message for empty last name")
    public void emptyLastNameShowsError() {
        operationsBeforCheckout.allOperationsBeforCheckout("Mohamed", "", "123");
        Assert.assertEquals(checkOutPage.getMsg(By.className("error-message-container")), "Error: Last Name is required");
    }

    @Test(priority = 5, description = "Verify error message for empty postal code")
    public void emptyPostalCodeShowsError() {
        operationsBeforCheckout.allOperationsBeforCheckout("Mohamed", "Ali", "");
        Assert.assertEquals(checkOutPage.getMsg(By.className("error-message-container")), "Error: Postal Code is required");
    }

    @Test(priority = 6, description = "Verify error message for empty fields")
    public void emptyFieldShowsError() {
        operationsBeforCheckout.allOperationsBeforCheckout("", "", "");
        Assert.assertEquals(checkOutPage.getMsg(By.className("error-message-container")), "Error: First Name is required");
    }

    @Test(priority = 7, description = "Verify error message for spaces in fields")
    public void spacesInFieldShowsError() {
        operationsBeforCheckout.allOperationsBeforCheckout(" ", " ", " ");
        Assert.assertEquals(checkOutPage.getMsg(By.className("error-message-container")), "Error: First Name is required");
    }

    @Test(priority = 8, description = "Verify item name in checkout overview")
    public void itemNameShowsError() {
        operationsBeforCheckout.allOperationsBeforCheckout("Mohamed", "Ali", "123");
        Assert.assertEquals(checkOutPage.getMsg(By.className("inventory_item_name")), "Sauce Labs Backpack");
    }

    @Test(priority = 9, description = "Verify item price in checkout overview")
    public void itemPriceShowsError() {
        operationsBeforCheckout.allOperationsBeforCheckout("Mohamed", "Ali", "123");
        Assert.assertEquals(checkOutPage.getMsg(By.className("inventory_item_price")), "$29.99");
    }

    @Test(priority = 10, description = "Verify cancel button redirects to products page")
    public void cancelButtonShowsError() {
        checkOutPage.navigateToCheckOutPage();
        checkOutPage.clickCancelButton();
        Assert.assertEquals(BrowserActions.getCuurentURL(driver), "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 11, description = "Verify navigation to cart from checkout")
    public void CartBtn_navigate() {
        operationsBeforCheckout.allOperationsBeforCheckout("Mohamed", "Ali", "123");
        checkOutPage.clickShoppingCart();
        Assert.assertEquals(BrowserActions.getCuurentURL(driver), "https://www.saucedemo.com/cart.html");
    }
}
