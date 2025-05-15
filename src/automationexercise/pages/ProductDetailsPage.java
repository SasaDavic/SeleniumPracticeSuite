package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getProductName() {
		return find(By.xpath("//*[contains(@class, 'product-information')]/h2"));
	}
	
	public WebElement getProductCategory() {
		return find(By.xpath("//*[contains(@class, 'product-information')]/p"));
	}
	
	public WebElement getProductPrice() {
		return find(By.xpath("//*[contains(@class, 'product-information')]/span/span"));
	}
	
	public WebElement getProductAvailability() {
		return find(By.xpath("//*[contains(@class, 'product-information')]/p[2]"));
	}
	
	public WebElement getProductCondition() {
		return find(By.xpath("//*[contains(@class, 'product-information')]/p[3]"));
	}
	
	public WebElement getProductBrand() {
		return find(By.xpath("//*[contains(@class, 'product-information')]/p[4]"));
	}

}
