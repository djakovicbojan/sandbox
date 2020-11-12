package com.htec.sandbox.steps;

import com.htec.sandbox.connectors.SandboxConnector;
import com.htec.sandbox.models.UseCasesModel;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.springframework.beans.factory.annotation.Autowired;

import static com.htec.sandbox.utils.SharedStateConstants.LOGIN_TOKEN;

public abstract class BaseSteps {

    @Steps
    SandboxConnector sandboxConnector;


    public void loginAndGetToken() {
        sandboxConnector.login();
        Serenity.setSessionVariable(LOGIN_TOKEN).to(sandboxConnector.login());
    }

    public void createAUseCase(UseCasesModel body) {

        sandboxConnector.createUseCase(Serenity.sessionVariableCalled(LOGIN_TOKEN), body);
    }
}
