package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.Matchers.equalTo;

public class ServiceStepDefinition {
    private Response response;

    //Scenario 1
    @Given("que el administrador quiere obtener un informacion de un usuario")
    public void queElAdministradorQuiereObtenerUnInformacionDeUnUsuario() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @When("envia una peticion correcta")
    public void enviaUnaPeticionCorrecta() {
        response = RestAssured
                .when()
                    .get("api/users/2");
    }

    @Then("debera recibir informacion del usuario y un codigo de estado {int}")
    public void deberaRecibirInformacionDelUsuarioYUnCodigoDeEstado(Integer statusCode) {
      String responseBody = response.then().log().all().extract().asString();
        Assertions.assertEquals(statusCode,response.getStatusCode());

    }

    //Scenario 2
    @Given("que el administrador quiere conseguir un listado de usuarios")
    public void queElAdministradorQuiereConseguirUnListadoDeUsuarios() {
        RestAssured.baseURI = "https://reqres.in/";

    }
    @When("envia una peticion incorrecta")
    public void enviaUnaPeticionIncorrecta() {
        response = RestAssured
                .when()
                    .get("api/users/#$%");
    }
    @Then("debera recibir un respuesta codigo de estado {int}")
    public void deberaRecibirUnRespuestaCodigoDeEstado(Integer statusCode) {
        String responseBody = response.then().log().all().extract().asString();
        Assertions.assertEquals(statusCode, response.getStatusCode());
    }

}
