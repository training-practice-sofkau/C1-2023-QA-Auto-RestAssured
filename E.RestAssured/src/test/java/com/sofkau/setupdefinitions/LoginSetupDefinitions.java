package com.sofkau.setupdefinitions;

<<<<<<< HEAD
=======
import groovy.util.logging.Log;
>>>>>>> d0d5d078fba388a349b2b92515500ad55b06ae28
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

<<<<<<< HEAD
public class LoginSetupDefinitions {
    private String requestBody;
    private Response response;
=======
import static org.hamcrest.Matchers.notNullValue;

public class LoginSetupDefinitions {
    private String requestBody;
    private Response response;

>>>>>>> d0d5d078fba388a349b2b92515500ad55b06ae28
    @Given("que realizo una solicitud para loguearme")
    public void queRealizoUnaSolicitudParaLoguearme() {
        requestBody = "{{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}}";
    }
<<<<<<< HEAD
    @When("la solicitud es exitosa")
    public void laSolicitudEsExitosa() {
        response = RestAssured.given().
                contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://reqres.in/api/register");


    }
    @Then("debera mostrar un tocken")
    public void deberaMostrarUnTocken() {
        System.out.println(response.asString());
    }
=======
    @When("envio la solicitud para loguearme")
    public void envioLaSolicitudParaLoguearme() {
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

    @When("envio la solicitud para loguarme sin password")
    public void envioLaSolicitudParaLoguarmeSinPassword() {
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

>>>>>>> d0d5d078fba388a349b2b92515500ad55b06ae28
}
