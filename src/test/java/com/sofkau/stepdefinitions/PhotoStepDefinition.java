package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PhotoStepDefinition {


    private Response response;
    private RequestSpecification request;


    @Given("que me encuentro en la servicio de Reqres")
    public void queMeEncuentroEnLaServicioDeReqres() {

    }

    @When("realizo una peticion para obtener las fotos del usuario con id valido")
    public void realizoUnaPeticionParaObtenerLasFotosDelUsuarioConIdValido() {

    }

    @Then("el sistema debe mostrarme las fotos del usuario")
    public void elSistemaDebeMostrarmeLasFotosDelUsuario() {

    }


    @Given("que tengo el servicio de Reqres")
    public void queTengoElServicioDeReqres() {

    }

    @When("realizo una peticion para obtener las fotos del usuario con id invalido")
    public void realizoUnaPeticionParaObtenerLasFotosDelUsuarioConIdInvalido() {

    }

    @Then("el sistema debe mostrarme un mensaje de usuario invalido")
    public void elSistemaDebeMostrarmeUnMensajeDeUsuarioInvalido() {

    }

}
