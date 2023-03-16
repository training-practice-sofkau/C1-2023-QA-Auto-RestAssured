package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PeticionesPlaceHolderPost {

    public String requestCreate;
    public Response responseCreate;


    @Given("que estoy en la pagina PlaceHolder")
    public void queEstoyEnLaPaginaPlaceHolder() {

        RequestSpecification req = RestAssured.given();
        requestCreate = "{\n" +
                "    \"userId\":       \"                     \",\n " +
                "    \"id\":           \"       1              \",\n " +
                "    \"title\" :       \"   Tengo hambre        \", \"\n" +
                "    \"body\":          \"  Aqui va texto        \"\n " +
                "}" ;

    }
    @When("ingreso los datos de registro")
    public void ingresoLosDatosDeRegistro() {

        responseCreate =RestAssured.given().
                contentType(ContentType.JSON).
                body (requestCreate).
                post("https://jsonplaceholder.typicode.com/posts");

    }
    @Then("se crea el registro en la pagina PlaceHolder")
    public void seCreaElRegistroEnLaPaginaPlaceHolder() {
        System.out.println("responseCreate = " + responseCreate.asString());
        responseCreate.then().statusCode(200);

    }
}
