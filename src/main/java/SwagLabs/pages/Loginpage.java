package SwagLabs.pages;

import SwagLabs.utils.BrowserActions;
import SwagLabs.utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage {
    private final WebDriver driver;

    //constractor
    public Loginpage(WebDriver driver) {
        this.driver = driver;
    }

    //Navigation
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(driver, "https://www.saucedemo.com/");
    }


    //Actions
    public String getErrorMessage() {
        return ElementActions.getText(driver, By.cssSelector("[data-test='error']"));
    }
    public String getUserplaceholder() {
        return ElementActions.getUPlaceholder(driver, By.id("user-name"));
    }
    public String getpasswordplaceholder() {
        return ElementActions.getPasswordPlaceholder(driver, By.id("password"));
    }



}
