package SwagLabs.pages;

import SwagLabs.utils.BrowserActions;
import SwagLabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopingCart {
    private final WebDriver driver;

    //constractor
    public ShopingCart(WebDriver driver) {
        this.driver = driver;
    }

    //locators

    private final By shoppingCart = By.className("shopping_cart_link");
    private final By cartTitle = By.className("title");
    private final By navigatetoproductes = By.id("continue-shopping");
    private final By Menu = By.id("react-burger-menu-btn");
    private final By logOut = By.id("logout_sidebar_link");


    //Navigation
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/");
    }
    public void navigateToCart() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/cart.html");
    }
    public void navigateToProductsPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/inventory.html");
    }

    //Actions
    public void clickAddToCart(By locator) {
        ElementActions.clickElement(driver, locator);
    }

    public void clickRemoveFromCart(By locator) {
        ElementActions.clickElement(driver, locator);
    }
    public void clickShoppingCart() {
        ElementActions.clickElement(driver, shoppingCart);
    }
    public void clickBackFromCart() {
        ElementActions.clickElement(driver, navigatetoproductes);
    }
    public String getTitleText() {
        return ElementActions.getText(driver, cartTitle);

    }
    public int getCartItemCount() {

        List<WebElement> cartItems = ElementActions.findElements(driver,By.className("cart_item"));
        return cartItems.size();
    }
    public void clickMenu() {
        ElementActions.clickElement(driver, Menu);
    }
    public void clickLogOut() {
        ElementActions.clickElement(driver, logOut);
    }

}
