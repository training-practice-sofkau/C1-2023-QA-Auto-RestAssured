package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class postStepDefinition {

    private Response response;

    private String credencial;

    /**
     * Scenario 1
     */
    @Given("que tiene las credendiales para registrarse")
    public void queTieneLasCredendialesParaRegistrarse() {
        credencial ="{\n" +
                        " \"email\": \"eve.holt@reqres.in\", \n" +
                        " \"password\": \"pistol\" \n" +
                        "}";

    }
    @When("realiza una solicitud de registro con los datos anteriores")
    public void realizaUnaSolicitudDeRegistroConLosDatosAnteriores() {
        response = given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(credencial)
                .post("https://reqres.in/api/register");

    }
    @Then("la solicitud debe ser exitosa devolviendo un token de acceso")
    public void laSolicitudDebeSerExitosaDevolviendoUnTokenDeAcceso() {
        response.then()
                .log()
                .all()
                .extract()
                .asString();

    }

    /**
     * Scenario 2
     */

    @Given("que utilizo un correo para hacer un registro")
    public void queUtilizoUnCorreoParaHacerUnRegistro() {
        credencial = "{\n" +
                     " \"email\": \"eve.holt@reqres.in\", \n" +
                     " \"password\": \"\" \n" +
                     "}";
    }
    @When("realizo una solicitud de registro con correo pero sin contrasena")
    public void realizoUnaSolicitudDeRegistroConCorreoPeroSinContrasena() {
         response = given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            " \"email\": \"eve.holt@reqres.in\", \n" +
                            " \"password\": \"\" \n" +
                            "}")
                    .post("https://reqres.in/api/register");

    }
    @Then("la solicitud no debe devolver token")
    public void laSolicitudNoDebeDevolverToken() {
        response.then();

    }
    @Then("debe mostrar un mensaje de error indicando que falta la contrasena")
    public void debeMostrarUnMensajeDeErrorIndicandoQueFaltaLaContrasena() {
        response.then()
                .body("error", equalTo("Missing password"))
                .log()
                .all()
                .extract()
                .asString();

    }
}
