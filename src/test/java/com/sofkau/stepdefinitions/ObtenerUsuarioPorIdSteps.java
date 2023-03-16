package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class ObtenerUsuarioPorIdSteps {

    /*private Response response;

    @Given("^que el servicio \"([^\"]*)\" está disponible$")
    public void que_el_servicio_está_disponible(String servicio) {
        RestAssured.baseURI = servicio;
    }

    @When("^se realiza una solicitud GET al servicio con el ID del usuario \"([^\"]*)\"$")
    public void se_realiza_una_solicitud_GET_al_servicio_con_el_ID_del_usuario(String id) {
        response = RestAssured.given().get("/" + id);
    }

    @Then("^se espera una respuesta exitosa con código de estado (\\d+)$")
    public void se_espera_una_respuesta_exitosa_con_código_de_estado(int codigo) {
        Assert.assertEquals(codigo, response.getStatusCode());
    }

    @Then("^la respuesta contiene los datos del usuario \"([^\"]*)\"$")
    public void la_respuesta_contiene_los_datos_del_usuario(String nombre) {
        String userName = response.jsonPath().get("name");
        Assert.assertEquals(nombre, userName);
    }

     */
}
