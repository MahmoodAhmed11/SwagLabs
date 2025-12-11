package SwagLabs.LoginPage;

import SwagLabs.drivers.ChromeDriverFactory;
import SwagLabs.pages.Loginpage;
import SwagLabs.utils.BrowserActions;
import SwagLabs.utils.LoginDetails;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    private WebDriver driver;
    Loginpage loginpage;
    LoginDetails loginDetails;

    @BeforeTest
    public void beforeTest() {
        driver = ChromeDriverFactory.createDriver();
        loginpage = new Loginpage(driver);
        loginDetails = new LoginDetails(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        loginpage.navigateToLoginPage();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test(priority = 1, description = "Verify Username & Password placeholder text appears correctly")
    public void placeholderTest(){
        Assert.assertEquals(loginpage.getUserplaceholder(),"Username");
        Assert.assertEquals(loginpage.getpasswordplaceholder(),"Password");
    }

    @Test(priority = 2, description = "Valid login with standard_user credentials")
    public void validLoginTest(){
        loginDetails.standerUser();
        Assert.assertTrue(BrowserActions.getCuurentURL(driver).contains("inventory.html"));
    }

    @Test(priority = 3, description = "Login attempt with invalid username should show correct error")
    public void invalidUsernameTest(){
        loginDetails.invalid("wrong_user","secret_sauce");
        Assert.assertEquals(loginpage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 4, description = "Login with wrong password should return correct error message")
    public void invalidPasswordTest(){
        loginDetails.invalid("standard_user","wrong_password");
        Assert.assertEquals(loginpage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 5, description = "Login with empty username should show username required error")
    public void emptyUsernameTest(){
        loginDetails.invalid("","secret_sauce");
        Assert.assertEquals(loginpage.getErrorMessage(),"Epic sadface: Username is required");
    }

    @Test(priority = 6, description = "Login with empty password should show password required error")
    public void emptyPasswordTest(){
        loginDetails.invalid("standard_user","");
        Assert.assertEquals(loginpage.getErrorMessage(),"Epic sadface: Password is required");
    }

    @Test(priority = 7, description = "Check login for locked_out_user shows correct locked out message")
    public void lockedOutUserTest(){
        loginDetails.lockedUser();
        Assert.assertEquals(loginpage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(priority = 8, description = "Check login with performance_glitch_user navigates successfully")
    public void performanceGlitchUserTest(){
        loginDetails.performanceUser();
        Assert.assertTrue(BrowserActions.getCuurentURL(driver).contains("inventory.html"));
    }

    @Test(priority = 9, description = "Login test for problem_user")
    public void problemUserLoginTest(){
        loginDetails.problemUser();
        Assert.assertTrue(BrowserActions.getCuurentURL(driver).contains("inventory.html"));
    }

    @Test(priority = 10, description = "Login test for error_user")
    public void errorUserTest(){
        loginDetails.errorUser();
        Assert.assertTrue(BrowserActions.getCuurentURL(driver).contains("inventory.html"));
    }

    @Test(priority = 11, description = "Login test for visual_user")
    public void visualUserTest(){
        loginDetails.visualUser();
        Assert.assertTrue(BrowserActions.getCuurentURL(driver).contains("inventory.html"));
    }

    @Test(priority = 12, description = "Verify correct error message appears for wrong username & password")
    public void errorMessageDisplayTest(){
        loginDetails.invalid("wrong_user","wrong_pass");
        Assert.assertEquals(loginpage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }
}
