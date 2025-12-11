package SwagLabs.utils;


import org.openqa.selenium.WebDriver;

public class BrowserActions {

    public static void navigateToURL(WebDriver driver, String url) {
        driver.get(url);
    }

    public static String getCuurentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }


}
