package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getSearchInput() {
		return find(By.id("search_product"));
	}
	
	public WebElement getViewProductLink (int productNumber) {
		return find(By
				.xpath("//*[contains(@class, 'features_items')]/div[contains(@class, 'col-sm-4')]['" + productNumber + "']//li/a"));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
