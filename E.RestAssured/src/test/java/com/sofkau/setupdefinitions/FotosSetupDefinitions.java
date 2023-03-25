package com.sofkau.setupdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

public class FotosSetupDefinitions {
    private Response response;
    private String url;
    private String path;
    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;
    @Given("que realizo estoy en la API de fotos")
    public void queRealizoEstoyEnLaAPIDeFotos() {
        url = "https://jsonplaceholder.typicode.com/";
    }
    @When("envio la solicitud para mirar fotos  por {int}")
    public void envioLaSolicitudParaMirarFotosPor(Integer id) {
        path = "photos/";
        response = RestAssured.get(url+path+id);
    }


    @Then("debera mostrar la lista de fotos con el title {string}")
    public void deberaMostrarLaListaDeFotosConElTitle(String title) {

        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            response.then().statusCode(200);
            Assertions.assertEquals(title,responseBody.get("title"));

        }catch (AssertionError e){
            Assertions.fail();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }



}
