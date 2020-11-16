package com.htec.sandbox.core.ui.steps;

import com.htec.sandbox.core.ui.pageObjects.LoginPagePO;

import com.htec.sandbox.steps.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class LoginSteps extends BaseSteps {

    LoginPagePO loginPagePO = new LoginPagePO();

    @Before
    public void setUp() {
        setup();
    }

    @After
    public void tearDown() {
        teardown();
    }

    @Given("User is logged in")
    public void userIsLoggedIn() {

        loginPagePO.navigateToLoginPage();
        loginPagePO.login();
    }
}
