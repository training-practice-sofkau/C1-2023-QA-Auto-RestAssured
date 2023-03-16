package com.sofkau.stepdefinitions;

import com.sofkau.services.GetSingleUserService;
import com.sofkau.setup.Log4jSetUp;
import com.sofkau.util.Log4j;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class StepDefinitionGetSingleUser extends Log4jSetUp {

    public static Logger LOGGER = Logger.getLogger(StepDefinitionDelete.class);

    @When("envia una solicitud al servicio Get single user")
    public void enviaUnaSolicitudAlServicioGetSingleUser() {

    }
    @When("el usuario esta registradeo en la lista")
    public void elUsuarioEstaRegistradeoEnLaLista() {

    }
    @Then("retorna un codigo de estatus ok")
    public void retornaUnCodigoDeEstatusOk() {

    }
    @Then("lista la informacion de un usuario determinado")
    public void listaLaInformacionDeUnUsuarioDeterminado() {
        GetSingleUserService getSingleUserService = new GetSingleUserService();
        getSingleUserService.assertSingleUser();
    }

    // scenario usuario no encontrado

    @When("envia solicitud al servicio Get single user")
    public void enviaSolicitudAlServicioGetSingleUser() {

    }
    @When("el usuario seleccionado no esta registrado en la lista")
    public void elUsuarioSeleccionadoNoEstaRegistradoEnLaLista() {

    }
    @Then("debe retornar un codigo estatus Not found")
    public void debeRetornarUnCodigoEstatusNotFound() {

    }


}
