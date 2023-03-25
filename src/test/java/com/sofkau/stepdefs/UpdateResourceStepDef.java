package com.sofkau.stepdefs;

import com.sofkau.setup.JSONPlaceholderCon;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sofkau.setup.SetUpConsts.RESOURCE;
import static com.sofkau.setup.SetUpConsts.U_RESOURCE;

public class UpdateResourceStepDef extends JSONPlaceholderCon {
    private final Logger log = LoggerFactory.getLogger(UpdateResourceStepDef.class);

    @Given("I have access to JSONPlaceholder the server")
    public void iHaveAccessToJSONPlaceholderTheServer() {
        try {
            getToHomePage();
            log.info("Going home");
        } catch (Exception e) {
            log.error("Wrong URL");
            Assertions.fail();
        }
    }

    @When("I update an existing resource via a Put request")
    public void iUpdateAnExistingResourceViaAPutRequest() {
        try {
            whenPut(U_RESOURCE);
            log.info("Updating resource");
        } catch (Exception e) {
            log.error("Wrong URL");
            Assertions.fail();
        }
    }

    @Then("I will get a JSON object with the new body")
    public void iWillGetAJSONObjectWithTheNewBody() {
        try {
            validateNewTitle(U_RESOURCE, "body");
            log.info("Assert title");
        } catch (Exception e) {
            log.error("ERROR");
            Assertions.fail();
        } finally {
            log.info("Test completed");
        }
    }
}