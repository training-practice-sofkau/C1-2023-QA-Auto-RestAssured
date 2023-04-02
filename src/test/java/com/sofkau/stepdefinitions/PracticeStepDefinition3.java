package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class PracticeStepDefinition3 {
    public static org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(PracticeStepDefinition3.class));
    private String resourceUrl2;

    @Given("que tengo la url del post a actualizar")
    public void que_tengo_la_url_del_post_a_actualizar() {
        resourceUrl2 = "https://jsonplaceholder.typicode.com/posts/2";
    }

    @When("tengo la informacion actualizada del recurso")
    public void tengo_la_informacion_actualizada_del_recurso() {

    }

    @When("envio  una peticion de tipo put a la url del recurso")
    public void envioUnaPeticionDeTipoPutALaUrlDelRecurso() {
        try {
            RestAssured
                    .given()
                    .log()
                    .all()
                    .when()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "    \"id\": 2,\n" +
                            "    \"title\": \"baby boomini\",\n" +
                            "    \"body\": \"bebe pequenno\",\n" +
                            "    \"userId\": 1\n" +
                            "}")
                    .put(resourceUrl2)
                    .then()
                    .log()
                    .all()
                    .statusCode(200);
        } catch (Exception e) {
            LOGGER.error("Ha ocurrido un error al enviar la petición PUT a la URL del recurso: " + resourceUrl2, e);
            throw e;
        }
    }

    @Then("debo obtener una respuesta con un codigo de estado {int} al obtener el recurso actualizado")
    public void deboObtenerUnaRespuestaConUnCodigoDeEstadoAlObtenerElRecursoActualizado(Integer expectedStatusCode) throws ParseException {
        try {
            Response response = RestAssured.get(resourceUrl2);
            RestAssured.given().expect().statusCode(expectedStatusCode).when().get(resourceUrl2);

            String responseBody = response.getBody().asString();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(responseBody);

            Assert.assertEquals(2L, jsonObject.get("id"));
            Assert.assertEquals(1L, jsonObject.get("userId"));
            Assert.assertNotNull(jsonObject.get("title"));
            LOGGER.info("SI CUMPLE");
        } catch (Exception e) {
            LOGGER.error("Ha ocurrido un error al obtener la respuesta con un código de estado " + expectedStatusCode
                    + " al obtener el recurso actualizado de la URL: " + resourceUrl2, e);
            throw e;
        }
    }
}
