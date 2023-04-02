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

public class StepCrearUsuario {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(StepCrearUsuario.class));
    private String requestBody;
    private Response response;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    // Scenario 1
    @Given("tengo la informacion del usuario")
    public void tengoLaInformacionDelUsuario() {
        requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
    }

    @When("la envio en una peticion POST a api users")
    public void laEnvioEnUnaPeticionPost() {
        RestAssured.baseURI = "https://reqres.in/";
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("api/users");
    }

    @Then("debo obtener una respuesta positiva con los demas datos de creacion")
    public void deboObtenerUnaRespuestaPositivaConLosDemasDatosDeCreacion() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals(response.getStatusCode(), 201);
            Assertions.assertEquals("morpheus", responseBody.get("name"));
            Assertions.assertEquals("leader", responseBody.get("job"));
        } catch (ParseException e) {
            LOGGER.warning(e.getMessage());
            Assertions.fail();
        }
    }

    // Scenario 2
    @Given("Tengo la informacion incompleta del usuario")
    public void tengoLaInformacionIncompleta() {
        requestBody = "{\n" +
                "    \"job\": \"leader\"\n" +
                "}";
    }

    @When("la envio en una peticion POST a api users con la informacion incompleta")
    public void laEnvioEnUnaPeticionPostConLaInformacionIncompleta() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("https://reqres.in/api/users");
    }

    @Then("debo obtener un mensaje de error")
    public void deboObtenerUnMensajeDeError() {
        response.then().statusCode(400);
    }
}








/*public class StepObtenerUsuarios {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(StepObtenerUsuarios.class));
    private String requestBody;
    private Response response;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    //Scenario 1
    @Given("tengo la informacion del usuario")
    public void tengoLaInformacionDelUsuario() {
        requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
    }

    @When("la envio en una peticion")
    public void laEnvioEnUnaPeticion() {
        RestAssured.baseURI = "https://reqres.in/";
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("api/users");
    }
    @Then("debo obtener una respuesta positiva con los demas datos de creacion")
    public void deboObtenerUnaRespuestaPositivaConLosDemasDatosDeCreacion() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertEquals(response.getStatusCode(), 201);
            Assertions.assertEquals("morpheus",responseBody.get("name"));
            Assertions.assertEquals("leader",responseBody.get("job"));
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }

    //Scenario 2
    @Given("Tengo la informacion incompleta")
    public void tengoLaInformacionIncompleta() {
        requestBody = "{\n" +
                "    \"job\": \"leader\"\n" +
                "}";
    }
    @When("la envio en una peticion con la informacion incompleta")
    public void laEnvioEnUnaPeticionConLaInformacionIncompleta() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("https://reqres.in/api/users");
    }
    @Then("debo obtener una respuesta de error")
    public void deboObtenerUnaRespuestaDeError() {
        response.then().statusCode(400);
    }

    //Scenario 3
    @Given("Tengo la informacion sin trabajo")
    public void tengoLaInformacionSinTrabajo() {
        requestBody = "{\n" +
                "    \"name\": \"morpheus\"\n" +
                "}";
    }
    @When("la envio en una peticion sin trabajo")
    public void laEnvioEnUnaPeticionSinTrabajo() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("https://reqres.in/api/users");
    }
    @Then("debo obtener un error")
    public void deboObtenerUnError() {
        response.then().statusCode(400);
    }
}

 */
