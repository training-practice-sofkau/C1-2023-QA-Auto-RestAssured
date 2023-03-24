package com.sofkau.setupdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersSetupDefinitions {
    private Response response;
    private String url;
    private String path;
    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;
    @Given("que realizo mirar los usuarios registrados")
    public void queRealizoMirarLosUsuariosRegistrados() {
        url = "https://jsonplaceholder.typicode.com/";

    }
    @When("envio la solicitud para mirar usuarios por {string}")
    public void envioLaSolicitudParaMirarUsuariosPor(String id) {
        path = "users/";
        response = RestAssured.get(url+path+id);
    }

    @Then("debera mostrar la lista de usuarios con nombre {string} username {string}  email {string}")
    public void deberaMostrarLaListaDeUsuariosConNombreUsernameEmail(String nombre, String username, String email) throws ParseException {
        responseBody = (JSONObject) parser.parse(response.getBody().asString());
        response.then().statusCode(200);
        Assertions.assertEquals(nombre, responseBody.get("name"));
        Assertions.assertEquals(username,responseBody.get("username"));
        Assertions.assertEquals(email,responseBody.get("email"));
    }
}
