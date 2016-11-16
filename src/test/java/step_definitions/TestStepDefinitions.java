package step_definitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStepDefinitions {

	static Logger log = Logger.getLogger(TestStepDefinitions.class.getName());

	static WebDriver driver;

	@Before
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/venuancha/Downloads/chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public static void tearDown() {
		driver.quit();
	}

	@Given("^I login to Hotel Management Platform$")
	public void loginToHM() throws InterruptedException {
		driver.navigate().to("localhost:3003");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='password']"))
				.sendKeys("password");
		driver.findElement(By.xpath("//*[@id='doLogin']")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}

	@When("^I create a entry with details as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void createEntryWithDetails(String hotelName, String address,
			String owner, String phoneno, String email) throws Throwable {
		driver.findElement(By.xpath("//input[@id='hotelName']")).sendKeys(
				hotelName);
		driver.findElement(By.xpath("//input[@id='address']"))
				.sendKeys(address);
		driver.findElement(By.xpath("//input[@id='owner']")).sendKeys(owner);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneno);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='createHotel']")).click();
		TimeUnit.SECONDS.sleep(5);

	}

	@Then("^A row with entry created$")
	public void verifyRowCreation() throws Throwable {
		WebElement element = driver.findElement(By
				.xpath("//*[contains(@class, 'hotelRow')]"));
		Assert.assertTrue(element != null);

	}

	@Given("^a entry already existed$")
	public void verifyExistingEntry() throws Throwable {
		WebElement element = driver.findElement(By
				.xpath("//*[contains(@class, 'hotelRow')]"));
		Assert.assertTrue(element != null);
	}

	@When("^I click on delete entry$")
	public void deleteEntry() throws Throwable {
		driver.findElement(
				By.xpath("//*[contains(@class, 'glyphicon glyphicon-remove hotelDelete')]"))
				.click();
		TimeUnit.SECONDS.sleep(5);
	}

	@Then("^entry is deleted$")
	public void verifyEntryDelete() throws Throwable {

		Assert.assertFalse(isElementPresent("//*[contains(@class, 'hotelRow')]"));

	}

	@When("^I create with ([^\"]*) and ([^\"]*) and ([^\"]*) and ([^\"]*) and ([^\"]*)$")
	public void createMultipleEntries(String hotelName, String address,
			String owner, String phoneNo, String email) throws Throwable {
		driver.findElement(By.xpath("//input[@id='hotelName']")).sendKeys(
				hotelName);
		driver.findElement(By.xpath("//input[@id='address']"))
				.sendKeys(address);
		driver.findElement(By.xpath("//input[@id='owner']")).sendKeys(owner);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneNo);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='createHotel']")).click();
		TimeUnit.SECONDS.sleep(2);
	}

	private boolean isElementPresent(String locatorKey) {
		try {
			driver.findElement(By.xpath(locatorKey));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
}