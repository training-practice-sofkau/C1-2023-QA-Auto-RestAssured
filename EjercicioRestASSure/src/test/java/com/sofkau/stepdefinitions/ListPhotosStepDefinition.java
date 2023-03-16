package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ListPhotosStepDefinition {

    private Response res;

    @Given("Tengo un endpoint apuntando a la api de fotos")
    public void tengoUnEndpointApuntandoALaApiDeFotos() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }

    @When("Hago una solicitud GET con el id de la foto que quiero visualizar")
    public void hagoUnaSolicitudGETConElIdDeLaFotoQueQuieroVisualizar() {
        res = RestAssured.given().log().all().when().get("photos/1");
    }

    @Then("Debo obtener una respuesta con codigo de estado exitoso")
    public void deboObtenerUnaRespuestaConCodigoDeEstadoExitoso() {
        res.then().statusCode(200);
    }

    @Then("Debo poder visualizar un body con la informacion de la foto")
    public void deboPoderVisualizarUnBodyConLaInformacionDeLaFoto() {
        String body = res.then().log().all().extract().body().asString();
    }


    @Given("Tengo un endpoint apuntando a la api de fotoss")
    public void tengoUnEndpointApuntandoALaApiDeFotoss() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }

    @When("Hago una solicitud GET con el id de la foto inexistente")
    public void hagoUnaSolicitudGETConElIdDeLaFotoInexistente() {
        res = RestAssured.given().log().all().when().get("photos/-500");
    }

    @Then("Debo recibir una respuesta con un codigo de estado de Not found")
    public void deboRecibirUnaRespuestaConUnCodigoDeEstadoDeNotFound() {
        res.then().statusCode(404);
    }

    @Given("Tengo un endpoint apuntando a la api de fotosss")
    public void tengoUnEndpointApuntandoALaApiDeFotosss() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }
    @When("Hago una solicitud GET con el id de la foto con caracteres especiales")
    public void hagoUnaSolicitudGETConElIdDeLaFotoConCaracteresEspeciales() {
        res = RestAssured.given().log().all().when().get("photos/#");
    }
    @Then("Debo recibir una respuesta con status code indicando un errror")
    public void deboRecibirUnaRespuestaConStatusCodeIndicandoUnErrror() {
        res.then().statusCode(400);
    }
}




