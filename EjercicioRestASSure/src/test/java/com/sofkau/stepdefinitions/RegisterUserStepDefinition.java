package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class RegisterUserStepDefinition {

    private Response res;

    //Scenario1
    @Given("Tengo un endpoint apuntando a la apiOne")
    public void tengoUnEndpointApuntandoALaApiOne() {
        RestAssured.baseURI = "https://reqres.in/api";
    }
    @When("Hago una solicitud POST con los datos validos en formato json")
    public void hagoUnaSolicitudPOSTConLosDatosValidosEnFormatoJson() {
        res = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
                .when()
                .post("register");
    }
    @Then("Debo recibir una respuesta con codigo de estado exitoso1")
    public void deboRecibirUnaRespuestaConCodigoDeEstadoExitoso1() {
        res.then().statusCode(200);

    }
    @Then("Debo visualizar un json con el id y token asignado")
     public void deboVisualizarUnJsonConElIdYTokenAsignado() {
        String id = res.jsonPath().getString("id");
        String token = res.jsonPath().getString("token");
        Assert.assertEquals("4", id);
        Assert.assertEquals("QpwL5tke4Pnpja7X4", token);
    }


    //Scenario2
    @Given("Tengo un endpoint apuntando a la apiTwo")
    public void tengoUnEndpointApuntandoALaApiTwo() {
        RestAssured.baseURI = "https://reqres.in/api";
    }
    @When("Hago una solicitud POST con correo invalido en formato json")
    public void hagoUnaSolicitudPOSTConCorreoInvalidoEnFormatoJson() {
        res = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"invalido.com\",\n" +
                        "    \"password\": \"prueba\"\n" +
                        "}")
                .when()
                .post("register");
    }
    @Then("Debo recibir una respuesta con un codigo de estado_de error")
    public void deboRecibirUnaRespuestaConUnCodigoDeEstadoDeError() {
        res.then().statusCode(400);
        String message = res.jsonPath().getString("error");
        Assert.assertEquals("Note: Only defined users succeed registration", message);
    }



    //Scenario3
    @Given("Tengo un endpoint apuntando a la apiThree")
    public void tengoUnEndpointApuntandoALaApiThree() {
        RestAssured.baseURI = "https://reqres.in/api";
    }
    @When("Hago una solicitud POST con los datos vacios")
    public void hagoUnaSolicitudPOSTConLosDatosVacios() {
        res = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{" +
                        "}")
                .when()
                .post("register");
    }
    @Then("Debo recibir una respuesta con status code indicando un error")
    public void deboRecibirUnaRespuestaConStatusCodeIndicandoUnError() {
        res.then().statusCode(400);
        String message = res.jsonPath().getString("error");
        Assert.assertEquals("Missing email or username", message);
    }
}
