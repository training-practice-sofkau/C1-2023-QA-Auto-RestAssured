package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class CreateUsers {
    private Response response;

    @Given("la URL base es {string}")
    public void laURLBaseEs(String url) {
        RestAssured.baseURI = url;
    }

    @When("se crea un usuario con nombre {string} y trabajo {string}")
    public void seCreaUnUsuarioConNombreYTrabajo(String nombre, String trabajo) {
        String jsonBody = "{\"name\":\"" + nombre + "\",\"job\":\"" + trabajo + "\"}";
        response = RestAssured.given().contentType(ContentType.JSON).body(jsonBody).post("/api/users");
    }

    @When("se crea un usuario con nombre vacio y trabajo {string}")
    public void seCreaUnUsuarioConNombreVacioYTrabajo(String string) {
    }

    @Then("se recibe una respuesta con codigo de estado {int}")
    public void seRecibeUnaRespuestaConCodigoDeEstado(int codigo) {
        Assert.assertEquals(codigo, response.getStatusCode());
    }
}



