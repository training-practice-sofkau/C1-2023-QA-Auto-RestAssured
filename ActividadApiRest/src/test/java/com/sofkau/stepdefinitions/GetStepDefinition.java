package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetStepDefinition {

    private String body;
    private Response response;

    @Given("estoy apuntando con un endpoint a la api")
    public void estoyApuntandoConUnEndpointALaApi() {
        RestAssured.baseURI="https://reqres.in/api";
    }
    @When("envio la peticion get mediante el endpoint")
    public void envioLaPeticionGetMedianteElEndpoint() {
        response=RestAssured.given().log().all().when().get("users?page=2");
        //.then().log().all().extract().body().asString();
    }
    @Then("obtengo una respuesta ok1")
    public void obtengoUnaRespuestaOk1() {
        response.then().statusCode(200);
        body= RestAssured.given().log().all().when().get("users?page=2").then().log().all().extract().body().asString();
        System.out.println(body);
    }
}
