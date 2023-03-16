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

public class CommentsApiStepDefinitions {

    private String url;
    private Response response;
    private int id;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

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
            Assertions.assertTrue(postId > 15 && postId <= 20);
        }
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
        response.then().statusCode(400);
    }
}
