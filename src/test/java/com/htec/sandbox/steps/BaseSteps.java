package com.htec.sandbox.steps;

import com.google.gson.Gson;
import com.htec.sandbox.connectors.SandboxConnector;
import com.htec.sandbox.models.UseCasesModel;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

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

    public void getLatestUseCase() {
        Serenity.setSessionVariable(USE_CASE).to(
                sandboxConnector.listUseCases(Serenity.sessionVariableCalled(LOGIN_TOKEN)));
    }

    public UseCasesModel navigateToUseCase(int useCase) {
        Response response = sandboxConnector.useCase(Serenity.sessionVariableCalled(LOGIN_TOKEN), useCase);

        UseCasesModel model = new Gson().fromJson(response.body().asString(), UseCasesModel.class);

        Serenity.setSessionVariable(PREVIOUS_USE_CASE).to(model);
        return model;
    }

    public UseCasesModel editUseCase(UseCasesModel body) {
        Response response = sandboxConnector.editUseCase(body, Serenity.sessionVariableCalled(LOGIN_TOKEN),
                Serenity.sessionVariableCalled(USE_CASE));

        UseCasesModel model = new Gson().fromJson(response.body().asString(), UseCasesModel.class);

        return model;
    }
}
