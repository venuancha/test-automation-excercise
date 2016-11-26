package step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingletonClass {

	static WebDriver driver;

	private WebDriverSingletonClass() {

	}

	public static WebDriver instantiateWebDriverInstance() {

		if (driver == null) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "/src/test/resources/chromedriver");
			driver = new ChromeDriver();
		}

		return driver;
	}

}
