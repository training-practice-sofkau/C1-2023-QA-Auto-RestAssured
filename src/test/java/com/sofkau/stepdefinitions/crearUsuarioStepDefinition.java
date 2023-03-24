package com.sofkau.stepdefinitions;

import com.sofkau.setup.crearUsuarioSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;


import static io.restassured.RestAssured.given;

public class crearUsuarioStepDefinition extends crearUsuarioSetup {

    public static Logger LOGGER = Logger.getLogger(crearUsuarioStepDefinition.class);
    private RequestSpecification request;
    private Response response;

    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

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
        response = request.given().post(CREATE_RESOURCE);
    }

    @Then("el sistema debera mostrarme usuario creado")
    public void elSistemaDeberaMostrarmeUsuarioCreado() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            System.out.println(responseBody.toJSONString());
            Assertions.assertEquals(response.getStatusCode(), 200);

        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }

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
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            System.out.println(responseBody.toJSONString());
            Assertions.assertEquals(response.getStatusCode(), 200);

        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
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
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            System.out.println(responseBody.toJSONString());
            Assertions.assertEquals(response.getStatusCode(), 200);

        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }
    }


}




