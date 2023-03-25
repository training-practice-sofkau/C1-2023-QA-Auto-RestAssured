package com.sofkau.stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

public class GetPlaceholderStepDefinition {
    private Response response;
    @Given("que el administrador tiene el id de una publicacion")
    public void queElAdministradorTieneElIdDeUnaPublicacion() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    @When("hace una peticion con el id correcto")
    public void haceUnaPeticionConElIdCorrecto() {
        response = RestAssured
                .when()
                .get("/posts/1");
    }
    @Then("debera recibir una respuesta con la informacion de la publicacion y codigo de estado {int}")
    public void deberaRecibirUnaRespuestaConLaInformacionDeLaPublicacionYCodigoDeEstado(Integer statusCode) {
        String responseBody = response.then().log().all().extract().asString();
        Assertions.assertEquals(statusCode,response.getStatusCode());

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(responseBody);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String titulo = (String) jsonObject.get("title");
        String tituloEsperado = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
        Assertions.assertEquals(tituloEsperado, titulo);

    }

    //Scenario 2
    @When("hace una peticion con el id incorrecto")
    public void haceUnaPeticionConElIdIncorrecto() {
        response = RestAssured
                .when()
                .get("/posts/a");
    }
    @Then("debera recibir una respuesta codigo de estado {int}")
    public void deberaRecibirUnaRespuestaCodigoDeEstado(Integer statusCode) {
        String responseBody = response.then().log().all().extract().asString();
        Assertions.assertEquals(statusCode,response.getStatusCode());
    }

}
