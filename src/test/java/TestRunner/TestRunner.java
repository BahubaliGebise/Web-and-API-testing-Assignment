package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/java/feature"},
        glue = {"StepDefinitions"}
        //plugin = {"com.cucumber.listener.ExtentCucumberFormat:target/cucumber-reports/report.html"},
        //plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty"}
        //tags = {"@Regression"}
)

public class TestRunner {
}
