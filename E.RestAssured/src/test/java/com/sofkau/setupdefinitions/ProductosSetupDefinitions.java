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

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;

public class ProductosSetupDefinitions {
    private String requestBody;
    private Response response;
    private String urlBase;
    private String path;
    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    @Given("que realizo una solicitud para listar productos")
    public void queRealizoUnaSolicitudParaListarProductos() {
     urlBase = "https://reqres.in/api/";
    }
    @When("envio la solicitud para listar productos")
    public void envioLaSolicitudParaListarProductos() {
        path = "unknown/1";
        response = RestAssured.get(urlBase+path);
    }
    @Then("debera mostrar la lista de productos")
    public void deberaMostrarLaListaDeProductos() {
        try {
            response.then()
                    .log().all()
                    .statusCode(200)
                    .body( "data.id", equalTo(1));

        }catch (AssertionError e){
            Assertions.fail();
        }



    }
    //Escenario 2
    @Given("que realizo una solicitud para verificar la existencia de un producto")
    public void queRealizoUnaSolicitudParaVerificarLaExistenciaDeUnProducto() {
        urlBase = "https://reqres.in/api/";
    }
    @When("envio la solicitud para verificar la existencia del productos por {int}")
    public void envioLaSolicitudParaVerificarLaExistenciaDelProductosPor(Integer id) {
        path = "unknown/";
        response = RestAssured.get(urlBase+path +id);
    }
    @Then("debera mostrar la lista de productos con el producto {int} y status {int}")
    public void deberaMostrarLaListaDeProductosConElProductoYStatus(Integer id, Integer code) throws ParseException {

        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            response.then().statusCode(code);
            Assertions.assertEquals(id, responseBody.get("data.id"));

        }catch (AssertionError e){
            Assertions.fail();
        }
    }
}
