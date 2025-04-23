package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {


	protected WebDriver driver;
	protected WebDriverWait wait;
	
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
}
