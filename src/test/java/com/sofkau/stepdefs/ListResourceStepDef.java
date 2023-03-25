package com.sofkau.stepdefs;

import com.sofkau.setup.REQRESCon;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sofkau.setup.SetUpConsts.REQRES_URL;

public class ListResourceStepDef extends REQRESCon {
    private final Logger log = LoggerFactory.getLogger(ListResourceStepDef.class);

    private static String URL;

    @Given("I performed a GET request to Home page of REQRES")
    public void iPerformedAGETRequestToHomePageOfREQRES() {
        try {
            getToHomePage();
            log.info("Going Home");
        } catch (Exception e) {
            log.error("Wrong URL");
            Assertions.fail();
        }
    }

    @When("I add a slug {string} to URL")
    public void iAddASlugUnknownToURL(String slug) {
        try {
            URL = String.format(REQRES_URL, slug);
            log.info("Adding slug");
        } catch (Exception e) {
            log.error("Wrong slug");
            Assertions.fail();
        }
    }

    @And("I perform the request again")
    public void iPerformTheRequestAgain() {
        try {
            whenGet(URL);
            log.info("Petition");
        } catch (Exception e) {
            log.error("Wrong petition");
            Assertions.fail();
        }
    }

    @Then("I will receive a JSON with available resources")
    public void iWillReceiveAJSONWithAvailableResources() {
        try {
            validateBody(URL, "data.id");
            log.info("Asserts object");
        } catch (Exception e) {
            log.error("No object");
            Assertions.fail();
        } finally {
            log.info("Test completed");
        }
    }

    @Then("I will get an OK status")
    public void iWillGetAnOKStatus() {
        try {
            validateCode(URL, 200);
            log.info("Asserts code");
        } catch (Exception e) {
            log.error("Wrong code");
            Assertions.fail();
        } finally {
            log.info("Test completed");
        }
    }
}