package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommentsApiStepDefinitions {
    //Scenario1
    @Given("Tengo la id de un post")
    public void tengoLaIdDeUnPost() {

    }
    @When("envio una peticion con la id del post")
    public void envioUnaPeticionConLaIdDelPost() {

    }
    @Then("debo obtener una respuesta con los comentarios de ese post")
    public void deboObtenerUnaRespuestaConLosComentariosDeEsePost() {

    }

    //Scenario 2

    @Given("Tengo la id de un post inexistente")
    public void tengoLaIdDeUnPostInexistente() {

    }
    @When("envio una peticion con la id del post inexistente")
    public void envioUnaPeticionConLaIdDelPostInexistente() {

    }
    @Then("debo obtener un error debido al post inexistente")
    public void deboObtenerUnErrorDebidoAlPostInexistente() {

    }
}
