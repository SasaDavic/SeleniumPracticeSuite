package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavPage extends BasePage {

	
	public NavPage(WebDriver driver) {
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
		return find(By.xpath("//*[contains(@class, 'navbar-nav')]//a[contains(@href, 'login')]"));
	}
	
	public WebElement getLogoutLink() {
		return find(By.xpath("//*[contains(@class, 'navbar-nav')]//a[contains(@href, 'logout')]"));
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
	
	public void waitUntilLoggedInIsVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//ul[contains(@class, 'nav')]//*[contains(text(), 'Logged in as')]")));
	}
	
	public void waitUntilLoggedInIsNotVisible() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By
				.xpath("//ul[contains(@class, 'nav')]//*[contains(text(), 'Logged in as')]")));
	}
	
	public WebElement getDeleteAccountLink() {
		return find(By.xpath("//ul[contains(@class, 'nav')]//*[contains(text(), ' Delete Account')]"));
	}
}
