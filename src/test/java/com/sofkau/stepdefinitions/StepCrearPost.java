package com.sofkau.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import java.util.logging.Logger;
public class StepCrearPost {

    public static Logger LOGGER = Logger.getLogger(String.valueOf(StepCrearPost.class));
    private String requestBody;
    private Response response;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    //Scenario 1
    @Given("tengo los datos del post a crear")
    public void tengoLosDatosDelPostACrear() {
        requestBody = "{\n" +
                "    \"title\": \"Nuevo post\",\n" +
                "    \"body\": \"Contenido del post\",\n" +
                "    \"userId\": 1\n" +
                "}";
    }

    @When("envio una peticion para crear el post")
    public void envioUnaPeticionParaCrearElPost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("posts");
    }

    @Then("debo obtener una respuesta positiva con los datos del post creado")
    public void deboObtenerUnaRespuestaPositivaConLosDatosDelPostCreado() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals(response.getStatusCode(), 201);
            Assertions.assertEquals("Nuevo post", responseBody.get("title"));
            Assertions.assertEquals("Contenido del post", responseBody.get("body"));
            Assertions.assertEquals(1L, responseBody.get("userId"));
            LOGGER.info("Valor esperado: Nuevo post | Valor obtenido: " + responseBody.get("title") + " | Cumple: " + responseBody.get("title").equals("Nuevo post"));
            LOGGER.info("Valor esperado: Contenido del post | Valor obtenido: " + responseBody.get("body") + " | Cumple: " + responseBody.get("body").equals("Contenido del post"));
            LOGGER.info("Valor esperado: 1 | Valor obtenido: " + responseBody.get("userId") + " | Cumple: " + responseBody.get("userId").equals(1L));
        } catch (ParseException e) {
            LOGGER.warning(e.getMessage());
            Assertions.fail();
        }
    }

    //Scenario 2
    @Given("tengo los datos incompletos del post a crear")
    public void tengoLosDatosIncompletosDelPostACrear() {
        requestBody = "{\n" +
                "    \"body\": \"Contenido del post\",\n" +
                "    \"userId\": 1\n" +
                "}";
    }

    @Then("debo obtener una respuesta de error")
    public void deboObtenerUnaRespuestaDeError() {
        response.then().statusCode(400);
    }
}
