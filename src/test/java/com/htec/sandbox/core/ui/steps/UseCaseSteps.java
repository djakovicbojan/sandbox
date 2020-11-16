package com.htec.sandbox.core.ui.steps;

import com.htec.sandbox.core.ui.pageObjects.UseCasesPO;
import com.htec.sandbox.steps.BaseSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UseCaseSteps extends BaseSteps {

    UseCasesPO useCasesPO = new UseCasesPO();
    
    @When("User creates {int} new use cases")
    public void userCreatesNewUseCases(int useCasesNumber) {

        useCasesPO.navigateToUseCasePage();

        for (int i = 0; i < useCasesNumber; i++) {
            useCasesPO.createUseCases();
        }
    }

    @Then("User edit {int} use cases previously created")
    public void userEditPreviouslyCreatedUseCases(int useCasesNumber) {

        for (int i = 0; i < useCasesNumber; i++) {
            useCasesPO.editUseCases(i + 1);
        }
    }

}