package step.definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIReqresDeleteTest {

    private RequestSpecification request;
    private Response response;
    private int id;

    @Given("el administrador esta en la pagina principal")
    public void el_administrador_esta_en_la_pagina_principal() {
        RestAssured.baseURI = "https://reqres.in/api";
        request = RestAssured.given();
    }

    @When("envia una solicitud DELETE")
    public void envia_una_solicitud_DELETE() {
        id = 2; // Establecer un ID válido y existente aquí
        response = request.delete("/users/" + id);
    }

    @Then("se elimina el usuario")
    public void se_elimina_el_usuario() {
        assertEquals(204, response.getStatusCode());
    }

    @Given("que no existe un usuario")
    public void que_no_existe_un_usuario() {
        RestAssured.baseURI = "https://reqres.in/api";
        request = RestAssured.given();
    }

    @When("envio una solicitud DELETE")
    public void envio_una_solicitud_DELETE() {
        id = 9999; // Establecer un ID inexistente aquí
        response = request.delete("/users/" + id);
    }

    @Then("la respuesta tiene un codigo de estado no encontrado")
    public void la_respuesta_tiene_un_codigo_de_estado_no_encontrado() {
        assertEquals(204, response.getStatusCode());
    }

}

