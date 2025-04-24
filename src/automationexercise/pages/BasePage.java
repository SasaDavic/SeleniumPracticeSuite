package automationexercise.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {


	protected WebDriver driver;
	protected WebDriverWait wait;
	
	
	protected BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	public void waitForPageToLoad() {
		wait.until(ExpectedConditions
				.invisibilityOfElementWithText(By.className("pull-left"), 
						"Copyright © 2021 All rights reserved"));
	}
}
