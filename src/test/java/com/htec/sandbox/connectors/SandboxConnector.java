package com.htec.sandbox.connectors;

import com.htec.sandbox.models.UseCasesModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import java.lang.reflect.Array;

import static com.htec.sandbox.utils.SharedStateConstants.LOGIN_TOKEN;

public class SandboxConnector {

    private String email = "djakovicbojan90@gmail.com";
    private String password = "Bojan123!";

    private String body = "{\"email\":\"djakovicbojan90@gmail.com\",\"password\":\"Bojan123!\"}";
    private String baseUrl = "https://qa-sandbox.apps.htec.rs";

    public String login() {
        Response response = SerenityRest
                .with()
                .contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .body(body)
                .post("/api/users/login");

        response.then().statusCode(200);
        return response.path("token");

    }

    public Response useCases(String token) {
        Response response = SerenityRest
                .with().log().all()
                .contentType(ContentType.JSON)
                .header("authorization", "Bearer " + token)
                .baseUri(baseUrl)
                .get("/api/usecases/all");

        response.then().statusCode(204);
        return response;
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

}
