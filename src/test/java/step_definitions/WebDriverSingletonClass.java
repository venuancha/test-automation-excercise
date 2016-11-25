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
					"/Users/venuancha/Downloads/chromedriver");
			driver = new ChromeDriver();
		}

		return driver;
	}

}
