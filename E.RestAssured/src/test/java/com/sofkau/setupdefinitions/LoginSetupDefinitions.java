package com.sofkau.setupdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginSetupDefinitions {
    private String requestBody;
    private Response response;
    @Given("que realizo una solicitud para loguearme")
    public void queRealizoUnaSolicitudParaLoguearme() {
        requestBody = "{{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}}";
    }
    @When("la solicitud es exitosa")
    public void laSolicitudEsExitosa() {
        response = RestAssured.given().
                contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://reqres.in/api/register");


    }
    @Then("debera mostrar un tocken")
    public void deberaMostrarUnTocken() {
        System.out.println(response.asString());
    }
}
