package com.sofkau.stepdefinitions;

import com.sofkau.setup.Log4jSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import static com.sofkau.util.Resources.DELETE_POST_RESOURCE;

public class StepDefinitionDeletePost extends Log4jSetUp {

    public static Logger LOGGER = Logger.getLogger(StepDefinitionDeletePost.class);
    private Response response;


    @Given("the user is in the json place holder web page")
    public void theUserIsInTheJsonPlaceHolderWebPage() {
        generalSetUp();
        LOGGER.info("Inicio automatizacion");
    }
    @When("the user sends a request to the Delete service")
    public void theUserSendsARequestToTheDeleteService() {
        response = RestAssured
                .given()
                .log().all()
                .delete(DELETE_POST_RESOURCE);
    }
    @Then("the user gets a status code response No Content")
    public void theUserGetsAStatusCodeResponseNoContent() {
        try {
            response.then()
                    .log()
                    .all()
                    .statusCode(204);
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
    }

}
