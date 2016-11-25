import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import pageobject.LoginPage;
import step_definitions.WebDriverSingletonClass;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, plugin = { "pretty", "html:target/html" }, features = "src/test/features/TestAutomation.feature", strict = true)
public class CucumberRunnerTest {

	static WebDriver driver;

	@BeforeClass
	public static void setup() {

		driver = WebDriverSingletonClass.instantiateWebDriverInstance();
		driver.navigate().to("localhost:3003");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LoginPage loginPage = new LoginPage();
		loginPage.login("admin", "password");

	}

	@AfterClass
	public static void tearDown() {
		WebDriverSingletonClass.instantiateWebDriverInstance().quit();
	}

}
