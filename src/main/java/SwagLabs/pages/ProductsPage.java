package SwagLabs.pages;

import SwagLabs.utils.BrowserActions;
import SwagLabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;


public class ProductsPage {

    private final WebDriver driver;

    //constractor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    private final By removeFromCart = By.id("remove-sauce-labs-backpack");
    private final By shoppingCart = By.className("shopping_cart_link");
    private final By Menu = By.id("react-burger-menu-btn");
    private final By sortMenu = By.className("product_sort_container");
    private final By productDetails = By.className("inventory_item_name");
    private final By backToBroducts = By.id("back-to-products");
    private final By resetButton = By.id("reset_sidebar_link");
    private final By allitems = By.id("inventory_sidebar_link");
    private final By sortza = By.cssSelector("[value='za']");
    private final By sortaz = By.cssSelector("[value='az']");
    private final By lowToHigh = By.cssSelector("[value='lohi']");
    private final By highToLow = By.cssSelector("[value='hilo']");
    private final By logOut = By.id("logout_sidebar_link");


    //Navigation
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/");
    }

    //Actions
    public void clickAddToCart() {
        ElementActions.clickElement(driver, addToCart);
    }
    public void clickLogOut() {
        ElementActions.clickElement(driver, logOut);
    }

    public void clickRemoveFromCart() {
        ElementActions.clickElement(driver, removeFromCart);
    }

    public void clickShoppingCart() {
        ElementActions.clickElement(driver, shoppingCart);
    }

    public void clickMenu() {
        ElementActions.clickElement(driver, Menu);
    }

    public void clickSortMenu() {
        ElementActions.clickElement(driver, sortMenu);
    }

    public void clickProductDetails() {
        ElementActions.clickElement(driver, productDetails);
    }

    public void clickBackToBroducts() {
        ElementActions.clickElement(driver, backToBroducts);
    }

    public void clickResetButton() {
        ElementActions.clickElement(driver, resetButton);
    }

    public String getRemoveButtonText() {

        return ElementActions.getText(driver, removeFromCart);
    }

    public String getAddButtonText() {
        return ElementActions.getText(driver,addToCart);

    }

    public String getCartBadgeCount() {
        return ElementActions.getText(driver, shoppingCart);
    }

    public void allItems() {
        ElementActions.clickElement(driver, allitems);
    }

    public List<String> sortZA() {

        ElementActions.findElement(driver, sortza).click();

        return ElementActions.findElements(driver, By.className("inventory_item_name"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    public List<String> sortAZ() {

        ElementActions.findElement(driver, sortaz).click();

        return ElementActions.findElements(driver, By.className("inventory_item_name"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    public List<Double> sortLowToHigh() {
        ElementActions.findElement(driver, lowToHigh).click();

        return ElementActions.findElements(driver, By.className("inventory_item_price"))
                .stream()
                .map(WebElement::getText)
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .collect(Collectors.toList());
    }
    public List<Double> sortHighToLow() {
        ElementActions.findElement(driver, highToLow).click();

        return ElementActions.findElements(driver, By.className("inventory_item_price"))
                .stream()
                .map(WebElement::getText)
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .collect(Collectors.toList());
    }


}
