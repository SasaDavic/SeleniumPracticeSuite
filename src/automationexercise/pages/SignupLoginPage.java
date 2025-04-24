package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupLoginPage extends BasePage {
	
	

	public SignupLoginPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getSignupNameInput() {
		return find(By.xpath("//input[@data-qa= 'signup-name']"));
	}
	
	public WebElement getSignupEmailAddressInput() {
		return find(By.xpath("//input[@data-qa= 'signup-email']"));
	}

	public WebElement getSignupButton() {
		return find(By.xpath("//button[@data-qa= 'signup-button']"));
	}
	
}
