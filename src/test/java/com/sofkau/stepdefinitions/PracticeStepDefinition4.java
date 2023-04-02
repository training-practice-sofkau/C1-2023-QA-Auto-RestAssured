package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;



public class PracticeStepDefinition4 {
    public static org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(PracticeStepDefinition4.class));

    private String url;

    @Given("que tengo acceso al servicio de Reqres")
    public void queTengoAccesoAlServicioDeReqres() {
        try {
            url = "https://reqres.in";
        } catch (Exception e) {
            LOGGER.error("Ha ocurrido un error al asignar la URL: " + e.getMessage());
        }

    }
    @When("envio una peticion de tipo GET para ver la lista de recursos")
    public void envioUnaPeticionDeTipoGETParaVerLaListaDeRecursos() {

        try {
            RestAssured
                    .given()
                    .when()
                    .get(url+ "/api/unknown")
                    .then()
                    .log().all()
                    .statusCode(200);
        } catch (Exception e) {
            LOGGER.error("Ha ocurrido un error al enviar la petición GET: " + e.getMessage());
        }

    }
    @Then("obtengo una respuesta exitosa con una lista de recursos")
    public void obtengoUnaRespuestaExitosaConUnaListaDeRecursos() throws ParseException {
        try {
            Response response = RestAssured
                    .given()
                    .when()
                    .get(url+ "/api/unknown")
                    .then()
                    .log().all()
                    .statusCode(200)
                    .extract().response();

            String responseBody = response.getBody().asString();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(responseBody);


            Assert.assertTrue(jsonObject.containsKey("page"));
            Assert.assertTrue(jsonObject.containsKey("per_page"));
            Assert.assertTrue(jsonObject.containsKey("total"));
            Assert.assertTrue(jsonObject.containsKey("total_pages"));
            Assert.assertTrue(jsonObject.containsKey("data"));
            Assert.assertTrue(jsonObject.containsKey("support"));


            Assert.assertEquals(1L, jsonObject.get("page"));
            Assert.assertEquals(6L, jsonObject.get("per_page"));
            Assert.assertEquals(12L, jsonObject.get("total"));
            Assert.assertEquals(2L, jsonObject.get("total_pages"));

            JSONArray dataArray = (JSONArray) jsonObject.get("data");
            Assert.assertEquals(6, dataArray.size());


            JSONObject firstDataObject = (JSONObject) dataArray.get(0);
            Assert.assertEquals(1L, firstDataObject.get("id"));
            Assert.assertEquals("cerulean", firstDataObject.get("name"));
            Assert.assertEquals(2000L, firstDataObject.get("year"));
            Assert.assertEquals("#98B2D1", firstDataObject.get("color"));
            Assert.assertEquals("15-4020", firstDataObject.get("pantone_value"));

            LOGGER.info("Validacion de la respuesta exitosa con una lista de recursos completada, SI CUMPLE");
        } catch (Exception e) {
            LOGGER.error("Ha ocurrido un error al obtener la respuesta de la petición GET: " + e.getMessage());
        };
    }
}
