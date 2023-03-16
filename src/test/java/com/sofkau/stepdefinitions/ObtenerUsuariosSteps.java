package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class ObtenerUsuariosSteps {

    private Response response;

    @Given("^que el servicio \"([^\"]*)\" está disponible$")
    public void que_el_servicio_está_disponible(String servicio) {
        RestAssured.baseURI = servicio;
    }

    @When("^se realiza una solicitud GET al servicio$")
    public void se_realiza_una_solicitud_GET_al_servicio() {
        response = RestAssured.given().get();
    }

    @Then("^se espera una respuesta exitosa con código de estado (\\d+)$")
    public void se_espera_una_respuesta_exitosa_con_código_de_estado(int codigo) {
        Assert.assertEquals(codigo, response.getStatusCode());
    }

    @Then("^la respuesta contiene al menos (\\d+) usuarios$")
    public void la_respuesta_contiene_al_menos_usuarios(int cantidad) {
        int size = response.jsonPath().getList("").size();
        Assert.assertTrue(size >= cantidad);
    }
}

