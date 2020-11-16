package com.htec.sandbox.utils;

import com.htec.sandbox.connectors.SandboxConnector;
import com.htec.sandbox.models.UseCasesModel;
import com.htec.sandbox.steps.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import static com.htec.sandbox.utils.SharedStateConstants.LOGIN_TOKEN;


public class Hooks extends BaseSteps {

    @Steps
    SandboxConnector sandboxConnector;

    @Before("@gui")
    public void setUp() {
        setup();
    }

    @After("@gui")
    public void tearDown() {
        teardown();
    }

    @After("@delete")
    public void deleteUseCases() {

        loginAndGetToken();

        List<UseCasesModel> list = sandboxConnector.listAllUseCases(Serenity.sessionVariableCalled(LOGIN_TOKEN));

        for (UseCasesModel useCasesModel : list) {

            int usecase = useCasesModel.getUsecase_id();
            sandboxConnector.deleteUseCase(Serenity.sessionVariableCalled(LOGIN_TOKEN), usecase);
        }
    }
}
