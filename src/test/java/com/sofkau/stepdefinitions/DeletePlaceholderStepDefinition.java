package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class DeletePlaceholderStepDefinition {
    private Response response;
    @Given("que el administrador conoce el id de una publicacion")
    public void queElAdministradorConoceElIdDeUnaPublicacion() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    @When("envia una solicitud con un id de publicacion correcto")
    public void enviaUnaSolicitudConUnIdDePublicacionCorrecto() {
        response = RestAssured
                .when()
                .delete("/posts/1");
    }
    @Then("debera recibir una respuesta con un codigo de estado {int}")
    public void deberaRecibirUnaRespuestaConUnCodigoDeEstado(Integer statusCode) {
        String responseBody = response.then().log().all().extract().asString();
        Assertions.assertEquals(200,response.getStatusCode());

    }

    //scenario 2

    @When("envia una solicitud con un id de publicacion incorrecto")
    public void enviaUnaSolicitudConUnIdDePublicacionIncorrecto() {
        response = RestAssured
                .when()
                .delete("/posts/#");
    }
    @Then("debera recibir una respuesta con codigo de estado {int}")
    public void deberaRecibirUnaRespuestaConCodigoDeEstado(Integer statusCode) {
        String responseBody = response.then().log().all().extract().asString();
        Assertions.assertEquals(statusCode,response.getStatusCode());

    }

}
