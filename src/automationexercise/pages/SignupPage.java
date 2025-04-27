package automationexercise.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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
		
		public WebElement getNameInput() {
			return find(By.xpath("//input[@data-qa='name']"));
		}
		
		public WebElement getEmailInput() {
			return find(By.xpath("//input[@data-qa='email']"));
		}
		
		public boolean isEmailEnebled() {
			return getEmailInput().isEnabled();
		}
		
		public WebElement getPasswordInput() {
			return find(By.xpath("//input[@data-qa='password']"));
		}
		
		public WebElement getDaySelect() {
			return find(By.xpath("//select[@data-qa='days']"));
		}
		
		public WebElement getMonthSelect() {
			return find(By.xpath("//select[@data-qa='months']"));
		}
		
		public WebElement getYearSelect() {
			return find(By.xpath("//select[@data-qa='years']"));
		}
		
		//dani i meseci su brojevi od 1-31 i 1-12, godine su brojevi od 1900-2021
		public void fillUpDateOfBirth(String day, String month, String year) {
			new Select(getDaySelect()).selectByValue(day);
			new Select(getMonthSelect()).selectByValue(month);
			new Select(getYearSelect()).selectByValue(year);
		}
		
		// Popuni sa slučajnim vrednostima
		public void fillUpRandomDateOfBirth() {
			Random random = new Random();
			int day = random.nextInt(31) + 1;
			int month = random.nextInt(12) + 1;
			int year = random.nextInt(122) + 1900;
			
			this.fillUpDateOfBirth(day + "", month + "", year + "");
		}
		
		public WebElement getNewsletterCheckbox() {
			return find(By.id("newsletter"));
		}
		
		public WebElement getSpecialOffersCheckbox() {
			return find(By.id("optin"));
		}
		
		public WebElement getFirstNameInput() {
			return find(By.xpath("/input[@data-qa='first_name']"));
		}
	
		public WebElement getLastNameInput() {
			return find(By.xpath("/input[@data-qa='last_name']"));
		}
		
		public WebElement getCompanyInput() {
			return find(By.xpath("/input[@data-qa='company']"));
		}
		
		public WebElement getAddressInput() {
			return find(By.xpath("/input[@data-qa='address']"));
		}
		
		public WebElement getAddress2Input() {
			return find(By.xpath("/input[@data-qa='address2']"));
		}
		
		public WebElement getCountrySelect() {
			return find(By.id("country"));
		}
		
		public void selectCountryByIndex(CountryOption countryOption) {
		    new Select(this.getCountrySelect()).selectByIndex(countryOption.getCountryIndex());
		}
		
		public void selectCountryByValue(CountryOption countryOption) {
		    new Select(this.getCountrySelect()).selectByValue(countryOption.getCountryValue());
		}
		
		public void selectRandomCountry() {
			Random random = new Random();
			int index = random.nextInt(CountryOption.values().length);
			new Select(this.getCountrySelect()).selectByIndex(index);
		}
		
		public WebElement getStateInput() {
			return find(By.xpath("//input[@data-qa='state']"));
		}
		
		public WebElement getCityInput() {
			return find(By.xpath("//input[@data-qa='city']"));
		}
		
		public WebElement getZipcodeInput() {
			return find(By.xpath("//input[@data-qa='zipcode']"));
		}
		
		public WebElement getMobileNumberInput() {
			return find(By.xpath("//input[@data-qa='mobile_number']"));
		}
		
		public WebElement getCreateAccountButton() {
			return find(By.xpath("//button[@data-qa='create-account']"));
		}
		
		
		
		
		
		
		
		
}
