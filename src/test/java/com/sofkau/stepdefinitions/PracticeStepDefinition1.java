package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.logging.Logger;

public class PracticeStepDefinition1 {
    private String response;


    @Given("tengo la informacion del usuario")
    public void tengo_la_informacion_del_usuario() {

    }
    @When("envio esa informacion en una peticion")
    public void envio_esa_informacion_en_una_peticion() {
        response= RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .extract()
                .asString();

    }
    @Then("debo obtener una respuesta con un token")
    public void debo_obtener_una_respuesta_con_un_token() {
        if (response.contains("token")) {
            System.out.println("El token es: " + response.substring(response.indexOf("token") + 8, response.length() - 2));
        } else {
            System.out.println("No se encontró ningún token en la respuesta.");
        }

    }

    ///////////////

    @Given("tengo la informacion incompleta del usuario")
    public void tengo_la_informacion_incompleta_del_usuario() {

    }
    @When("la envio en una peticion")
    public void la_envio_en_una_peticion() {
        response= RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"peter@klaven\"\n" +
                        "}")
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .extract()
                .asString();

    }
    @Then("debo obtener una respuesta de un dato de usuario faltante")
    public void debo_obtener_una_respuesta_de_un_dato_de_usuario_faltante() {
        if (response.contains("Missing password")) {
            System.out.println("La respuesta contiene la cadena 'Missing password'.");
        } else {
            System.out.println("No se encontró la cadena 'Missing password' en la respuesta.");
        }

    }

}
