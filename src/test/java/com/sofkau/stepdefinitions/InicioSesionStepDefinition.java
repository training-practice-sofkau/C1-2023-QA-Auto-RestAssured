package com.sofkau.stepdefinitions;

import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;
public class InicioSesionStepDefinition extends WebUI {
    private String response;
    @Given("un correo electronico y una contrasena validos.")
    public void un_correo_electronico_y_una_contrasena_validos() {

    }
    @Given("un correo electronico y una contrasena invalidas")
    public void unCorreoElectronicoYUnaContrasenaInvalidas() {

    }

    @When("el usuario envia el formulario de inicio de sesion.")
    public void elUsuarioEnviaElFormularioDeInicioDeSesion() {
        response = RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("token", notNullValue()) // Aserción para verificar que el token no es nulo.
                .extract().asString();
    }
    @Then("el sistema debe responder con un token.")
    public void el_sistema_debe_responder_con_un_token() {

    }
    @Then("el sistema debe responder con un mensaje de error {string}")
    public void elSistemaDebeResponderConUnMensajeDeError(String string) {
    }
}
