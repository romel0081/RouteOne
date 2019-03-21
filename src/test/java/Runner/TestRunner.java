package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.Parameters;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features",glue = "stepDefinitions",format = "pretty")
public class TestRunner extends AbstractTestNGCucumberTests {

}
