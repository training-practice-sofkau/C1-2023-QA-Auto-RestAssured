package com.sofkau.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import com.sofkau.setup.UsuarioUnicoSetup;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;


public class UsuarioUnicoStepDefinition extends UsuarioUnicoSetup {
    public static final Logger LOGER = Logger.getLogger(UsuarioUnicoStepDefinition.class);
    private Response response;
    private RequestSpecification resquest;



    @Given("me encuentro en la pagina")
    public void meEncuentroEnLaPagina() {
        generalSetup();

    }

    @When("realizo la peticion de consulta")
    public void realizoLaPeticionDeConsulta() {
        response = when().get(LOGIN_RESOURCE);
    }

    @Then("el sistema deberia de mostrarme el usuario")
    public void elSistemaDeberiaDeMostrarmeElUsuario() {
        response.then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(2));
    }

}
