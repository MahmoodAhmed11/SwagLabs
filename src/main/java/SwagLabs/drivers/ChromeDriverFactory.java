package SwagLabs.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory {

    public static WebDriver createDriver() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        return new org.openqa.selenium.chrome.ChromeDriver(options);
    }
}
