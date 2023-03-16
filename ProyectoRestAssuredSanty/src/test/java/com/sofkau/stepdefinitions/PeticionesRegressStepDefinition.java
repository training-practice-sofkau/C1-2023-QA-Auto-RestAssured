package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import io.restassured.specification.RequestSpecification;
import static com.sofkau.setup.ConstantSetup.URL_BASE_REGRESS;
import static io.restassured.RestAssured.given;

public class PeticionesRegressStepDefinition {
    public String requestCreate;
    public  Response responseCreate;


// PRIMER

    @Given("se encuentra en la seccion de registro de usuarios y los datos de su nombre y trabajo estan vacios")
    public void seEncuentraEnLaSeccionDeRegistroDeUsuariosYLosDatosDeSuNombreYTrabajoEstanVacios() {

        RequestSpecification req = RestAssured.given();
        requestCreate = "{\n" +
                "    \"email\":  \"     \",\n " +
                "    \"password\" :   \"     \"\n" +
                "}" ;

    }
    @When("ingresa los datos de su nombre y trabajo vacios")
    public void ingresaLosDatosDeSuNombreYTrabajoVacios() {

        responseCreate =RestAssured.given().
                contentType(ContentType.JSON).
                body (requestCreate).
                post("https://reqres.in/api/users");

    }
    @Then("se debera ver un mensaje con un codigo HTTP ok con su nombre y trabajo vacios")
    public void seDeberaVerUnMensajeConUnCodigoHTTPOkConSuNombreYTrabajoVacios() {
        System.out.println("responseCreate = " + responseCreate.asString());
        responseCreate.then().statusCode(400);

    }



    // SEGUNDO ESCENARIO


    @Given("se encuentra en la seccion de registro de usuarios y los datos del nombre y trabajo son caracteres especiales")
    public void seEncuentraEnLaSeccionDeRegistroDeUsuariosYLosDatosDelNombreYTrabajoSonCaracteresEspeciales() {
        RequestSpecification req = RestAssured.given();
        requestCreate = "{\n" +
                "    \"name\":  \"Santy23  \",\n " +
                "    \"job\" :   \"Ramirez23     \"\n" +
                "}" ;

    }

    @When("ingresa los datos de su nombre y trabajo con caracteres especiales")
    public void ingresaLosDatosDeSuNombreYTrabajoConCaracteresEspeciales() {

        responseCreate =RestAssured.given().
                contentType(ContentType.JSON).
                body (requestCreate).
                post("https://reqres.in/api/users");

    }
    @Then("se debera ver un mensaje con un codigo HTTP ok con su nombre y trabajo ingresados con caracteres especiales")
    public void seDeberaVerUnMensajeConUnCodigoHTTPOkConSuNombreYTrabajoIngresadosConCaracteresEspeciales() {
        System.out.println("responseCreate = " + responseCreate.asString());
        responseCreate.then().statusCode(201);

    }



    //TERCER SCENARIO

    @Given("se encuentra en la seccion de registro de usuarios")
    public void seEncuentraEnLaSeccionDeRegistroDeUsuarios() {
        RequestSpecification req = RestAssured.given();
        requestCreate = "{\n" +
                "    \"name\":  \" santy\",\n " +
                "    \"job\" :   \"estudiante\"\n" +
                "}" ;
    }
    @When("ingresa los datos de su nombre y trabajo corectamente")
    public void ingresaLosDatosDeSuNombreYTrabajoCorectamente() {
        responseCreate =RestAssured.given().
                contentType(ContentType.JSON).
                body (requestCreate).
                post("https://reqres.in/api/users");



    }
    @Then("se debera ver un mensaje con un codigo HTTP ok con su nombre y trabajo ingresados")
    public void seDeberaVerUnMensajeConUnCodigoHTTPOkConSuNombreYTrabajoIngresados() {
        System.out.println("responseCreate = " + responseCreate.asString());
        responseCreate.then().statusCode(201);
    }



    // CUARTO SCENARIO

    @Given("se encuentra en la seccion de registro de usuario y el campo de nombre esta vacio")
    public void seEncuentraEnLaSeccionDeRegistroDeUsuarioYElCampoDeNombreEstaVacio() {
        RequestSpecification req = RestAssured.given();
        requestCreate = "{\n" +
                "    \"name\":  \"          \",\n " +
                "    \"job\" :   \"estudiante\"\n" +
                "}" ;

    }
    @When("ingresa el dato del trabajo y deja el campo del nombre vacio")
    public void ingresaElDatoDelTrabajoYDejaElCampoDelNombreVacio() {
        responseCreate =RestAssured.given().
                contentType(ContentType.JSON).
                body (requestCreate).
                post("https://reqres.in/api/users");

    }
    @Then("se debera ver un mensaje con un codigo HTTP not found")
    public void seDeberaVerUnMensajeConUnCodigoHTTPNotFound() {
        System.out.println("responseCreate = " + responseCreate.asString());
        responseCreate.then().statusCode(400);

    }


}
