package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Feature"},
        glue = {"StepDefinitions"},
        plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"},
        tags = "@Regression"
)

public class TestRunner {
}
