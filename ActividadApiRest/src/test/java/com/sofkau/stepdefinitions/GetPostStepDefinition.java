package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class GetPostStepDefinition {
    private String body;
    private Response response;
    @Given("estoy apuntando con un endpoint a la api3")
    public void estoyApuntandoConUnEndpointALaApi3() {
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
    }
    @When("envio la peticion get mediante el endpoint2")
    public void envioLaPeticionGetMedianteElEndpoint2() {
        response=RestAssured.given().log().all().when().get("2");
    }
    @Then("obtengo una respuesta ok3")
    public void obtengoUnaRespuestaOk3() {
        response.then().statusCode(200);
        body= RestAssured.given().log().all().when().get("2").then().log().all().extract().body().asString();
        System.out.println(body);
    }
}
