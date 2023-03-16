package com.sofkau.setupdefinitions;

import groovy.util.logging.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.notNullValue;

public class LoginSetupDefinitions {
    private String requestBody;
    private Response response;

    @Given("que realizo una solicitud para loguearme")
    public void queRealizoUnaSolicitudParaLoguearme() {
        requestBody = "{{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}}";
    }
    @When("la solicitud es exitosa")
    public void laSolicitudEsExitosa() {
        response = RestAssured.given()
               .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://reqres.in/api/register");

    }
    @Then("debera mostrar un tocken")
    public void deberaMostrarUnTocken() {
        response.then()
                .log().all()
                .statusCode(400)
                .body("token", notNullValue());
        //System.out.println(response.asString());

    }
    //Scenario 2
    @Given("que ingreso una solicitud para loguearme")
    public void queIngresoUnaSolicitudParaLoguearme() {
        requestBody = "{{\n" +
                "    \"email\": \"eve.holtreqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}}";
    }
    @When("la solicitud no es exitosa")
    public void laSolicitudNoEsExitosa() {
        response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://reqres.in/api/register");

    }
    @Then("debera mostrar un mensaje de error de usuario no encontrado")
    public void deberaMostrarUnMensajeDeErrorDeUsuarioNoEncontrado() {
        response.then()
                .log().all()
                .statusCode(400)
                .body("error", notNullValue());
        //System.out.println(response.asString());
    }

    //Escenario 3

    @Given("que ingreso una solicitud para loguearme sin sin proporcionar mi password")
    public void queIngresoUnaSolicitudParaLoguearmeSinSinProporcionarMiPassword() {
        requestBody = "{{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"\"\n" +
                "}}";
    }
    @When("la solicitud de login no es exitosa")
    public void laSolicitudDeLoginNoEsExitosa() {
        response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://reqres.in/api/register");
    }
    @Then("mostrara un mensaje de error indicando que password es requerida")
    public void mostraraUnMensajeDeErrorIndicandoQuePasswordEsRequerida() {
        response.then()
                .log().all()
                .statusCode(400)
                .body("error", notNullValue());
        //System.out.println(response.asString());
    }

}
