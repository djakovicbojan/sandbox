package com.htec.sandbox.steps;

import com.google.gson.Gson;
import com.htec.sandbox.connectors.SandboxConnector;
import com.htec.sandbox.core.ui.Driver;
import com.htec.sandbox.models.UseCasesModel;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static com.htec.sandbox.utils.SharedStateConstants.*;

public abstract class BaseSteps {

    @Steps
    SandboxConnector sandboxConnector;

    public EasyRandom random =
            new EasyRandom(
                    new EasyRandomParameters()
                            .seed(new Random().nextLong())
                            // sensible string length
                            .stringLengthRange(5, 15)
            );


    public void setup() {
        Driver.getInstance().setDriver();
    }

    public void teardown() {
        Driver.getInstance().closeDriver();
    }

    public WebDriver driver = Driver.getInstance().getDriver();

    public void loginAndGetToken() {
        sandboxConnector.login();
        Serenity.setSessionVariable(LOGIN_TOKEN).to(sandboxConnector.login());
    }

    public void createAUseCase(UseCasesModel body) {

        Response response = sandboxConnector.createUseCase(
                Serenity.sessionVariableCalled(LOGIN_TOKEN), body);

        UseCasesModel model = new Gson().fromJson(response.body().asString(), UseCasesModel.class);

        Serenity.setSessionVariable(RESPONSE_BODY).to(model);
    }

    public void getLatestUseCase(int list) {

        Serenity.setSessionVariable(USE_CASE).to(
                sandboxConnector.listUseCases(Serenity.sessionVariableCalled(LOGIN_TOKEN), list));
    }

    public UseCasesModel navigateToUseCase(int useCase) {
        Response response = sandboxConnector.useCase(Serenity.sessionVariableCalled(LOGIN_TOKEN), useCase);

        UseCasesModel model = new Gson().fromJson(response.body().asString(), UseCasesModel.class);

        Serenity.setSessionVariable(PREVIOUS_USE_CASE).to(model);
        return model;
    }

    public void editUseCase(UseCasesModel body) {

        sandboxConnector.editUseCase(body, Serenity.sessionVariableCalled(LOGIN_TOKEN),
                Serenity.sessionVariableCalled(USE_CASE));

    }
}
