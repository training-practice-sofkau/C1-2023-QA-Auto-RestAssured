package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetStepDefinition {

    private Response response;

    @Given("que realizo una solicitud para obtener una lista de usuarios")
    public void que_realizo_una_solicitud_para_obtener_una_lista_de_usuarios() {
        response = RestAssured
                .given()
                .log()
                .all()
                .get("https://reqres.in/api/users?page=2");

    }

    @When("la solicitud es exitosa")
    public void la_solicitud_es_exitosa() {
        response.then().log().all();

    }

    @Then("debe mostrar como respuesta una lista que contiene los usuarios")
    public void debe_mostrar_como_respuesta_una_lista_que_contiene_los_usuarios() {
        int expectedStatusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

    }

}
