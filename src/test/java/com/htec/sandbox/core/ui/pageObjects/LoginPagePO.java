package com.htec.sandbox.core.ui.pageObjects;

import com.htec.sandbox.core.ui.Driver;
import com.htec.sandbox.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPagePO extends BaseSteps {


    public String URL = "https://qa-sandbox.apps.htec.rs/";
    public String loginButton = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/a[2]";
    public String emailElement = "email";
    public String passwordElement = "password";
    public String submitButton = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/form/button";

    public String email = "djakovicbojan90@gmail.com";
    public String password = "Bojan123!";



    public void navigateToLoginPage() {
        Driver.getInstance().getDriver().navigate().to(URL);
    }

    public void login() {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(loginButton)));

        driver.findElement(By.xpath(loginButton)).click();

        driver.findElement(By.name(emailElement)).sendKeys(email);
        driver.findElement(By.name(passwordElement)).sendKeys(password);
        driver.findElement(By.xpath(submitButton)).click();
    }

}


