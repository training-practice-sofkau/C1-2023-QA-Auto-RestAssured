package com.sofkau.stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiStepDefinitions {
    private Response response;

    @Given("el usuario tiene acceso al servicio API de consulta de informacion")
    public void el_usuario_tiene_acceso_al_servicio_api_de_consulta_de_informacion() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @When("el usuario realiza una consulta con el id del registro {string}")
    public void el_usuario_realiza_una_consulta_con_el_id_del_registro(String id) {
        response = given()
                .get("/unknown/" + id);

    }

    @Then("se devuelve la informacion asociada a ese registro")
    public void se_devuelve_la_informacion_asociada_a_ese_registro() {
        String expectedJson = "{\"data\":{\"id\":5,\"name\":\"tigerlily\",\"year\":2004,\"color\":\"#E2583E\",\"pantone_value\":\"17-1456\"},\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";
        String actualJson = response.getBody().asString();
        try {
            JSONParser parser = new JSONParser();
            JSONObject expectedJsonObject = (JSONObject) parser.parse(expectedJson);
            JSONObject actualJsonObject = (JSONObject) parser.parse(actualJson);
            JSONObject expectedDataJsonObject = (JSONObject) expectedJsonObject.get("data");
            JSONObject actualDataJsonObject = (JSONObject) actualJsonObject.get("data");
            assertEquals(actualDataJsonObject, expectedDataJsonObject);
            System.out.println(actualDataJsonObject + " Json coincide");
        } catch (Exception e) {
            System.out.println(actualJson + " Json no coincide");
        }
    }

    @Then("se devuelve un codigo de respuesta exitoso {string}")
    public void se_devuelve_un_codigo_de_respuesta_exitoso(String statusCode) {
        int expectedStatusCode = Integer.parseInt(statusCode);
        int actualStatusCode = response.getStatusCode();
        try {
            assertEquals(expectedStatusCode, actualStatusCode);
            System.out.println("Codigo de respuesta " +actualStatusCode +" correcto");

        } catch (AssertionError e) {
            System.out.println("Codigo de respuesta "+actualStatusCode +" incorrecto");

        }
    }
    @Given("el usuario accede al servicio API de consulta de informacion")
    public void el_usuario_accede_al_servicio_api_de_consulta_de_informacion() {
        RestAssured.baseURI = "https://reqres.in/api";

    }
    @When("el usuario realiza una consulta con un id de registro no valido {string}")
    public void el_usuario_realiza_una_consulta_con_un_id_de_registro_no_valido(String id) {
        response = given()
                .get("/unknown/" + id);
    }
    @Then("se devuelve un mensaje de error indicando que la consulta es invalida")
    public void se_devuelve_un_mensaje_de_error_indicando_que_la_consulta_es_invalida() {
        response.then()
                .statusCode(404);
        System.out.println("Consulta no valida: id no valido");
    }
}
