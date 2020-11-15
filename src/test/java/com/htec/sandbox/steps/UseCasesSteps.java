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

    @Then("I edit {int} test case with length value")
    public void iEditFirstTestCaseWithLengthValue(int useCasesNumber) {

        for (int i = 0; i < useCasesNumber; i++) {

            getLatestUseCase(i);
            UseCasesModel lastTestCase = navigateToUseCase(Serenity.sessionVariableCalled(USE_CASE));


            int titleLength = lastTestCase.getTitle().length();
            int descriptionLength = lastTestCase.getTitle().length();
            int expectedLength = lastTestCase.getDescription().length();
            int stepLength = lastTestCase.getTeststeps().get(0).length();

            lastTestCase.setTitle("This field previously had " + titleLength + " characters");
            lastTestCase.setDescription("This field previously had " + descriptionLength + " characters");
            lastTestCase.setExpected_result("This field previously had " + expectedLength + " characters");
            lastTestCase.setTeststeps(Collections.singletonList("This field previously had " + stepLength + " characters"));

            editUseCase(lastTestCase);
        }
    }
}
