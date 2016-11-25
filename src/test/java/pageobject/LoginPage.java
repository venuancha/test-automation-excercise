package pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import step_definitions.WebDriverSingletonClass;

public class LoginPage {

	WebDriver driver;

	public LoginPage() {
		this.driver = WebDriverSingletonClass.instantiateWebDriverInstance();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginLink;
	@FindBy(xpath = "//*[@id='username']")
	WebElement username;
	@FindBy(xpath = "//*[@id='password']")
	WebElement password;
	@FindBy(xpath = "//*[@id='doLogin']")
	WebElement loginButton;

	public void login(String userName, String pass) {
		loginLink.click();
		username.sendKeys(userName);
		password.sendKeys(pass);
		loginButton.click();
	}

}
