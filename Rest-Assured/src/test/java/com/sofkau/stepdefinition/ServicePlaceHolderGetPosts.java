package com.sofkau.stepdefinition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.logging.Logger;

public class ServicePlaceHolderGetPosts {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(ServicePlaceHolderGetPosts.class));
    @When("hace la peticion de posts al servicio place holder")
    public void haceLaPeticionDePostsAlServicioPlaceHolder() {
    }
    @Then("recibe un json con la lista de posts")
    public void recibeUnJsonConLaListaDePosts() {
    }
}
