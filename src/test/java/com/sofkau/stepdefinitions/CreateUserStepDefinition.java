package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUserStepDefinition {
    private String requestBody;
    private Response response;

    //Scenario 1
    @Given("tengo la informacion del usuario")
    public void tengoLaInformacionDelUsuario() {
        requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
    }
    @When("la envio en una peticion")
    public void laEnvioEnUnaPeticion() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("https://reqres.in/api/users");
    }
    @Then("debo obtener una respuesta positiva con los demas datos de creacion")
    public void deboObtenerUnaRespuestaPositivaConLosDemasDatosDeCreacion() {
        System.out.println(response.asString());
    }

    //Scenario 2
    @Given("Tengo la informacion incompleta")
    public void tengoLaInformacionIncompleta() {
        requestBody = "{\n" +
                "    \"job\": \"leader\"\n" +
                "}";
    }
    @When("la envio en una peticion con la informacion incompleta")
    public void laEnvioEnUnaPeticionConLaInformacionIncompleta() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("https://reqres.in/api/users");
    }
    @Then("debo obtener una respuesta de error")
    public void deboObtenerUnaRespuestaDeError() {
        response.then().statusCode(400);
    }

    //Scenario 3
    @Given("Tengo la informacion sin trabajo")
    public void tengoLaInformacionSinTrabajo() {
        requestBody = "{\n" +
                "    \"name\": \"morpheus\"\n" +
                "}";
    }
    @When("la envio en una peticion sin trabajo")
    public void laEnvioEnUnaPeticionSinTrabajo() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("https://reqres.in/api/users");
    }
    @Then("debo obtener un error")
    public void deboObtenerUnError() {
        response.then().statusCode(400);
    }
}
