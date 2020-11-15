package com.htec.sandbox.steps;

import com.htec.sandbox.connectors.SandboxConnector;
import com.htec.sandbox.models.UseCasesModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import javax.xml.ws.Response;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

import static com.htec.sandbox.utils.SharedStateConstants.*;

public class UseCasesSteps extends BaseSteps {

    @Given("I log in as Djakovic Bojan")
    public void iLogInAsDjakovicBojan() {
        loginAndGetToken();
    }

    @When("I create a {int} use cases")
    public void iCreateAUseCase(int useCasesNumber) {

        for (int i = 0; i < useCasesNumber; i++) {
            UseCasesModel body = new UseCasesModel();

            body.setTitle(random.nextObject(String.class));
            body.setDescription(random.nextObject(String.class));
            body.setExpected_result(random.nextObject(String.class));
            body.setAutomated(true);
            body.setTeststeps(Collections.singletonList(random.nextObject(String.class)));

            createAUseCase(body);

        }

    }

    @When("I navigate to the created use case")
    public void iNavigateToTestCase() {

        getLatestUseCase();

        UseCasesModel lastTestCase = navigateToUseCase(Serenity.sessionVariableCalled(USE_CASE));

        Serenity.setSessionVariable(PREVIOUS_USE_CASE).to(lastTestCase);

    }

    @Then("I edit test case with length value")
    public void iEditTestCaseWithLengthValue() {
        UseCasesModel body = Serenity.sessionVariableCalled(PREVIOUS_USE_CASE);

        int titleLength = body.getTitle().length();
        int descriptionLength = body.getTitle().length();
        int expectedLength = body.getDescription().length();
        int stepLength = body.getTeststeps().get(0).length();

        body.setTitle("This field previously had " + titleLength + " characters");
        body.setDescription("This field previously had " + descriptionLength + " characters");
        body.setExpected_result("This field previously had " + expectedLength + " characters");
        body.setTeststeps(Collections.singletonList("This field previously had " + stepLength + " characters"));

        editUseCase(body);
    }
}
