package com.sofkau.stepdefs;

import com.sofkau.setup.JSONPlaceholderCon;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sofkau.setup.SetUpConsts.RESOURCE;

public class CreateResourceStepDef extends JSONPlaceholderCon {
    private final Logger log = LoggerFactory.getLogger(CreateResourceStepDef.class);

    @Given("I have access to JSONPlaceholder server")
    public void iHaveAccessToJSONPlaceholderServer() {
        try {
            getToHomePage();
            log.info("Going home");
        } catch (Exception e) {
            log.error("Wrong URL");
            Assertions.fail();
        }
    }

    @When("I create a valid resource via a Post request")
    public void iCreateAValidResourceViaAPostRequest() {
        try {
            whenPost(RESOURCE);
            log.info("Creating resource");
        } catch (Exception e) {
            log.error("Wrong URL");
            Assertions.fail();
        }
    }

    @Then("I will get a JSON object with the same title")
    public void iWillGetAJSONObjectWithTheSameTitle() {
        try {
            validateTitle(RESOURCE, "title");
            log.info("Assert title");
        } catch (Exception e) {
            log.error("ERROR");
            Assertions.fail();
        } finally {
            log.info("Test completed");
        }
    }
}