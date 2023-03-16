package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonPlacePostStepDefinition {
    private String url;
    private Response response;
    private int id;

    //Scenario 1
    @Given("se donde encontrar los posts")
    public void seDondeEncontrarLosPosts() {
        url = "https://jsonplaceholder.typicode.com/posts";
    }
    @When("envio una solicitud para obtenerlos")
    public void envioUnaSolicitudParaObtenerlos() {
        response = RestAssured.get(url);
    }
    @Then("debo obtener una respuesta positiva con los posts disponibles")
    public void deboObtenerUnaRespuestaPositivaConLosPostsDisponibles() {
        System.out.println(response.asString());
    }

    //Scenario 2
    @Given("se el numero de id del post")
    public void seElNumeroDeIdDelPost() {
        id = 4;
        url = "https://jsonplaceholder.typicode.com/posts";
    }
    @When("envio una solicitud con el numero del post")
    public void envioUnaSolicitudConElNumeroDelPost() {
        response = RestAssured.get(url+"/{id}", id);
    }
    @Then("debo obtener el post que solicite")
    public void deboObtenerElPostQueSolicite() {
        System.out.println(response.asString());
    }

    //Scenario 3

    @Given("Tengo un id de una post incorrecto")
    public void tengoUnIdDeUnaPostIncorrecto() {
        id = 126;
        url = "https://jsonplaceholder.typicode.com/posts";
    }
    @When("envio una solicitud con id incorrecto")
    public void envioUnaSolicitudConIdIncorrecto() {
        response = RestAssured.get(url+"/{id}", id);
    }
    @Then("debo obtener un error porque no existe")
    public void deboObtenerUnErrorPorqueNoExiste() {
        System.out.println(response.asString());
    }

}
