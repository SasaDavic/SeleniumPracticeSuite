package automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsPageTests extends BaseTests {
	
	@Test
	public void contactUsFormTest() {
		assertCurrentUrl("https://www.automationexercise.com/");
		navPage.getContactUsLink().click();
		assertCurrentUrl("https://www.automationexercise.com/contact_us");
		contactUsPage.waitForPageToLoad();
		contactUsPage.fillOutTheContactUsFormWithFile("Sasa", 
				"sasa@mail.com", 
				"test", 
				"Provera contact us forme!", 
				"C:\\Users\\KTG\\eclipse-workspace1\\SeleniumPracticeSuite\\files\\valid_test.txt");
		contactUsPage.handleAlertIfPresent();
		contactUsPage.waitForSuccessMessage();
		Assert.assertTrue(contactUsPage.getSuccessMessage()
				.contains("Success! Your details have been submitted successfully."), 
				"Message is not as expected!");
		contactUsPage.getHomeButton().click();
		assertCurrentUrl("https://www.automationexercise.com/");
		
	}

}
