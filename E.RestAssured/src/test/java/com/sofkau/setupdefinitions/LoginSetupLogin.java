package com.sofkau.setupdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class LoginSetupLogin {
    private String requestBody;
    private Response response;
    /*1 Escenario
         */
    @Given("que realizo una solicitud para loguearme")
    public void queRealizoUnaSolicitudParaLoguearme() {
        requestBody = "{{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}}";
    }
    @When("envio la solicitud para loguearme")
    public void envioLaSolicitudParaLoguearme() {
        response = RestAssured.given().
                contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://reqres.in/api/register");
    }
    @Then("debera mostrar un tocken")
    public void deberaMostrarUnTocken() {
        System.out.println(response.asString());
    }

    //Escenario
    @Given("que ingreso una solicitud para loguearme")
    public void queIngresoUnaSolicitudParaLoguearme() {
        requestBody = "{{\n" +
                "    \"email\": \"eve.holtreqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}}";
    }
    @When("envio solicitud para loguearme con email invalido")
    public void envioSolicitudParaLoguearmeConEmailInvalido() {
        response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://reqres.in/api/register");

    }
    @Then("debera mostrar un mensaje de error de usuario no encontrado")
    public void deberaMostrarUnMensajeDeErrorDeUsuarioNoEncontrado() {

        try {
            response.then()
                    .log().all()
                    .statusCode(400)
                    .body("error", notNullValue());

        }catch (AssertionError e){
            Assertions.fail();
        }
    }
    //Escenario 3
    @Given("que ingreso una solicitud para loguearme sin proporcionar mi password")
    public void queIngresoUnaSolicitudParaLoguearmeSinProporcionarMiPassword() {
        requestBody = "{{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"\"\n" +
                "}}";
    }
    @When("envio la solicitud para loguearme sin password")
    public void envioLaSolicitudParaLoguearmeSinPassword() {
        response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://reqres.in/api/register");
    }
    @Then("mostrara un mensaje de error indicando que password es requerida")
    public void mostraraUnMensajeDeErrorIndicandoQuePasswordEsRequerida() {

        try {
            response.then()
                    .log().all()
                    .statusCode(400)
                    .body("error", notNullValue());

        }catch (AssertionError e){
            Assertions.fail();
        }
    }
}
