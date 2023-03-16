package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class ServiceStepDefinition {
    private Response response;

    //Scenario 1
    @Given("que el administrador quiere obtener un listado de usuarios")
    public void queElAdministradorQuiereObtenerUnListadoDeUsuarios() {
        response = RestAssured
                .given().contentType(ContentType.JSON)
                    .get("https://reqres.in/api/users?page");

    }

    @When("envia una peticion correcta")
    public void enviaUnaPeticionCorrecta() {

    }

    @Then("debera recibir un listado de usuarios")
    public void deberaRecibirUnListadoDeUsuarios() {
      String responseBody = response.then().log().all().statusCode(200).body("data[1].first_name",equalTo("Janet")).extract().asString();
    }

    //Scenario 2
    @Given("que el administrador quiere conseguir un listado de usuarios")
    public void queElAdministradorQuiereConseguirUnListadoDeUsuarios() {
        response = RestAssured
                .given().contentType(ContentType.JSON)
                .get("https://reqres.in/api/users#$%");

    }
    @When("envia una peticion incorrecta")
    public void enviaUnaPeticionIncorrecta() {

    }
    @Then("debera recibir un respuesta fallida")
    public void deberaRecibirUnRespuestaFallida() {
        String responseBody = response.then().log().all().statusCode(400).extract().asString();
    }

}
