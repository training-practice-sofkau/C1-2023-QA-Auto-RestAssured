package com.sofkau.setupdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.runner.Request;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

public class ProductosSetupDefinitions {

    private String requestBody;

    private Response response;



    @Given("que realizo una solicitud para verificar la existencia de un producto")
    public void queRealizoUnaSolicitudParaVerificarLaExistenciaDeUnProducto() {
        requestBody ="{}";
    }
    @When("envio la solicitud para verificar la existencia del producto")
    public void envioLaSolicitudParaVerificarLaExistenciaDelProducto() {
        response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .get("https://reqres.in/api/unknown");
    }
    @Then("debera mostrar la lista de productos con el determinado producto")
    public void deberaMostrarLaListaDeProductosConElDeterminadoProducto() {
        response.then()
                .log().all()
                .statusCode(200)
                .body( "data.id", equalTo("20"));
    }


    //Scenario 2:
    @Given("que realizo una solicitud para listar productos")
    public void queRealizoUnaSolicitudParaListarProductos() {
        requestBody ="{}";
    }
    @When("envio la solicitud para listar productos")
    public void envioLaSolicitudParaListarProductos() {
        response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .get("https://reqres.in/api/unknown");
    }
    @Then("debera mostrar la lista de productos")
    public void deberaMostrarLaListaDeProductos() {
        response.then()
                .log().all()
                .statusCode(200)
                .body(notNullValue());

    }


}

