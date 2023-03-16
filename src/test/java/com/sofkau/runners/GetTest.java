package com.sofkau.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Este es el Main principal para nosotros
@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/getUser.feature"},
        glue = {"com.sofkau.stepdefinitions"},
        publish = true
)
public class GetTest {
}
