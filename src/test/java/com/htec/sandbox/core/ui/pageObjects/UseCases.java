package com.htec.sandbox.core.ui.pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class UseCases {

    @FindBy(name = "username")
    private WebElementFacade usernameField;
    @FindBy(name = "password")
    private WebElementFacade passwordField;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/a[2]")
    private WebElementFacade loginButton;
    @FindBy(id = "submit_btn")
    private WebElementFacade submitButton;

}
