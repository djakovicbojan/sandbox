package com.htec.sandbox.steps;

import com.htec.sandbox.connectors.SandboxConnector;
import com.htec.sandbox.models.UseCasesModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import java.lang.reflect.Array;
import java.util.Collections;

import static com.htec.sandbox.utils.SharedStateConstants.LOGIN_TOKEN;

public class UseCasesSteps extends BaseSteps {

    @Given("I log in as Djakovic Bojan")
    public void iLogInAsDjakovicBojan() {
        loginAndGetToken();
    }

    @When("I create a use case")
    public void iCreateAUseCase() {
        UseCasesModel body = new UseCasesModel();
        body.setTitle("Title 1");
        body.setDescription("Description 1");
        body.setExpected_result("Expected result 1");
        body.setAutomated(true);
        body.setTeststeps(Collections.singletonList("Step 1"));

        createAUseCase(body);
    }
}
