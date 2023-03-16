package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.Map;

public class ActualizarUsuarioSteps {

   private Response response;
    private JSONObject payload;

    @Given("que el servicio esta disponible")
    public void que_el_servicio_esta_disponible(String servicio) {
        RestAssured.baseURI = servicio;
    }

    @Given("el payload de actualizacion del usuario es:")
    public void el_payload_de_actualizacion_del_usuario_es(Map payloadStr) {
        payload = new JSONObject(payloadStr);
    }

    @When("se realiza una solicitud PUT al servicio con el ID del usuario 2 y el payload de actualizacion")
    public void se_realiza_una_solicitud_PUT_al_servicio_con_el_ID_del_usuario_2_y_el_payload_de_actualizacion(int idUsuario) {
        response = RestAssured.given().contentType(ContentType.JSON).body(payload.toString()).put("/" + idUsuario);
    }

    @Then("se espera una respuesta exitosa con codigo de estado 200")
    public void se_espera_una_respuesta_exitosa_con_codigo_de_estado_200(int codigo) {
        Assert.assertEquals(codigo, response.getStatusCode());
    }

    @Then("la respuesta contiene los datos actualizados del usuario")
    public void la_respuesta_contiene_los_datos_actualizados_del_usuario() {
        String job = response.jsonPath().get("job");
        Assert.assertEquals("Senior Developer", job);
    }

}

