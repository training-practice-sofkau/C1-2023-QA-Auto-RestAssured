package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class APIRegisterStepDefinitions {
    private Response response;

    @Given("estoy en la pagina de registro")
    public void estoy_en_la_pagina_de_registro() {
        RestAssured.baseURI = "https://reqres.in/api";

    }
    @When("ingreso los datos de email y password")
    public void ingreso_los_datos_de_email_y_password() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "eve.holt@reqres.in");
        requestParams.put("password", "pistol");
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestParams.toString())
                .post("/register");
    }
    @Then("se debe obtener un codigo de respuesta {string}")
    public void se_debe_obtener_un_codigo_de_respuesta(String id) {
        Assert.assertEquals(id, response.getStatusCode());
        try {
            Assert.assertEquals("El código de respuesta es incorrecto", 200, response.getStatusCode());
            System.out.println("El código de respuesta es correcto");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
    @Then("se debe obtener un token")
    public void se_debe_obtener_un_token() {
        Assert.assertNotNull(response.jsonPath().getString("token"));    }
}
