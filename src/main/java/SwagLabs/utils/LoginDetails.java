package SwagLabs.utils;

import SwagLabs.pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginDetails {


   private final WebDriver driver;

    public LoginDetails(WebDriver driver) {
        this.driver = driver;
    }

    public void invalid(String username, String password) {
        ElementActions.sendData(driver, By.id("user-name"), username);
        ElementActions.sendData(driver, By.id("password"), password);
        ElementActions.clickElement(driver, By.id("login-button"));
    }


    public void standerUser(){
        ElementActions.sendData(driver, By.id("user-name"),"standard_user");
        ElementActions.sendData(driver, By.id("password"),"secret_sauce");
        ElementActions.clickElement(driver, By.id("login-button"));
    }

    public void lockedUser(){
        ElementActions.sendData(driver, By.id("user-name"),"locked_out_user");
        ElementActions.sendData(driver, By.id("password"),"secret_sauce");
        ElementActions.clickElement(driver, By.id("login-button"));
    }

    public void problemUser(){
        ElementActions.sendData(driver, By.id("user-name"),"problem_user");
        ElementActions.sendData(driver, By.id("password"),"secret_sauce");
        ElementActions.clickElement(driver, By.id("login-button"));
    }

    public void performanceUser(){
        ElementActions.sendData(driver, By.id("user-name"),"performance_glitch_user");
        ElementActions.sendData(driver, By.id("password"),"secret_sauce");
        ElementActions.clickElement(driver, By.id("login-button"));
    }

    public void errorUser(){
        ElementActions.sendData(driver, By.id("user-name"),"error_user");
        ElementActions.sendData(driver, By.id("password"),"secret_sauce");
        ElementActions.clickElement(driver, By.id("login-button"));
    }

    public void visualUser(){
        ElementActions.sendData(driver, By.id("user-name"),"visual_user");
        ElementActions.sendData(driver, By.id("password"),"secret_sauce");
        ElementActions.clickElement(driver, By.id("login-button"));
    }

}
