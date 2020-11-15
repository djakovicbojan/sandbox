package com.htec.sandbox.core.ui.pageObjects;

import com.htec.sandbox.core.ui.Driver;
import com.htec.sandbox.steps.BaseSteps;


public class LoginPage extends BaseSteps {


    public String URL = "https://qa-sandbox.apps.htec.rs/";
    public String loginButton = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/a[2]";
    public String email = "djakovicbojan90@gmail.com";
    public String password = "Bojan123!";


    public void navigateToLoginPage() {
        Driver.getInstance().getDriver().navigate().to(URL);
    }

}


