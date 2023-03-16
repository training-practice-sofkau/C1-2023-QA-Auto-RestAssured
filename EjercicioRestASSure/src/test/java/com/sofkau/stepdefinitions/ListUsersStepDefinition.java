package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;

public class ListUsersStepDefinition {

    private RequestSpecification req;
    private Response res;
    private String body;


    //  Scenario 1

    @Given("Tengo un endpoint apuntando a la api1")
    public void tengoUnEndpointApuntandoALaApi1() {
        RestAssured.baseURI = "https://reqres.in/api";
    }
    @When("Hago una solicitud GET con la pagina deseada mediante endpoint valido")
    public void hagoUnaSolicitudGETConLaPaginaDeseadaMedianteEndpointValido() {
        res = RestAssured.given().log().all().when().get("users?page=1");
//                .then().log().all().extract().body().asString();
    }
    @Then("Debo recibir una respuesta con codigo de estado exitoso")
    public void deboRecibirUnaRespuestaConCodigoDeEstadoExitoso() {
        res.then().statusCode(200);
    }
    @Then("Debo visualizar un body con los users de la pagina ingresada")
    public void deboVisualizarUnBodyConLosUsersDeLaPaginaIngresada() {
        String body = RestAssured.given().log().all().when().get("users?page=1").then().log().all().extract().body().asString();
        System.out.println(body);
    }


    //Scenario 2
    @Given("Tengo un endpoint apuntando a la api2")
    public void tengoUnEndpointApuntandoALaApi2() {
        RestAssured.baseURI = "https://reqres.in/api";
    }
    @When("Hago una solicitud GET con la pagina inexistente mediante endpoint valido")
    public void hagoUnaSolicitudGETConLaPaginaInexistenteMedianteEndpointValido() {
        res = RestAssured.given().log().all().when().get("users?page=100");
    }
    @Then("Debo recibir una respuesta con un codigo de estado de error")
    public void deboRecibirUnaRespuestaConUnCodigoDeEstadoExitoso() {
        res.then().statusCode(400);
    }
    @Then("Debo visualizar un mensaje indicando la comparacion de lo esperado vs lo obtenido1")
    public void deboVisualizarUnMensajeIndicandoLaComparacionDeLoEsperadoVsLoObtenido1() {
        System.out.println("Finalizo");
    }



    @Given("Tengo un endpoint apuntando a la api3")
    public void tengoUnEndpointApuntandoALaApi3() {
        RestAssured.baseURI = "https://reqres.in/api";
    }
    @When("Hago una solicitud GET mediante endpoint invalido")
    public void hagoUnaSolicitudGETMedianteEndpointInvalido() {
        res = RestAssured.given().log().all().when().get("users?page=100");
    }
    @Then("Debo recibir una respuesta con status code indicando error")
    public void deboRecibirUnaRespuestaConStatusCodeIndicandoError() {
        res.then().statusCode(400);
    }
    @Then("Debo visualizar un mensaje indicando la comparacion de lo esperado vs lo obtenido2")
    public void deboVisualizarUnMensajeIndicandoLaComparacionDeLoEsperadoVsLoObtenido2() {
        System.out.println("Finalizo");
    }

}
