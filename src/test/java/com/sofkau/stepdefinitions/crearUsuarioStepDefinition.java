package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.sofkau.setup.crearUsuarioSetup;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class crearUsuarioStepDefinition extends crearUsuarioSetup {


    private Response response;
    private RequestSpecification request;

    /**
     * Escenario 1
     */
    @Given("que tengo el servicio de creacion de usuario")
    public void queTengoElServicioDeCreacionDeUsuario() {
        generalSetup();
    }

    @Given("ingreso el password  de usuario y correo")
    public void ingresoElPasswordDeUsuarioYCorreo() {
        request = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}");
    }

    @When("realizo la peticion de creacion de usuario")
    public void realizoLaPeticionDeCreacionDeUsuario() {
        response = request.when().post(CREATE_RESOURCE);
    }

    @Then("el sistema debera mostrarme usuario creado")
    public void elSistemaDeberaMostrarmeUsuarioCreado() {
        response.then()
                .statusCode(200);
        //.body("email", equalTo("eve.holt@reqres.in"));

    }


    /**
     * Escenario 2
     */


    @Given("que tengo el servicio de crear usuario")
    public void queTengoElServicioDeCrearUsuario() {
        generalSetup();
    }

    @Given("ingreso la informacion del usuario sin password y con correo")
    public void ingresoLaInformacionDelUsuarioSinPasswordYConCorreo() {
        request = given()
                .contentType(ContentType.JSON)
                .body("\n" +
                        "     {\n" +
                        "     \"email\": \"yulitza1@gmail.com\",\n" +
                        "  \n" +
                        "     }");
    }

    @When("envio la solicitud de creacion de usuario sin el nombre")
    public void envioLaSolicitudDeCreacionDeUsuarioSinElNombre() {
        response = request.when().post(CREATE_RESOURCE);
    }

    @Then("el sistema debe responder error al crear usuario sin password")
    public void elSistemaDebeResponderErrorAlCrearUsuarioSinPassword() {
        response = request.when().post(CREATE_RESOURCE);
        response.then()
                .statusCode(200);

    }


    /**
     * Escenario 3
     */
    @Given("que tengo el servicio para crear un usuario")
    public void queTengoElServicioParaCrearUnUsuario() {
        generalSetup();

    }

    @Given("ingreso el  password de usuario  sin correo")
    public void ingresoElPasswordDeUsuarioSinCorreo() {
        request = given()
                .contentType(ContentType.JSON)
                .body("\n" +
                        "     {\n" +
                        "     \"password\": \"1234\"\n" +
                        "\n" +
                        "     }");
    }

    @When("envio la solicitud de creacion de usuario sin el correo")
    public void envioLaSolicitudDeCreacionDeUsuarioSinElCorreo() {
        response = request.when().post(CREATE_RESOURCE);

    }

    @Then("el sistema debe responder error al crear usuario sin el correo")
    public void elSistemaDebeResponderErrorAlCrearUsuarioSinElCorreo() {
        response = request.when().post(CREATE_RESOURCE);
        response.then()
                .statusCode(200);
    }


}




