package testRunner;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/cucumber.json"}
        , features = {"src/test/resources/features/simpleTest.feature"}
        , glue = "stepsDefinition"
)
public class Runner {
}
