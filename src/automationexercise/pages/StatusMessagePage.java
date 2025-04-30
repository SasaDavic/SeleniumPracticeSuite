package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StatusMessagePage extends BasePage {

	public StatusMessagePage(WebDriver driver) {
		super(driver);
	}

	public void waitForMessageToLoad() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2/b")));
	}
	
	public String getHeaderMessageAccountCreated() {
		return driver.findElement(By.xpath("//h2[@data-qa='account-created']/b")).getText();
	}
	
	public String getHeaderMessageAccountDeleted() {
		return driver.findElement(By.xpath("//h2[@data-qa='account-deleted']/b")).getText();
	}
	
	public WebElement getContinueButton() {
		return find(By.xpath("//*[@data-qa='continue-button']"));
	}

}
