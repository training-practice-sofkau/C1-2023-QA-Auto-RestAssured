package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import java.util.logging.Logger;


public class StepObtenerPosts {

    public static Logger LOGGER = Logger.getLogger(String.valueOf(StepObtenerPosts.class));

    private Response response;

    JSONParser parser = new JSONParser();
    JSONArray responseBody = null;

    //Scenario 1
    @Given("que el usuario hace una solicitud GET a la API")
    public void queElUsuarioHaceUnaSolicitudGETALaAPI() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }

    @When("la solicitud se realiza para obtener todos los posts")
    public void laSolicitudSeRealizaParaObtenerTodosLosPosts() {
        response = RestAssured.given().get("posts");
    }

    @Then("se debe devolver una respuesta exitosa con la lista de posts")
    public void seDebeDevolverUnaRespuestaExitosaConLaListaDePosts() {
        try {
            responseBody = (JSONArray) parser.parse(response.getBody().asString());
            int expectedStatusCode = 200;
            int actualStatusCode = response.getStatusCode();
            LOGGER.info("Valor esperado: " + expectedStatusCode + ", valor obtenido: " + actualStatusCode);
            Assertions.assertEquals(expectedStatusCode, actualStatusCode);

            int expectedResponseSize = 100;
            int actualResponseSize = responseBody.size();
            LOGGER.info("Valor esperado: " + expectedResponseSize + ", valor obtenido: " + actualResponseSize);
            Assertions.assertEquals(expectedResponseSize, actualResponseSize);

        } catch (ParseException e) {
            LOGGER.warning(e.getMessage());
            Assertions.fail();
        }
    }

    //Scenario 2
    @When("la solicitud se realiza para obtener un post con id 1")
    public void laSolicitudSeRealizaParaObtenerUnPostConId1() {
        response = RestAssured.given().get("posts/1");
    }

    @Then("se debe devolver una respuesta exitosa con el post correspondiente")
    public void seDebeDevolverUnaRespuestaExitosaConElPostCorrespondiente() {
        try {
            responseBody = (JSONArray) parser.parse(response.getBody().asString());
            int expectedStatusCode = 200;
            int actualStatusCode = response.getStatusCode();
            LOGGER.info("Valor esperado: " + expectedStatusCode + ", valor obtenido: " + actualStatusCode);
            Assertions.assertEquals(expectedStatusCode, actualStatusCode);

            int expectedPostId = 1;
            int actualPostId = Integer.parseInt(responseBody.get(1).toString());
            LOGGER.info("Valor esperado: " + expectedPostId + ", valor obtenido: " + actualPostId);
            Assertions.assertEquals(expectedPostId, actualPostId);

        } catch (ParseException e) {
            LOGGER.warning(e.getMessage());
            Assertions.fail();
        }
    }

    //Scenario 3
    @When("la solicitud se realiza para obtener un post con id inexistente")
    public void laSolicitudSeRealizaParaObtenerUnPostConIdInexistente() {
        response = RestAssured.given().get("posts/101");
    }

    @Then("se debe devolver una respuesta de error")
    public void seDebeDevolverUnaRespuestaDeError() {
        int expectedStatusCode = 404;
        int actualStatusCode = response.getStatusCode();
        LOGGER.info("Valor esperado: " + expectedStatusCode + ", valor obtenido: " + actualStatusCode);
        response.then().statusCode(expectedStatusCode);
    }
}




