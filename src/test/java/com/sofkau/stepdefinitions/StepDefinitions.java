package com.sofkau.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
public class StepDefinitions {
    private String endpoint;
    private String query;
    private Response response;

    @Given("que el usuario tiene el endpoint {string}")
    public void que_el_usuario_tiene_el_endpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @When("el usuario hace una solicitud GET con la consulta {string}")
    public void el_usuario_hace_una_solicitud_GET_con_la_consulta(String query) {
        this.query = query;
        this.response = RestAssured.given()
                .baseUri(endpoint)
                .queryParam("page", query)
                .get();
    }

    @Then("el codigo de respuesta es {int}")
    public void el_codigo_de_respuesta_es(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("la respuesta contiene {int} usuarios")
    public void la_respuesta_contiene_usuarios(int numUsers) throws Exception {
        String responseBody = response.getBody().asString();
        JSONParser parser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) parser.parse(responseBody);
        JSONArray users = (JSONArray) jsonResponse.get("data");
        Assert.assertEquals(numUsers, users.size());
    }

    @Then("el segundo usuario tiene el email {string}")
    public void el_segundo_usuario_tiene_el_email(String expectedEmail) throws Exception {
        String responseBody = response.getBody().asString();
        JSONParser parser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) parser.parse(responseBody);
        JSONArray users = (JSONArray) jsonResponse.get("data");
        JSONObject secondUser = (JSONObject) users.get(1);
        String actualEmail = (String) secondUser.get("email");
        Assert.assertEquals(expectedEmail, actualEmail);
    }

    @Then("la respuesta contiene el mensaje {string}")
    public void la_respuesta_contiene_el_mensaje(String expectedMessage) throws Exception {
        String responseBody = response.getBody().asString();
        JSONParser parser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) parser.parse(responseBody);
        String actualMessage = (String) jsonResponse.get("error");
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}

