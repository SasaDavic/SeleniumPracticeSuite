package automationexercise.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {


	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;
	
	protected BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.actions = new Actions(driver);
	}

	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	public void waitForPageToLoad() {
		// Prvo pronađemo element
	    WebElement footerText = find(By.xpath("//p[contains(@class, 'pull-left')]"));

	    // Skrolujemo do tog elementa (da bi bio u vidljivom delu stranice)
	    actions.moveToElement(footerText)
	    	   .perform();

	    // Samo za proveru: ispišemo tekst na konzolu - ako nam je potrebna provera, ne uvek
	    /* String text = footerText.getText();
	       System.out.println(text); */

	    // Čekamo da se tekst učita na elementu
	    wait.until(ExpectedConditions.textToBePresentInElement(
	        footerText, 
	        "Copyright © 2021 All rights reserved"
	    ));
				
	}
}
