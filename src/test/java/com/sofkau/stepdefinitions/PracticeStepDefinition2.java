package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;

import java.net.URI;

public class PracticeStepDefinition2 {
    public static org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(PracticeStepDefinition2.class));

    private String response2;
    private String resourceUrl;


    @Given("que tengo la url del post a eliminar")
    public void que_tengo_la_url_del_post_a_eliminar() {
        resourceUrl = "https://jsonplaceholder.typicode.com/posts/1";
    }

    @When("envio  una peticion de tipo delete a la url del recurso")
    public void envioUnaPeticionDeTipoDeleteALaUrlDelRecurso() {

        try {
            RestAssured
                    .given()
                    .when()
                    .delete(resourceUrl)
                    .then()
                    .log().all()
                    .statusCode(200);
        } catch (Exception e) {
            LOGGER.info("Error al enviar la petición DELETE: " + e.getMessage());
        }
    }

    @Then("debo obtener una respuesta que debe tener un codigo de estado {int}")
    public void deboObtenerUnaRespuestaQueDebeTenerUnCodigoDeEstado(Integer int1) {
        try {
            RestAssured.given().expect().statusCode(200).when().get(resourceUrl);
            LOGGER.info("SI CUMPLE");
        } catch (Exception e) {
            LOGGER.info("Error al obtener la respuesta: " + e.getMessage());
        }

    }

}
