package SwagLabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ElementActions {
    public static void sendData(WebDriver driver, By locator, String data) {
        waits.waitForElementvisible(driver, locator).sendKeys(data);
    }

    public static void clickElement(WebDriver driver, By locator) {
        waits.waitForElementClickable(driver, locator).click();
    }

    public static WebElement findElement(WebDriver driver, By locator) {
        waits.waitForElementvisible(driver, locator);
        return driver.findElement(locator);
    }

    public static String getText(WebDriver driver, By locator) {
        waits.waitForElementvisible(driver, locator);
        return findElement(driver,locator).getText();

    }
    public static String getUPlaceholder(WebDriver driver, By locator) {
        waits.waitForElementvisible(driver, locator);
        return findElement(driver,locator).getAttribute("placeholder");
    }

    public static String getPasswordPlaceholder(WebDriver driver, By locator) {
        waits.waitForElementvisible(driver, locator);
        return findElement(driver,locator).getAttribute("placeholder");
    }
    public static List<WebElement> findElements(WebDriver driver, By locator) {
        return driver.findElements(locator);
    }


}
