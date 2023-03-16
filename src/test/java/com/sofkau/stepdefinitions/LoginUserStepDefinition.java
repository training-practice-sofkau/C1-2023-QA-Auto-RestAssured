package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginUserStepDefinition {

    private String requestBody;
    private Response response;

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
        System.out.println(response.asString());
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
        System.out.println(response.asString());
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
        System.out.println(response.asString());
    }
}
