package com.sofkau.stepdefinitions;

import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.Json;
import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import jdk.nashorn.internal.parser.JSONParser;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class PostStepDefinition {

    private String body;
    private Response response;

    //Primer scenario
    @Given("que creo la informacion del usuario")
    public void queCreoLaInformacionDelUsuario() {
        body="{\n"+
                "   \"name\":   \"morpheus\",\n"+
                "   \"job\":    \"leader\"\n"+
                "}";
    }
    @When("envio la peticion con la informacion")
    public void envioLaPeticionConLaInformacion() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(body).
                post("https://reqres.in/api/users");
    }
    @Then("obtengo una respuesta ok")
    public void obtengoUnaRespuestaOk() {
        System.out.println(response.asString());
        System.out.println(body);
        response.then().statusCode(201);

        //JSONParser parser = new JSONParser();
        //JsonObject expectedJsonObject = (JsonObject) parser.parse(expectedJson);
        //JsonObject actualJsonObject = (JsonObject) parser.parse(body);
        //JSONObject expectedDataJsonObject = (JSONObject) expectedJsonObject.get("data");
        //JSONObject actualDataJsonObject = (JSONObject) actualJsonObject.get("data");
        //assertEquals(actualDataJsonObject, expectedDataJsonObject);
    }

    //Segundo scenario
    @Given("que tengo la informacion del usuario1")
    public void queTengoLaInformacionDelUsuario1() {
        body="";
    }
    @When("envio la peticion con la informacion vacia")
    public void envioLaPeticionConLaInformacionVacia() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(body).
                post("https://reqres.in/api/users");
    }
    @Then("obtengo una respuesta invalida")
    public void obtengoUnaRespuestaInvalida() {
        System.out.println(response.asString());
        System.out.println(body);
        response.then().statusCode(400);
    }

    //Tercer scenario
    @Given("que tengo la informacion del usuario2")
    public void queTengoLaInformacionDelUsuario2() {
        body="{\n"+
                "   \"name\":   \"morpheus\"\n"+
                "}";
    }
    @When("envio la peticion solo con la informacion del nombre")
    public void envioLaPeticionSoloConLaInformacionDelNombre() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(body).
                post("https://reqres.in/api/users");
    }
    @Then("obtengo una respuesta invalida1")
    public void obtengoUnaRespuestaInvalida1() {
        System.out.println(response.asString());
        System.out.println(body);
        response.then().statusCode(400);
    }
}
