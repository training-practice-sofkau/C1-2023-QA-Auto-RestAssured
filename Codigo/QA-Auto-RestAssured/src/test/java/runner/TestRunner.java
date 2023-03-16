package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featureFiles/DemoRestAPITest.feature"},
        glue = {"step.definitions"},
        publish = true
       // monochrome = true,
        //dryRun = false
       )
public class TestRunner {
}
