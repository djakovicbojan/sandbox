package com.htec.sandbox.connectors;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;

public class SandboxConnector {

    private String email = "djakovicbojan90@gmail.com";
    private String password = "Bojan123!";

    private String body = "{\"email\":\"djakovicbojan90@gmail.com\",\"password\":\"Bojan123!\"}";
    private String baseUrl = "https://qa-sandbox.apps.htec.rs";

    public String loginAndGetToken() {
        Response response = SerenityRest
                .with()
                .contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .body(body)
                .post("/api/users/login");

        response.then().statusCode(200);
        return response.path("token");
    }

    public Response useCases() {
        Response response = SerenityRest
                .with().log().all()
                .contentType(ContentType.JSON)
                .header("authorization", "Bearer " + loginAndGetToken())
                .baseUri(baseUrl)
                .get("/api/usecases/all");

        response.then().statusCode(204);
        return response;
    }

}
