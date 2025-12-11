package SwagLabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OperationsBeforCheckout {
    private final WebDriver driver;

    public OperationsBeforCheckout(WebDriver driver) {
        this.driver = driver;
    }
    public void operationsBeforCheckout(String fristName, String lastName,String postalCode) {
        ElementActions.sendData(driver, By.id("first-name"), fristName);
        ElementActions.sendData(driver, By.id("last-name"), lastName);
        ElementActions.sendData(driver, By.id("postal-code"), postalCode);
        ElementActions.clickElement(driver, By.id("continue"));
    }
    public void allOperationsBeforCheckout(String fristName, String lastName,String postalCode) {
        ElementActions.clickElement(driver, By.id("add-to-cart-sauce-labs-backpack"));
        ElementActions.clickElement(driver, By.className("shopping_cart_link"));
        ElementActions.clickElement(driver, By.id("checkout"));
        ElementActions.sendData(driver, By.id("first-name"), fristName);
        ElementActions.sendData(driver, By.id("last-name"), lastName);
        ElementActions.sendData(driver, By.id("postal-code"), postalCode);
        ElementActions.clickElement(driver, By.id("continue"));
    }



}
