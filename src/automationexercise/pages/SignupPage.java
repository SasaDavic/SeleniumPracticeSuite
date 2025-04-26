package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupPage extends BasePage {

	public SignupPage(WebDriver driver) {
		super(driver);
	}

	//signup page
	
		//cekanje za posebnu signup stranicu	
		public void waitForSignupHeaderToBeVisible() {
			wait.until(ExpectedConditions
					.textToBePresentInElementLocated(By.xpath("//h2[contains(@class, 'title')]/b"), 
					"ENTER ACCOUNT INFORMATION"));
		}
	
		public WebElement getMrRadioButton() {
			return find(By.id("id_gender1"));
		}
		
		public WebElement getMrsRadioButton() {
			return find(By.id("id_gender2"));
		}
		
		public void selectMale() {
			getMrRadioButton().click();
		}
		
		public void selectFemale() {
			getMrsRadioButton().click();
		}
		 
		public boolean isMaleSelected() {
			return getMrRadioButton().isSelected();
		}
		
		public boolean isFemaleSelected() {
			return getMrsRadioButton().isSelected();
		}
		

		
	
	
}
