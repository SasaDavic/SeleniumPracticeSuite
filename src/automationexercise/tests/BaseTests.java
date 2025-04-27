package automationexercise.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import automationexercise.pages.NavPage;
import automationexercise.pages.SignupLoginPage;
import automationexercise.pages.SignupPage;

public abstract class BaseTests {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String baseUrl = "https://www.automationexercise.com";
	protected NavPage navPage;
	protected SignupLoginPage signupLoginPage;
	protected SignupPage signupPage;
	
		
	

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		navPage = new NavPage(driver);
		signupLoginPage = new SignupLoginPage(driver);
		signupPage = new SignupPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
	// ------- Pomoćne metode za testove -------
	
	public void assertCurrentUrl(String expectedUrl) {
		 String actualUrl = driver.getCurrentUrl();
		  Assert.assertTrue(actualUrl.contentEquals(expectedUrl),
		        "You are not on the expected page! Current URL is: " + actualUrl);
	}
}
