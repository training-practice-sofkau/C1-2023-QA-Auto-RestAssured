package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostStepDefinition {

    private String body;
    private String response;

    @Given("que creo la informacion del usuario")
    public void queCreoLaInformacionDelUsuario() {
        body="{\n"+
                "\"name\":\"morpheus\",\n"+
                "\"job\":\"leader\",\n"+
                "}";
    }
    @When("envio la peticion con la informacion")
    public void envioLaPeticionConLaInformacion() {
        response= String.valueOf(RestAssured.given().
                contentType(ContentType.JSON).
                body(body).
                post("https://reqres.in/api/users"));

    }
    @Then("obtengo una respuesta ok")
    public void obtengoUnaRespuestaOk() {
        System.out.println(response.toString());
    }
}
