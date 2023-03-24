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
import org.apache.log4j.Logger;


public class PostReqresStepDefinition {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(PostReqresStepDefinition.class));
    private String requestBody;
    private Response response;

    @Given("que el usuario esta en la pagina de registro")
    public void queElUsuarioEstaEnLaPaginaDeRegistro() {
        requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        RestAssured.baseURI = "https://reqres.in/";
    }
    @When("envia la peticion de registro con un email valido")
    public void enviaLaPeticionDeRegistroConUnEmailValido() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("api/register");
    }
    @Then("debe recibir una respuesta con con un id, un token y un codigo de status {int}")
    public void debeRecibirUnaRespuestaConConUnIdUnTokenYUnCodigoDeStatus(Integer statusCode) {
        String responseBody = response.then().log().all().extract().asString();
        Assertions.assertEquals(statusCode,response.getStatusCode());

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(responseBody);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String token = (String) jsonObject.get("token");
        Assertions.assertEquals("QpwL5tke4Pnpja7X4", token);

    }

    //Scenario 2
    @When("envia la peticion de registro con un email invalido")
    public void enviaLaPeticionDeRegistroConUnEmailInvalido() {

    }
    @Then("debe recibir una respuesta con mensaje de error y  un codigo de status {int}")
    public void debeRecibirUnaRespuestaConMensajeDeErrorYUnCodigoDeStatus(Integer statusCode) {

    }


}
