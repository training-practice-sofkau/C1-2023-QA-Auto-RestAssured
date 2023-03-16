package com.sofkau.stepdefinitions;

import com.sofkau.services.DeleteService;
import com.sofkau.setup.Log4jSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class StepDefinitionDelete extends Log4jSetUp {

    public static Logger LOGGER = Logger.getLogger(StepDefinitionDelete.class);
    @Given("el adminstrador accede a la pagina web de reqres")
    public void elAdminstradorAccedeALaPaginaWebDeReqres() {
        generalSetUp();
        LOGGER.info("Inicio Scenario Delete exitoso");
    }
    @When("envia una solicitid al servicio Delete para eliminar un usuario")
    public void enviaUnaSolicitidAlServicioDeleteParaEliminarUnUsuario() {
        DeleteService deleteService = new DeleteService();
        deleteService.deleteTest();
    }

    @When("el usuario esta registrado en la lista")
    public void elUsuarioEstaRegistradoEnLaLista() {
    }

    @Then("debe observar un codigo de estatus No content")
    public void debeObservarUnCodigoDeEstatusNoContent() {
        DeleteService deleteService = new DeleteService();
        deleteService.assertDeleteTest();
    }

    // Scenario: Delete Fallido
    @Given("el administrador accede a la pagina web de reqres")
    public void elAdministradorAccedeALaPaginaWebDeReqres() {
        generalSetUp();
        LOGGER.info("Inicio Scenario Delete fallido");
    }
    @When("envia una solicitud al servicio Delete para eliminar un usuario")
    public void enviaUnaSolicitudAlServicioDeleteParaEliminarUnUsuario() {
    }
    @When("el usuario no esta registrado en la lista")
    public void elUsuarioNoEstaRegistradoEnLaLista() {
        DeleteService deleteService = new DeleteService();
        deleteService.deleteTestNotFound();
    }
    @Then("debe retornar un codigo de estatus Not found")
    public void debeRetornarUnCodigoDeEstatusNotFound() {
        DeleteService deleteService = new DeleteService();
        deleteService.assertDeleteTest();
    }
}
