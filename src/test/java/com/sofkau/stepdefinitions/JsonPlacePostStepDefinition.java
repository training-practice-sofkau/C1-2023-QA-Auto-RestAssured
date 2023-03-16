package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

public class JsonPlacePostStepDefinition {
    private String url;
    private Response response;
    private int id;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

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
        response.then().statusCode(200);
        JSONArray responseBody;
        try {
            responseBody = (JSONArray) parser.parse(response.getBody().asString());
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
        for (Object obj : responseBody) {
            JSONObject post = (JSONObject) obj;
            int postId = ((Long) post.get("id")).intValue();
            Assertions.assertTrue(postId > 0 && postId <= 100);
        }
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
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.then().statusCode(200);
        Assertions.assertEquals(4,(int) (long) responseBody.get("id"));
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
        response.then().statusCode(404);
    }

}
