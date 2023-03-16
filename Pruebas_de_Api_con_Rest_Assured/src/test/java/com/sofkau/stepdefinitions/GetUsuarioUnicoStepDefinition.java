package com.sofkau.stepdefinitions;

import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class GetUsuarioUnicoStepDefinition extends WebUI {
    private String response;

    @Given("un ID de usuario valido.")
    public void unIDDeUsuarioValido() {

    }

    @When("el usuario realiza una solicitud GET para obtener informacion del usuario.")
    public void elUsuarioRealizaUnaSolicitudGETParaObtenerInformacionDelUsuario() {
        response = RestAssured
                .given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .extract().asString();

    }
    @Then("el sistema debe responder con los detalles del usuario solicitado.")
    public void el_sistema_debe_responder_con_los_detalles_del_usuario_solicitado() {

    }


}
