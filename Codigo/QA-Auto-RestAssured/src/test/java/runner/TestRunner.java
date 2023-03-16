package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/featureFiles/RestAPIReqresDelete.feature",
                "src/test/resources/featureFiles/RestAPIReqresLogin.feature"},
        glue = {"step.definitions"},
        publish = true
        // monochrome = true,
        //dryRun = false
)
public class TestRunner {
}
