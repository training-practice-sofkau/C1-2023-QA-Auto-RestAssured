package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class PeticionesRegressSuccesFullStepDefinition {
    public String requestCreate;
    public  Response responseCreate;


    @Given("que el usuario se encuentra en la pagina de loggin")
    public void queElUsuarioSeEncuentraEnLaPaginaDeLoggin() {
        RequestSpecification req = RestAssured.given();
        requestCreate = "{\n" +
                "    \"email\":  \"eve.holt@reqres.in\",\n " +
                "    \"password\" :   \" pistol\"\n" +
                "}" ;

    }
    @When("el usuario ingresa su correo y contrasena")
    public void elUsuarioIngresaSuCorreoYContrasena() {
        responseCreate =RestAssured.given().
                contentType(ContentType.JSON).
                body (requestCreate).
                post("https://reqres.in/api/register");

    }
    @Then("el usuario es redirigido a su cuenta")
    public void elUsuarioEsRedirigidoASuCuenta() {
        System.out.println("responseCreate = " + responseCreate.asString());
        responseCreate.then().statusCode(200);

    }




    // SEGUNDO ESCENARIO


    @Given("que el usuario se encuentra en la pagina de loggin e ingresa una contrasena incorrecta")
    public void queElUsuarioSeEncuentraEnLaPaginaDeLogginEIngresaUnaContrasenaIncorrecta() {

        RequestSpecification req = RestAssured.given();
        requestCreate = "{\n" +
                "    \"email\":  \"eve.holt@reqres.in\",\n " +
                "    \"password\" :   \" QuieroAlmorzar\"\n" +
                "}" ;

    }
    @When("el usuario ingresa su correo  correcto y contrasena incorrecta")
    public void elUsuarioIngresaSuCorreoCorrectoYContrasenaIncorrecta() {
        responseCreate =RestAssured.given().
                contentType(ContentType.JSON).
                body (requestCreate).
                post("https://reqres.in/api/register");

    }
    @Then("el usuario es redirigido a la pagina de loggin nuevamente")
    public void elUsuarioEsRedirigidoALaPaginaDeLogginNuevamente() {

        System.out.println("responseCreate = " + responseCreate.asString());
        responseCreate.then().statusCode(400);
    }


    @Given("que el usuario se encuentra en la pagina de loggin y no ingresa la contrasena")
    public void queElUsuarioSeEncuentraEnLaPaginaDeLogginYNoIngresaLaContrasena() {
        RequestSpecification req = RestAssured.given();
        requestCreate = "{\n" +
                "    \"email\":  \"eve.holt@reqres.in\",\n " +
                "    \"password\" :   \"   \"\n" +
                "}" ;

    }
    @When("el usuario ingresa su correo  correcto y no ingresa la contrasena")
    public void elUsuarioIngresaSuCorreoCorrectoYNoIngresaLaContrasena() {
        responseCreate =RestAssured.given().
                contentType(ContentType.JSON).
                body (requestCreate).
                post("https://reqres.in/api/register");
    }
    @Then("el usuario es redirigido a la pagina de loggin nuevamente para que ponga contrasena")
    public void elUsuarioEsRedirigidoALaPaginaDeLogginNuevamenteParaQuePongaContrasena() {
        System.out.println("responseCreate = " + responseCreate.asString());
        responseCreate.then().statusCode(400);
    }

}
