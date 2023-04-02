package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;

public class PracticeStepDefinition1 {
    public static org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(PracticeStepDefinition1.class));

    private String response;


    @Given("tengo la informacion del usuario")
    public void tengo_la_informacion_del_usuario() {}
    @When("envio esa informacion en una peticion")
    public void envio_esa_informacion_en_una_peticion() {
        try {
            response = RestAssured
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
        } catch (Exception e) {
            LOGGER.info("Ocurrió un error en la petición: " + e.getMessage());
        }

    }
    @Then("debo obtener una respuesta con un token")
    public void debo_obtener_una_respuesta_con_un_token() {
        try {
            if (response.contains("token")) {
                LOGGER.info("El token es: " + response.substring(response.indexOf("token") + 8, response.length() - 2));
            } else {
                LOGGER.info("No se encontró ningún token en la respuesta.");
            }
        } catch (Exception e) {
            LOGGER.info("Ocurrió un error al obtener el token: " + e.getMessage());
        }

    }


}
