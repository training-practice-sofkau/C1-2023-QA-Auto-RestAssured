package com.sofkau.step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.sql.SQLOutput;

public class PotsTestApi {
    private String requeestBody;
    private Response response;

    @Given("tengo los datos del usuario")
    public void tengo_los_datos_del_usuario() {
       requeestBody ="{\n" +
                       " \"name\" \"morpheus\" \n"+
               "  \"job\" \"leader\" \n" +
               "}";
    }
    @When("envio una peticion una peticion de registro")
    public void envio_una_peticion_una_peticion_de_registro() {
        response = RestAssured.given().contentType(ContentType.JSON).body(requeestBody).
                post("https://reqres.in/api/users");
    }
    @Then("debo obtener un mensaje de registro")
    public void debo_obtener_un_mensaje_de_registro() {
        System.out.println(response.asString());
    }

}
