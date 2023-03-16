package com.sofkau.runners;

//import com.sofkau.service.ServicesPages;
import io.cucumber.core.cli.Main;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/InicioSesion.feature"},
        glue = {"com.sofkau.stepdefinitions"},
        publish = true
)
public class InicioSesionTestService {

}

