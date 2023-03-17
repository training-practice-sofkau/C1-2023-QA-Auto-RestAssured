package com.sofkau.stepdefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
public class ServicePostLoginStepDefinition {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(ServicePostLoginStepDefinition.class));
    @Given("el usuario ingresa su email")
    public void elUsuarioIngresaSuEmail() {
    }
    @Given("el usuario ingresa su email y contrasena")
    public void elUsuarioIngresaSuEmailYContrasena() {
    }
    @Then("recibe un json con el token asignado")
    public void recibeUnJsonConElTokenAsignado() {
    }
    @Then("recibe un json diciendo que falta la contrasena")
    public void recibeUnJsonDiciendoQueFaltaLaContrasena() {
    }
}
