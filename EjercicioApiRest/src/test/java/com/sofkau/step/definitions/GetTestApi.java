package com.sofkau.step.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTestApi {
    private String body;
    private Response response;
    @Given("que realizo una solicitud para obtener una lista")
    public void que_realizo_una_solicitud_para_obtener_una_lista() {
        RestAssured.baseURI="https://reqres.in/api";
    }
    @When("la solicitud es exitosa")
    public void la_solicitud_es_exitosa() {
        response=RestAssured.given().log().all().when().get("users?page=2");
    }
    @Then("debe mostrar como respuesta la lista")
    public void debe_mostrar_como_respuesta() {
        response.then().statusCode(200);
        body= RestAssured.given().log().all().when().get("users?page=2").
                then().log().all().extract().body().asString();
        System.out.println(body);
    }


}

