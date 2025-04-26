package automationexercise.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationexercise.pages.NavPage;
import automationexercise.pages.SignupPage;

public class UserTests extends BaseTests {
	
	@Test
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
	}

}
