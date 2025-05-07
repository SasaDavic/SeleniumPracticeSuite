package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupLoginPage extends BasePage {
	
	

	public SignupLoginPage(WebDriver driver) {
		super(driver);
	}
	//signup forma

	public WebElement getSignupNameInput() {
		return find(By.xpath("//input[@data-qa= 'signup-name']"));
	}
	
	public WebElement getSignupEmailAddressInput() {
		return find(By.xpath("//input[@data-qa= 'signup-email']"));
	}

	public WebElement getSignupButton() {
		return find(By.xpath("//button[@data-qa= 'signup-button']"));
	}
	
	public void registerNewUser(String name, String email) {
		getSignupNameInput().sendKeys(name);
		getSignupEmailAddressInput().sendKeys(email);
		getSignupButton().click();
	}
	
	//login forma
	
	public WebElement getLoginEmailInput() {
		return find(By.xpath("//input[@data-qa = 'login-email']"));
	}
	
	public WebElement getLoginPasswordInput() {
		return find(By.xpath("//input[@data-qa = 'login-password']"));
	}
	
	public WebElement getLoginButton() {
		return find(By.xpath("//*[@data-qa = 'login-button']"));
	}
	
	public void loginUser(String email, String pass) {
		getLoginEmailInput().sendKeys(email);
		getLoginPasswordInput().sendKeys(pass);
		getLoginButton().click();
	}
	
	//cekanje za formu na zajednickoj stranici za login i signup
		public void waitForSignUpButtonToBeClickable() {
			wait.until(ExpectedConditions.elementToBeClickable(this.getSignupButton()));
		}
		
		public void waitForLoginButtonToBeClickable() {
			wait.until(ExpectedConditions.elementToBeClickable(this.getLoginButton()));
		}
		
	//greske za pogresan unos podataka
		
		public String getLoginErrorMessage() {
			return find(By.xpath("//form[contains(@action, '/login')]/p")).getText();
		}
	
	
	
	
	
}
