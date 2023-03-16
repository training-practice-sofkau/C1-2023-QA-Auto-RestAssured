package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
public class CrearUsuarioSteps {

    private Response response;
    private JSONObject payload;

    @Given("^que el servicio \"([^\"]*)\" está disponible$")
    public void que_el_servicio_está_disponible(String servicio) {
        RestAssured.baseURI = servicio;
    }

    @Given("^el payload del usuario es:$")
    public void el_payload_del_usuario_es(String payloadStr) {
        //payload = new JSONObject(payloadStr);
    }

    @When("^se realiza una solicitud POST al servicio con el payload$")
    public void se_realiza_una_solicitud_POST_al_servicio_con_el_payload() {
        response = RestAssured.given().contentType(ContentType.JSON).body(payload.toString()).post();
    }

    @Then("^se espera una respuesta exitosa con código de estado (\\d+)$")
    public void se_espera_una_respuesta_exitosa_con_código_de_estado(int codigo) {
        Assert.assertEquals(codigo, response.getStatusCode());
    }

    @Then("^la respuesta contiene los datos del usuario creado$")
    public void la_respuesta_contiene_los_datos_del_usuario_creado() {
        String name = response.jsonPath().get("name");
        String job = response.jsonPath().get("job");
        Assert.assertEquals("John", name);
        Assert.assertEquals("Developer", job);
    }
}
