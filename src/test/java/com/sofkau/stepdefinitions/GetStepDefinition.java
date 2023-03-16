package com.sofkau.stepdefinitions;

import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.net.http.HttpResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetStepDefinition {

    private Response response;

    /**
     * Scenario 1
     */
    @Given("que realizo una solicitud para obtener una lista de usuarios")
    public void que_realizo_una_solicitud_para_obtener_una_lista_de_usuarios() {
        response = given()
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

    /**
     * Scenario 2
     */

    @Given("el admministrador esta en la API de ReqRes")
    public void elAdmministradorEstaEnLaAPIDeReqRes() {
        RestAssured.baseURI = "https://reqres.in/api";

    }
    @When("realiza una solicitud para obtener de la lista una cantidad {int} de usuarios")
    public void realizaUnaSolicitudParaObtenerDeLaListaUnaCantidadDeUsuarios(Integer cantidad) {
        response = given()
                .log()
                .all()
                .queryParam("per_page", cantidad)
                .when()
                .get("https://reqres.in/api/users");


    }

    @Then("debe mostrar como maximo una lista con una cantidad {int} de usuarios")
    public void debeMostrarComoMaximoUnaListaConUnaCantidadDeUsuarios(Integer cantidad) {
        String respuesta =
                 response.then()
                         .log()
                         .all()
                         .assertThat()
                         .statusCode(200)
                         .body("data.size()", lessThanOrEqualTo(cantidad))
                         .extract()
                         .asString();

    }

}
