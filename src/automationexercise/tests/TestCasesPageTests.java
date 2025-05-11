package automationexercise.tests;

import org.testng.annotations.Test;

public class TestCasesPageTests extends BaseTests {

	@Test
	public void verifyTestCasesPage() {
		assertCurrentUrl("https://www.automationexercise.com/");
		navPage.waitForPageToLoad();
		navPage.getTestCasesLink().click();
		assertCurrentUrl("https://www.automationexercise.com/test_cases");
		testCasesPage.waitForPageToLoad();
		testCasesPage.getTestCaseLink(5).click();
		testCasesPage.waitForDetailedTestStepsToBeVisible(5);
		
	}
	
}
