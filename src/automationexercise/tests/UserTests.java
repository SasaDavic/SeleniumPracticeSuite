package automationexercise.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationexercise.pages.NavPage;
import automationexercise.pages.SignupPage;

public class UserTests extends BaseTests {
	
	@Test (priority = 10)
	public void registerUser() {
		navPage.waitForPageToLoad();
		assertCurrentUrl("https://www.automationexercise.com/");
		navPage.getSignupLoginLink().click();
		navPage.waitForPageToLoad();
		assertCurrentUrl("https://www.automationexercise.com/login");
		
		Assert.assertTrue(driver.findElement(By.className("signup-form"))
				.findElement(By.tagName("h2")).getText().contains("New User Signup!"), 
				"'New User Signup!' is not visible");
		
		Assert.assertTrue(signupLoginPage.getSignupNameInput().isDisplayed(), 
				"Signup name input is not displayed");
		Assert.assertTrue(signupLoginPage.getSignupNameInput().isEnabled(), 
				"Signup name input is not enabled");
		Assert.assertTrue(signupLoginPage.getSignupEmailAddressInput().isDisplayed(), 
				"Signup email input is not displayed");
		Assert.assertTrue(signupLoginPage.getSignupEmailAddressInput().isEnabled(), 
				"Signup email input is not enabled");
		Assert.assertTrue(signupLoginPage.getSignupButton().isEnabled(), 
				"Signup signup button is not enabled");
		signupLoginPage.waitForSignUpButtonToBeClickable();
		signupLoginPage.registerNewUser("Sasa", "sasa@mail.com");
		
		signupLoginPage.waitForPageToLoad();
		assertCurrentUrl("https://www.automationexercise.com/signup");
		signupPage.waitForSignupHeaderToBeVisible();
		
		signupPage.selectFemale();
		assertTrue(signupPage.isFemaleSelected(), "Mrs. is not selected!");
		signupPage.getNameInput().clear();
		signupPage.getNameInput().sendKeys("Sasa");
		assertFalse(signupPage.getEmailInput().isEnabled(), "Email input is enabled!");
		signupPage.getPasswordInput().sendKeys("0123456");
		signupPage.fillUpRandomDateOfBirth();
		signupPage.getNewsletterCheckbox().click();
		assertTrue(signupPage.getNewsletterCheckbox().isSelected(), "Checkbox is not selected");
		signupPage.getSpecialOffersCheckbox().click();
		assertTrue(signupPage.getSpecialOffersCheckbox().isSelected(), "Checkbox is not selected");
		
		signupPage.getFirstNameInput().sendKeys("Sasa");
		signupPage.getLastNameInput().sendKeys("Zivkovic");
		signupPage.getCompanyInput().sendKeys("Kompanija");
		signupPage.getAddressInput().sendKeys("Gavrilo Princip 51");
		signupPage.getAddress2Input().sendKeys("Bosko Buha 5");
		signupPage.selectRandomCountry();
		signupPage.getStateInput().sendKeys("Srbija");
		signupPage.getCityInput().sendKeys("Nis");
		signupPage.getZipcodeInput().sendKeys("18000");
		signupPage.getMobileNumberInput().sendKeys("123123");
		signupPage.getCreateAccountButton().click();
		
		statusMessagePage.waitForPageToLoad();
		assertCurrentUrl("https://www.automationexercise.com/account_created");
		statusMessagePage.waitForMessageToLoad();
		assertTrue(statusMessagePage.getHeaderMessageAccountCreated().equalsIgnoreCase("ACCOUNT CREATED!"), 
				"Message is not as expected! (ACCOUNT CREATED)"
				+ "Actual message is: " + statusMessagePage.getHeaderMessageAccountCreated());
		statusMessagePage.getContinueButton().click();
		navPage.waitUntilLoggedInIsVisible();
		
	//ne brisemo nalog, ukoliko podatke koristimo za logovanje u narednom testu
		/*
		navPage.getDeleteAccountLink().click();
		statusMessagePage.waitForPageToLoad();
		assertCurrentUrl("https://www.automationexercise.com/delete_account");
		statusMessagePage.waitForMessageToLoad();
		assertTrue(statusMessagePage.getHeaderMessageAccountDeleted().equalsIgnoreCase("ACCOUNT DELETED!"), 
				"Message is not as expected! (ACCOUNT DELETED!)"
				+ "Actual message is: " + statusMessagePage.getHeaderMessageAccountDeleted());
		statusMessagePage.getContinueButton().click();
		assertCurrentUrl("https://www.automationexercise.com/");
		*/
		navPage.getLogoutLink().click();
		navPage.waitUntilLoggedInIsNotVisible();
	}
	
	@Test (priority = 20)
	public void loginUserWithCorrectEmailAndPassword() {
		
		assertCurrentUrl("https://www.automationexercise.com/");
		navPage.getSignupLoginLink().click();
		signupLoginPage.waitForPageToLoad();
		assertCurrentUrl("https://www.automationexercise.com/login");
		
		Assert.assertEquals(driver.findElement(By.className("login-form")).findElement(By.tagName("h2")).getText(),
				"Login to your account",
				"Message is not as expected!");
		
		Assert.assertTrue(signupLoginPage.getLoginEmailInput().isDisplayed(), 
				"Email input is no displayed!");
		Assert.assertTrue(signupLoginPage.getLoginEmailInput().isEnabled(), 
				"Email is not enabled!");
		Assert.assertTrue(signupLoginPage.getLoginPasswordInput().isDisplayed(), 
				"Password input is no displayed!");
		Assert.assertTrue(signupLoginPage.getLoginPasswordInput().isEnabled(), 
				"Passeord input is not enabled!");
		Assert.assertTrue(signupLoginPage.getLoginButton().isEnabled(), 
				"Login button is not enabled!");
		
		signupLoginPage.loginUser("sasa@mail.com", "0123456");
		navPage.waitForPageToLoad();
		navPage.waitUntilLoggedInIsVisible();
		navPage.getDeleteAccountLink().click();
		
		assertCurrentUrl("https://www.automationexercise.com/delete_account");
		statusMessagePage.waitForPageToLoad();
		statusMessagePage.waitForMessageToLoad();
		Assert.assertTrue(statusMessagePage.getHeaderMessageAccountDeleted().equalsIgnoreCase("Account Deleted!"), 
				"Message is not as expected! Actual message is: " + statusMessagePage.getHeaderMessageAccountDeleted());
		Assert.assertTrue(statusMessagePage.getContinueButton().isEnabled(), 
				"Button is not enabled!");
		statusMessagePage.getContinueButton().click();
		navPage.waitForPageToLoad();
		assertCurrentUrl("https://www.automationexercise.com/");
		
	}
	
	
	@Test (priority = 30)
	public void loginUserWithIncorrectEmailAndPassword() { 
		assertCurrentUrl("https://www.automationexercise.com/");
		navPage.waitForPageToLoad();
		navPage.getSignupLoginLink().click();
		assertCurrentUrl("https://www.automationexercise.com/login");
		signupLoginPage.waitForPageToLoad();
		signupLoginPage.waitForLoginButtonToBeClickable();
		signupLoginPage.loginUser("sasa@mail.com", "0123456");
		
		Assert.assertEquals(signupLoginPage.getLoginErrorMessage(), 
				"Your email or password is incorrect!",
				"Login error message is not as expected!");
		
	}

}
