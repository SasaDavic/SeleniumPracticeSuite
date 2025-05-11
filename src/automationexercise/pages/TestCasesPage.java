package automationexercise.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCasesPage extends BasePage {

	public TestCasesPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getTestCaseLink(int testCaseNumber) {
		List<WebElement> testCases = driver.findElements(By.xpath("//*[contains(@class, 'panel-group')]//h4//a"));
		return testCases.get(testCaseNumber - 1);		
	}
	
	public void waitForDetailedTestStepsToBeVisible(int testCaseNumber) {
		String idName = "collapse" + testCaseNumber;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[contains(@class, 'panel-group')]//div[contains(@id, '"+ idName +"')]")));
	}

}
