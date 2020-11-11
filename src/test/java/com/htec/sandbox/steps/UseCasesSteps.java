package com.htec.sandbox.steps;

import com.htec.sandbox.connectors.SandboxConnector;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class UseCasesSteps {

    @Steps
    SandboxConnector sandboxConnector;

    @Given("I log in as Djakovic Bojan")
    public void iLogInAsDjakovicBojan() {
        System.out.println(sandboxConnector.loginAndGetToken());

        sandboxConnector.useCases();
    }
}
