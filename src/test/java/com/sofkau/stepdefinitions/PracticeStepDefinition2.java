package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.net.URI;

public class PracticeStepDefinition2 {

    private String response2;
    private String resourceUrl;
    private String resourceUrl2;

    @Given("que tengo la url del post a eliminar")
    public void que_tengo_la_url_del_post_a_eliminar() {
        resourceUrl = "https://jsonplaceholder.typicode.com/posts/1";
    }

    @When("envio  una peticion de tipo delete a la url del recurso")
    public void envioUnaPeticionDeTipoDeleteALaUrlDelRecurso() {

        RestAssured
                .given()
                .when()
                .delete(resourceUrl)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Then("debo obtener una respuesta que debe tener un codigo de estado {int}")
    public void deboObtenerUnaRespuestaQueDebeTenerUnCodigoDeEstado(Integer int1) {
        RestAssured.given().expect().statusCode(200).when().get(resourceUrl);

    }



    ////////////////////////////////////////////////////////////////////
    @Given("que tengo la url del post a actualizar")
    public void que_tengo_la_url_del_post_a_actualizar() {
        resourceUrl2 = "https://jsonplaceholder.typicode.com/posts/2";
    }

    @When("tengo la informacion actualizada del recurso")
    public void tengo_la_informacion_actualizada_del_recurso() {

    }

    @When("envio  una peticion de tipo put a la url del recurso")
    public void envioUnaPeticionDeTipoPutALaUrlDelRecurso() {
        RestAssured
                .given()
                .log()
                .all()
                .when()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    id: 2,\n" +
                        "    title: 'baby boo',\n" +
                        "    body: 'bebe pequenno ',\n" +
                        "    userId: 1,\n" +
                        "  }")
                .put(resourceUrl2)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Then("debo obtener una respuesta con el codigo de estado {int} al obtener el recurso actualizado")
    public void debo_obtener_una_respuesta_con_el_codigo_de_estado_al_obtener_el_recurso_actualizado(Integer expectedStatusCode) {
        RestAssured.given().expect().statusCode(expectedStatusCode).when().get(resourceUrl2);
    }
    @Then("debo obtener una respuesta con un codigo de estado {int}")
    public void deboObtenerUnaRespuestaConUnCodigoDeEstado(Integer int1) {
    }
}
