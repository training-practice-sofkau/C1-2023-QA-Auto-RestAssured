package com.sofkau.stepdefinitions;

import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class AlbumStepDefinition {
    private String body;
    private Response response;

    private JsonObject respondeJson;
    @Given("que creo la informacion del album")
    public void queCreoLaInformacionDelAlbum() {
        body="{\n"+
                "   \"userId\":   \"1\",\n"+
                "   \"title\":    \"quidem molestiae enim\"\n"+
                "}";
    }
    @When("envio la peticion con toda la informacion")
    public void envioLaPeticionConTodaLaInformacion() {
        response = RestAssured.given().
                contentType(ContentType.JSON).
                body(body).
                post("https://jsonplaceholder.typicode.com/albums");
    }
    @Then("obtengo una respuesta ok2")
    public void obtengoUnaRespuestaOk2() {
        System.out.println(response.asString());
        System.out.println(body);

        response.then().statusCode(201);
        //Assertions.assertEquals("quidem molestiae enim",response.get);
    }
}
