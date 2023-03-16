package step.definitions;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;

import java.net.URI;


public class DemoRestAPITest {

    private Scenario scenario;
    private Response response;
    private final String BASE_URL = "https://reqres.in";

    @Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
    }

    @Given("Get Call to {string}")
    public void get_call_to_url(String url) throws Exception {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification req = RestAssured.given();
        response = req.when().get(new URI(url));
        System.out.println("Url no encontrada");
    }

    @Then("Response Code {string} is validated")
    public void response_is_validated(String responseMessage) {
        int responseCode = response.then().extract().statusCode();
        Assert.assertEquals(responseMessage, responseCode+"");
    }



}

