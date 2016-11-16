
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, plugin = { "pretty", "html:target/html" }, features = "src/test/features/TestAutomation.feature", strict = true)
public class CucumberRunnerTest {

}
