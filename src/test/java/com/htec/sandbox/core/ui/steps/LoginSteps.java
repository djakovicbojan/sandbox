package com.htec.sandbox.core.ui.steps;

import com.htec.sandbox.core.ui.pageObjects.LoginPagePO;

import com.htec.sandbox.steps.BaseSteps;
import io.cucumber.java.en.Given;

public class LoginSteps extends BaseSteps {

    LoginPagePO loginPagePO = new LoginPagePO();

    @Given("User is logged in")
    public void userIsLoggedIn() {

        loginPagePO.navigateToLoginPage();
        loginPagePO.login();
    }
}
