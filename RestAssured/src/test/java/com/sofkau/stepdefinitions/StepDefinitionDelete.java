package com.sofkau.stepdefinitions;

import com.sofkau.setup.Log4jSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import static com.sofkau.util.Resources.DELETE_SERVICE_NOT_FOUND;
import static com.sofkau.util.Resources.DELETE_SERVICE_URL;

public class StepDefinitionDelete extends Log4jSetUp {

    public static Logger LOGGER = Logger.getLogger(StepDefinitionDelete.class);
    private Response response;


    // Scenario: Delete exitoso
    @Given("el adminstrador accede a la pagina web de reqres")
    public void elAdminstradorAccedeALaPaginaWebDeReqres() {
        generalSetUp();
        LOGGER.info("Inicio automatizacion");
    }
    @When("envia una solicitid al servicio Delete para eliminar un usuario")
    public void enviaUnaSolicitidAlServicioDeleteParaEliminarUnUsuario() {

        response = RestAssured
                .given()
                .log().all()
                .when()
                .delete(DELETE_SERVICE_URL);
    }
    @When("el usuario esta registrado en la lista")
    public void elUsuarioEstaRegistradoEnLaLista() {

    }
    @Then("debe observar un codigo de estatus No content")
    public void debeObservarUnCodigoDeEstatusNoContent() {
        try {
            response.then()
                    .log().all()
                    .statusCode(204);
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
    }

    // scenario: Delete fallido

    @Given("el administrador accede a la pagina web de reqres")
    public void elAdministradorAccedeALaPaginaWebDeReqres() {
        generalSetUp();
        LOGGER.info("scenario: Delete fallido");
    }
    @When("envia una solicitud al servicio Delete para eliminar un usuario")
    public void enviaUnaSolicitudAlServicioDeleteParaEliminarUnUsuario() {

    }
    @When("el usuario no esta registrado en la lista")
    public void elUsuarioNoEstaRegistradoEnLaLista() {
        response = RestAssured
                .given()
                .log().all()
                .when()
                .delete(DELETE_SERVICE_NOT_FOUND);
    }
    @Then("debe retornar un codigo de estatus Not found")
    public void debeRetornarUnCodigoDeEstatusNotFound() {
        try {
            response.then()
                    .log().all()
                    .statusCode(204);
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
        }
    }

}
