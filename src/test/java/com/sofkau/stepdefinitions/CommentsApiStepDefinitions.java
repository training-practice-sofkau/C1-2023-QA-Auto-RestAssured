package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CommentsApiStepDefinitions {

    private String url;
    private Response response;
    private int id;

    //Scenario1
    @Given("Tengo la id de un post")
    public void tengoLaIdDeUnPost() {
        id = 4;
        url = "https://jsonplaceholder.typicode.com/comments?postId={id}";
    }
    @When("envio una peticion con la id del post")
    public void envioUnaPeticionConLaIdDelPost() {
        response = RestAssured.get(url, id);
    }
    @Then("debo obtener una respuesta con los comentarios de ese post")
    public void deboObtenerUnaRespuestaConLosComentariosDeEsePost() {
        System.out.println(response.asString());
    }

    //Scenario 2

    @Given("Tengo la id de un post inexistente")
    public void tengoLaIdDeUnPostInexistente() {
        id = 200;
        url = "https://jsonplaceholder.typicode.com/comments?postId={id}";
    }
    @When("envio una peticion con la id del post inexistente")
    public void envioUnaPeticionConLaIdDelPostInexistente() {
        response = RestAssured.get(url, id);
    }
    @Then("debo obtener un error debido al post inexistente")
    public void deboObtenerUnErrorDebidoAlPostInexistente() {
        System.out.println(response.asString());
    }
}
