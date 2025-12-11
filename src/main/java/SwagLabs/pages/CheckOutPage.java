package SwagLabs.pages;

import SwagLabs.utils.BrowserActions;
import SwagLabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckOutPage {

    private final WebDriver driver;

    //constractor
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    //locators
    private final By shoppingCart = By.className("shopping_cart_link");
    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");
    private final By clickRemoveButton = By.id("remove-sauce-labs-backpack");


    //Navigation
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/");
    }
    public void navigateToCheckOutPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/checkout-step-one.html");
    }
    public void navigateToProductsPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/inventory.html");
    }

    //Actions
    public int getCheckoutOverviewCount() {

        List<WebElement> items = ElementActions.findElements(driver, By.cssSelector(".cart_item"));

        return items.size();
    }
    public void clickFinshButton() {
        ElementActions.clickElement(driver, finishButton);
    }
    public String getMsg(By locator) {
        return ElementActions.getText(driver, locator);
    }
    public void  clickCancelButton() {
        ElementActions.clickElement(driver, cancelButton);
    }
    public void clickShoppingCart() {
        ElementActions.clickElement(driver, shoppingCart);
    }
    public void clickRemoveButton() {
        ElementActions.clickElement(driver, clickRemoveButton);
    }


}
