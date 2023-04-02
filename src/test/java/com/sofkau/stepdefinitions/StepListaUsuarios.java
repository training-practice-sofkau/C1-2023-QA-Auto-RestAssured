package com.sofkau.stepdefinitions;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.junit.jupiter.api.Assertions;



public class StepListaUsuarios {

    private String url;

    private Response response;

    //Scenario 1
    @Given("que tengo acceso al servicio de Reqres")
    public void tengoAccesoAlServicioDeReqres() {
        url = "https://reqres.in";
    }

    @When("solicito la lista de usuarios")
    public void solicitoLaListaDeUsuarios() {
        response = RestAssured.given().get(url + "/api/users");
    }

    @Then("obtengo una respuesta exitosa con una lista de usuarios")
    public void obtengoUnaRespuestaExitosaConUnaListaDeUsuarios() {
        response.then().statusCode(200);
        Gson gson = new Gson();
        JsonArray responses = new JsonArray();
        JsonElement element;
        JsonArray jsonArray;
        JsonObject jsonObject;
        element = gson.fromJson(response.getBody().asString(), JsonElement.class);
        if (element.isJsonArray()) {
            jsonArray = element.getAsJsonArray();
            for (JsonElement jsonElement : jsonArray) {
                jsonObject = jsonElement.getAsJsonObject();
                responses.add(jsonObject);
            }
        }

    }

    //Scenario 2
    @When("solicito la lista de usuarios con un parametro invalido")
    public void solicitoLaListaDeUsuariosConUnParametroInvalido() {
        response = RestAssured.given().get(url + "/api/users?page=invalid");
    }

    @Then("obtengo una respuesta de error")
    public void obtengoUnaRespuestaDeError() {
        response.then().statusCode(400);
    }


}


