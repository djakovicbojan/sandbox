package com.htec.sandbox.core.ui.steps;

import com.htec.sandbox.core.ui.pageObjects.LoginPage;

import com.htec.sandbox.steps.BaseSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class LoginSteps extends BaseSteps {

    LoginPage loginPage = new LoginPage();

    @Before
    public void setUp() {
        setup();
    }

    @Given("User navigates to sandbox login page")
    public void userNavigatesToSandboxLoginPage() {

        loginPage.navigateToLoginPage();
    }
}
