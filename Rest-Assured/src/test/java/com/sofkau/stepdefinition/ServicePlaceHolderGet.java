package com.sofkau.stepdefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
public class ServicePlaceHolderGet {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(ServicePlaceHolderGet.class));
    @Given("el administrador esta en la pagina")
    public void elAdministradorEstaEnLaPagina() {
    }
    @When("hace la peticion al servicio")
    public void haceLaPeticionAlServicio() {
    }
    @When("le agrega un path con una palabra")
    public void leAgregaUnPathConUnaPalabra() {
    }
    @Then("recibe un error de not found")
    public void recibeUnErrorDeNotFound() {
    }
    @Then("recibe un json con la lista de usuarios")
    public void recibeUnJsonConLaListaDeUsuarios() {
    }
}
