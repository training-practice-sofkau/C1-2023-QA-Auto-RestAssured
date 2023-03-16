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

public class LoginUserStepDefinition {

    private String requestBody;
    private Response response;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    //Scenario 1
    @Given("tengo credenciales para loguearme")
    public void tengoCredencialesParaLoguearme() {
        requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";
    }
    @When("envio las credenciales")
    public void envioLasCredenciales() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("https://reqres.in/api/login");
    }
    @Then("debo obtener un token de inicio de sesion")
    public void deboObtenerUnTokenDeInicioDeSesion() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.then().statusCode(200);
        Assertions.assertEquals("QpwL5tke4Pnpja7X4",responseBody.get("token"));
    }

    //Scenario 2
    @Given("tengo unas credenciales falsas para loguearme")
    public void tengoUnasCredencialesFalsasParaLoguearme() {
        requestBody = "{\n" +
                "    \"email\": \"jose.nunez@mail.co\",\n" +
                "    \"password\": \"301df245\"\n" +
                "}";
    }
    @When("envio las credenciales falsas")
    public void envioLasCredencialesFalsas() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("https://reqres.in/api/login");
    }
    @Then("debo obtener un error al loguearme")
    public void deboObtenerUnErrorAlLoguearme() {
        response.then().statusCode(400);
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("user not found",responseBody.get("error"));
    }

    //Scenario 3
    @Given("no tengo credenciales")
    public void noTengoCredenciales() {
        requestBody = "{\n" +
                "    \"email\": \"\",\n" +
                "    \"password\": \"\"\n" +
                "}";
    }
    @When("envio una peticion vacia")
    public void envioUnaPeticionVacia() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(requestBody).
                post("https://reqres.in/api/login");
    }

    @Then("debo obtener un error logueandome")
    public void deboObtenerUnErrorLogueandome() {
        response.then().statusCode(400);
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("Missing email or username",responseBody.get("error"));
    }
}
