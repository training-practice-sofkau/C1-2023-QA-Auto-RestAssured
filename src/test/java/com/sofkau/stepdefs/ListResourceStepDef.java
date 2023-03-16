package com.sofkau.stepdefs;

import com.sofkau.setup.REQRESCon;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.sofkau.setup.SetUpConsts.REQRES_URL;

public class ListResourceStepDef extends REQRESCon {

    private static String URL;

    @Given("I performed a GET request to Home page of REQRES")
    public void iPerformedAGETRequestToHomePageOfREQRES() {
        getToHomePage();
    }

    @When("I add a slug {string} to URL")
    public void iAddASlugUnknownToURL(String slug) {
        URL = String.format(REQRES_URL, slug);
    }

    @And("I perform the request again")
    public void iPerformTheRequestAgain() {
        getToList(URL);
    }

    @Then("I will receive a JSON with available resources")
    public void iWillReceiveAJSONWithAvailableResources() {
        validateBody(URL, "ListResourcesSchema.json");
    }

    @Then("I will get an OK status")
    public void iWillGetAnOKStatus() {
        validateCode(URL);
    }
}
