package automationexercise.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ProductsPageTests extends BaseTests {

	@Test
	public void verifyAllProductsAndProductDetailPage() {
		int productNumber = 1;
		assertCurrentUrl("https://www.automationexercise.com/");
		navPage.getProductsLink().click();
		productsPage.waitForPageToLoad();
		assertCurrentUrl("https://www.automationexercise.com/products");
		productsPage.getViewProductLink(productNumber).click();
		assertCurrentUrl("https://www.automationexercise.com/product_details/" + productNumber);
		productDetailsPage.waitForPageToLoad();
		wait.until(ExpectedConditions
				.visibilityOfAllElements(productDetailsPage.getProductName(), 
						productDetailsPage.getProductCategory(),
						productDetailsPage.getProductPrice(),
						productDetailsPage.getProductAvailability(),
						productDetailsPage.getProductCondition(),
						productDetailsPage.getProductBrand()
						));
		
	}
	
	
}
