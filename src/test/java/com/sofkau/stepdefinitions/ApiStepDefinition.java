package com.sofkau.stepdefinitions;

import com.sofkau.pages.CommonActionOnPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiStepDefinition extends CommonActionOnPage {
    private Response response;

    @Given("que el administrador quiere obtener informacion de un usuario")
    public void queElAdministradorQuiereObtenerInformacionDeUnUsuario() {
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("https://reqres.in/api/users/2");
    }

    @When("envia una solicitud valida")
    public void enviaUnaSolicitudValida() {

    }

    @Then("debera recibir los datos personales del usuario")
    public void deberaRecibirLosDatosPersonalesDelUsuario() {
        System.out.println("--Body-- \n");
        String responseBody = response.then().log().all().statusCode(200).extract().body().asString();
    }

    @Given("que el administrador quiere tener informacion de un usuario")
    public void queElAdministradorQuiereTenerInformacionDeUnUsuario() {
        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("https://reqre.in/api/user/2");
    }

    @When("envia una solicitud invalida en la ruta")
    public void enviaUnaSolicitudInvalidaEnLaRuta() {

    }

    @Then("debera recibir una respuesta invalida")
    public void deberaRecibirUnaRespuestaInvalida() {
        System.out.println("--Body-- \n");
        String responseBody = response.then().log().all().statusCode(403).extract().body().asString();
    }
}
