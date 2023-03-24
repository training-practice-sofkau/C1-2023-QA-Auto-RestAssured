package com.sofkau.stepdefinitions;

import com.sofkau.setup.Log4jSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import static com.sofkau.util.Resources.*;

public class StepDefinitionGetSingleUser extends Log4jSetUp {

    public static Logger LOGGER = Logger.getLogger(StepDefinitionDelete.class);
    Response response;
    JSONParser parser = new JSONParser();
    JSONObject responseBody = null;

    //Scenario: Usuario registrado
    @Given("el adminstrador accede a la pagina web de reqres exitosamente")
    public void elAdminstradorAccedeALaPaginaWebDeReqresExitosamente() {
        generalSetUp();
        LOGGER.info("Inicio automatizacion");
    }
    @When("envia una solicitud al servicio Get single user")
    public void enviaUnaSolicitudAlServicioGetSingleUser() {

    }
    @When("el usuario esta registradeo en la lista")
    public void elUsuarioEstaRegistradeoEnLaLista() {
        response = RestAssured
                .given()
                .log().all()
                .get(GET_SINGLE_USER_RESOURCE);
    }
    @Then("retorna un codigo de estatus ok")
    public void retornaUnCodigoDeEstatusOk() {
        try {
            response.then().statusCode(200);
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
    }
    @Then("lista la informacion de un usuario determinado")
    public void listaLaInformacionDeUnUsuarioDeterminado() {
        try {
            responseBody = (JSONObject) parser.parse(response.getBody().asString());
            Assertions.assertNotNull(responseBody.get(EXPECTED_DATA_SINGLE_USER));
            Assertions.assertNotNull(responseBody.get(SUPPORT_SINGLE_USER));
        } catch (ParseException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    // Scenario: Usuario no encontrado

    @When("envia solicitud al servicio Get single user")
    public void enviaSolicitudAlServicioGetSingleUser() {

    }
    @When("el usuario seleccionado no esta registrado en la lista")
    public void elUsuarioSeleccionadoNoEstaRegistradoEnLaLista() {
        response = RestAssured
                .given()
                .log().all()
                .get(GET_SINGLE_USER_NOT_FOUND);
    }
    @Then("debe retornar un codigo estatus Not found")
    public void debeRetornarUnCodigoEstatusNotFound() {
        try {
            response.then().statusCode(404);
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
    }
}
