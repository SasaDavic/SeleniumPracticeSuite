package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage extends BasePage {

	
	protected NavPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getHomeLink() {
		return find(By.xpath("//*[contains(@class, 'container')]//*[contains(text(), 'Home')]"));
	}
	
	public WebElement getProductsLink() {
		return find(By.xpath("//*[contains(@class, 'container')]//*[contains(text(), 'Products')]"));
	}
	
	public WebElement getCartLink() {
		return find(By.xpath("//*[contains(@class, 'container')]//*[contains(text(), 'Cart')]"));
	}
	
	public WebElement getSignupLoginLink() {
		return find(By.xpath("//*[contains(@class, 'container')]//*[contains(text(), 'Signup / Login')]"));
	}
	
	public WebElement getTestCasesLink() {
		return find(By.xpath("//*[contains(@class, 'container')]//*[contains(text(), 'Test Cases')]"));
	}
	
	public WebElement getAPITestingLink() {
		return find(By.xpath("//*[contains(@class, 'container')]//*[contains(text(), 'API Testing')]"));
	}
	
	public WebElement getVideoTutorialsLink() {
		return find(By.xpath("//*[contains(@class, 'container')]//*[contains(text(), 'Video Tutorials')]"));
	}
	
	public WebElement getContactUsLink() {
		return find(By.xpath("//*[contains(@class, 'container')]//*[contains(text(), 'Contact us')]"));
	}
	
}
