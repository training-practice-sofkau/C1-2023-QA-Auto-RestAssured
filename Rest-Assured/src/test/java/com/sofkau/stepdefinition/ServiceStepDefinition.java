package com.sofkau.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class ServiceStepDefinition {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(ServiceStepDefinition.class));
    @Given("el usuario ingresa su nombre")
    public void elUsuarioIngresaSuNombre() {
    }
    @Given("el usuario ingresa su nobre y trabajo")
    public void elUsuarioIngresaSuNobreYTrabajo() {
    }
    @Given("el usuario ingresa su nobre, trabajo y edad")
    public void elUsuarioIngresaSuNobreTrabajoYEdad() {
    }
    @When("hace la peticion al servicio")
    public void haceLaPeticionAlServicio() {
    }
    @When("el sistema no coloca la coma al hacer la peticion")
    public void elSistemaNoColocaLaComaAlHacerLaPeticion() {
    }
    @Then("recibe un json con su informacion registrada")
    public void recibeUnJsonConSuInformacionRegistrada() {
    }
    @Then("recibe un error de bad request")
    public void recibeUnErrorDeBadRequest() {
    }
}
