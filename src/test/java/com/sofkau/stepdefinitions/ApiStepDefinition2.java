package com.sofkau.stepdefinitions;

import com.sofkau.pages.CommonActionOnPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class ApiStepDefinition2 extends CommonActionOnPage {
    private Response response;

    @Given("que el administrador quiere obtener informacion de un color especifico")
    public void queElAdministradorQuiereObtenerInformacionDeUnColorEspecifico() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("envia solicitud valida")
    public void enviaSolicitudValida() {
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("/api/unknown/2");
    }

    @Then("debera recibir las propiedades que contiene un color")
    public void deberaRecibirLasPropiedadesQueContieneUnColor() {
        String responseBody = response.then().log().all().statusCode(200).extract().body().asString();
        Assertions.assertEquals(response.getStatusCode(),200);
    }

    @Given("que el administrador quiere tener informacion de un color en especifico")
    public void queElAdministradorQuiereTenerInformacionDeUnColorEnEspecifico() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("envia solicitud invalida en la ruta")
    public void enviaSolicitudInvalidaEnLaRuta() {
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("/api/unknown/2");
    }

    @Then("debera recibir respuesta invalida")
    public void deberaRecibirRespuestaInvalida() {
        String responseBody2 = response.then().log().all().statusCode(200).extract().body().asString();
        Assertions.assertEquals(response.getStatusCode(),200);
    }
}