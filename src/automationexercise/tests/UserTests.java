package automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTests extends BaseTests {
	
	@Test
	public void registerUser() {
		signupLoginPage.waitForPageToLoad();
		Assert.assertTrue(driver.getCurrentUrl().contentEquals(baseUrl), "You're not on home page");
	}

}
