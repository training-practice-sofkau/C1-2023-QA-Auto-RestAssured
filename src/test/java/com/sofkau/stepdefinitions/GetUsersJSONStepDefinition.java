package com.sofkau.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetUsersJSONStepDefinition {

    private Response response;

    /**
     * Scenario 1
     */
    @Given("que estoy en la pagina web de jsonplaceholder")
    public void queEstoyEnLaPaginaWebDeJsonplaceholder() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";

    }
    @When("solicito la lista de usuarios")
    public void solicitoLaListaDeUsuarios() {
        response= given()
                 .log()
                 .all()
                 .when()
                 .get("/users");

    }
    @Then("recibo una respuesta que debe contener todos los usuarios")
    public void reciboUnaRespuestaQueDebeContenerTodosLosUsuarios() {
        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("$", hasSize(10));

    }

    /**
     * Scenario 2
     */
    @Given("que estoy en la pagina web")
    public void queEstoyEnLaPaginaWeb() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";

    }
    @When("solicito una la lista limitada de usuarios")
    public void solicitoUnaLaListaLimitadaDeUsuarios() {
        response = given()
                .log()
                .all()
                .param("_limit", 5)
                .when().get("/users");


    }
    @Then("recibo una respuesta que debe contener {int} usuarios")
    public void reciboUnaRespuestaQueDebeContenerUsuarios(Integer int1) {
        response.then()
                .log()
                .all()
                .statusCode(200)
                .body("size()", equalTo(5));

    }

}
