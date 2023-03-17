package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class StepObtenerUsuarios {


    public static Logger LOGGER = Logger.getLogger(String.valueOf(StepObtenerUsuarios.class));
    private Response response;
    private JSONArray allUsers;

    @Given("que estoy en la pagina {string}")
    public void que_estoy_en_la_pagina(String url) {
        RestAssured.baseURI = url;
    }

    @When("envio una solicitud GET a la URL {string}")
    public void envio_una_solicitud_GET_a_la_URL(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @Then("la respuesta debe tener el codigo de estado {int}")
    public void la_respuesta_debe_tener_el_codigo_de_estado(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        LOGGER.info("Codigo de estado esperado: " + expectedStatusCode);
        LOGGER.info("Codigo de estado obtenido: " + actualStatusCode);
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("la respuesta debe contener todos los usuarios en formato JSON")
    public void la_respuesta_debe_contener_todos_los_usuarios_en_formato_JSON() throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response.asString());
        allUsers = (JSONArray) obj;
        // Validamos que la respuesta tenga al menos 1 usuario
        boolean hasUsers = allUsers.size() > 0;
        LOGGER.info("La respuesta contiene al menos 1 usuario: " + hasUsers);
        assertEquals(true, hasUsers);
    }
}


