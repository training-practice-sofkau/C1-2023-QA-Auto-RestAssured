package com.sofkau.stepdefinition;
import com.sofka.pages.CommonActionOnPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import static com.sofka.setup.ConstantSetup.URLget;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class FormStepDefinition {

    Response response;
    Response response2;
    CommonActionOnPages commonActionOnPages;
    public static Logger LOGGER = Logger.getLogger(FormStepDefinition.class);

    @Given("el usuario esta en la API reqres.in")
    public void elUsuario1EstaEnLaAPIReqresIn() {
        RestAssured.baseURI = URLget;
        RestAssured.basePath = "/users?page=";
        given().contentType(ContentType.JSON);
    }
    @When("elige la peticion get SINGLE USER")
    public void elUsuario1eligeLaPeticionGetSINGLEUSER() {
    }
    @When("el usuario manda peticion get SINGLE USER con un {int}")
    public void elUsuario1MandaPeticionGetSINGLEUSERConUn(Integer int1) {
        response = when().get(String.format(URLget+ int1));
    }
    @Then("debe observar la informacion del usuario200")
    public void elUsuario1debeObservarLaInformacionDelUsuario200() {
    }

    @When("el usuario manda peticion get SINGLE USER sin id")
    public void el_usuario_manda_peticion_get_single_user_sin_id() {
        response2 = when().get(String.format(URLget));
    }
    @Then("recibe estatus {int}")
    public void recibe_estatus(Integer int1) {
        response2.then().assertThat().statusCode(500);
    }

}
