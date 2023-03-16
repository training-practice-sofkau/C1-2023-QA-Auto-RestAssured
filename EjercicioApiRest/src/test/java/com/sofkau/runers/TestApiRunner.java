package com.sofkau.runers;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/feature/RestAPITest.feature"},
        glue = {"step.definitions"},
        publish = true
       // monochrome = true,
        //dryRun = false
       )
public class TestApiRunner {
}
