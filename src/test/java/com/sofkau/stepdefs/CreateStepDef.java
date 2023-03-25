package com.sofkau.stepdefs;

import com.sofkau.setup.REQRESCon;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sofkau.setup.SetUpConsts.USER;

public class CreateStepDef extends REQRESCon {
    private final Logger log = LoggerFactory.getLogger(CreateStepDef.class);

    @Given("I performed a GET request to Users page of REQRES")
    public void iPerformedAGETRequestToUsersPageOfREQRES() {
        try {
            getToUsers();
            log.info("Going Users");
        } catch (Exception e) {
            log.error("Wrong URL");
            Assertions.fail();
        }
    }

    @And("I changed the request method to POST")
    public void iChangedTheRequestMethodToPOST() {
        try {
            log.info("Changing method");
        } catch (Exception e) {
            log.error("ERROR");
            Assertions.fail();
        }
    }

    @When("I add a valid JSON body")
    public void iAddAValidJSONBody() {
        try {
            log.info("Doing post");
        } catch (Exception e) {
            log.error("ERROR");
            Assertions.fail();
        }
    }

    @And("I use a {string} and {string} in it")
    public void iUseANameAndJobInIt(String name, String job) {
        try {
            whenPost(String.format(USER, name, job));
            log.info("Doing post");
        } catch (Exception e) {
            log.error("ERROR");
            Assertions.fail();
        }
    }

    @Then("I will get a creation ID for {string} the {string}")
    public void iWillGetACreationIDForNameTheJob(String name, String job) {
        try {
            validateId(String.format(USER, name, job));
            log.info("Assert ID");
        } catch (Exception e) {
            log.error("ERROR");
            Assertions.fail();
        } finally {
            log.info("Test completed");
        }
    }

    @When("I add an invalid JSON body")
    public void iAddAnInvalidJSONBody() {
        try {
            whenPost("{,}");
            log.info("Doing post");
        } catch (Exception e) {
            log.error("ERROR");
            Assertions.fail();
        }
    }

    @Then("I will get a Bad Request status")
    public void iWillGetABadRequestStatus() {
        try {
            validateECode("{,}", 400);
            log.info("Assert code");
        } catch (Exception e) {
            log.error("ERROR");
            Assertions.fail();
        } finally {
            log.info("Test completed");
        }
    }
}