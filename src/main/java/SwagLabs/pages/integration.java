package SwagLabs.pages;

import SwagLabs.utils.BrowserActions;
import SwagLabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class integration {
    private final WebDriver driver;

    //constractor
    public integration(WebDriver driver) {
        this.driver = driver;
    }
    //locators

    private final By Item1 = By.id("add-to-cart-sauce-labs-backpack");
    private final By Item2 = By.id("add-to-cart-sauce-labs-bike-light");
    private final By Item3 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By Item4 = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By Item5 = By.id("add-to-cart-sauce-labs-onesie");
    private final By Item6 = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");
    private final By clickRemoveButton = By.id("remove-sauce-labs-backpack");
    private final By Menu = By.id("react-burger-menu-btn");
    private final By About = By.id("about_sidebar_link");

    //Navigation
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/");
    }
    public void navigateToCart() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/cart.html");
    }
    public void navigateToCheckOutPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/checkout-step-one.html");
    }
    public void navigateToProductsPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/inventory.html");
    }

    //Actions
    public void clickAddToCart(By locator) {
        ElementActions.clickElement(driver, locator);
    }
    public void clickFinshButton(){
        ElementActions.clickElement(driver, finishButton);
    }
    public int getCartItemCount() {

        List<WebElement> cartItems = ElementActions.findElements(driver,By.className("cart_item"));
        return cartItems.size();
    }
    public String getMsg(By locator) {
        return ElementActions.getText(driver, locator);
    }
    public void clickRemoveButton() {
        ElementActions.clickElement(driver, clickRemoveButton);
    }
    public void clickMenu() {
        ElementActions.clickElement(driver, Menu);
    }
    public void clickAbout() {
        ElementActions.clickElement(driver, About);
    }
    public void addAllItems(){
        By[] allItems = {
                Item1,
                Item2,
                Item3,
                Item4,
                Item5,
                Item6

        };

        for (By id : allItems) {
            ElementActions.clickElement(driver,id);
        }
    }



}
