package com.htec.sandbox.connectors;

import com.google.gson.Gson;
import com.htec.sandbox.models.UseCasesModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.util.Arrays;
import java.util.List;

public class SandboxConnector {

    private final String baseUrl = "https://qa-sandbox.apps.htec.rs";

    public String login() {
        Response response = SerenityRest
                .with()
                .contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .body("{\"email\":\"djakovicbojan90@gmail.com\",\"password\":\"Bojan123!\"}")
                .post("/api/users/login");

        response.then().statusCode(200);
        return response.path("token");

    }

    public int listUseCases(String token, int list) {
        Response response = SerenityRest
                .with()
                .contentType(ContentType.JSON)
                .header("authorization", "Bearer " + token)
                .baseUri(baseUrl)
                .get("/api/usecases/all");

        response.then().statusCode(200);

        UseCasesModel[] id = new Gson().fromJson(response.body().asString(), UseCasesModel[].class);

        return id[list].getUsecase_id();
    }

    public List<UseCasesModel> listAllUseCases(String token) throws Exception {
        Response response = SerenityRest
                .with()
                .contentType(ContentType.JSON)
                .header("authorization", "Bearer " + token)
                .baseUri(baseUrl)
                .get("/api/usecases/all").prettyPeek();

        if (response.statusCode() == 200) {
            return Arrays.asList(new Gson().fromJson(response.body().asString(), UseCasesModel[].class));

        } else if (response.statusCode() == 204) {
            throw new Exception("The list is empty. There are no use cases in the list");
        }
        else {throw new Exception("Something went wrong. Environment is not healthy");
        }

    }

    public void deleteUseCase(String token, int useCase) {

        Response response = SerenityRest
                .with().log().all()
                .contentType(ContentType.JSON)
                .header("authorization", "Bearer " + token)
                .baseUri(baseUrl)
                .delete("/api/usecases/usecase/" + useCase).prettyPeek();

        response.then().statusCode(200);
    }

    public Response createUseCase(String token, UseCasesModel body) {
        Response response = SerenityRest
                .with().log().all()
                .contentType(ContentType.JSON)
                .header("authorization", "Bearer " + token)
                .body(body)
                .baseUri(baseUrl)
                .post("/api/usecases/usecase").prettyPeek();

        response.then().statusCode(200);
        return response;
    }

    public Response useCase(String token, int useCase) {
        Response response = SerenityRest
                .with().log().all()
                .contentType(ContentType.JSON)
                .header("authorization", "Bearer " + token)
                .baseUri(baseUrl)
                .get("/api/usecases/" + useCase).prettyPeek();

        response.then().statusCode(200);
        return response;
    }

    public void editUseCase(UseCasesModel body, String token, int useCase) {

            Response response = SerenityRest
                    .with().log().all()
                    .contentType(ContentType.JSON)
                    .header("authorization", "Bearer " + token)
                    .baseUri(baseUrl)
                    .body(body)
                    .put("/api/usecases/usecase/" + useCase).prettyPeek();

            response.then().statusCode(200);
        }

}
