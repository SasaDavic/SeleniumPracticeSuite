package automationexercise.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends BasePage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getNameInput() {
		return find(By.xpath("//input[@data-qa='name']"));
	}

	public WebElement getEmailInput() {
		return find(By.xpath("//input[@data-qa='email']"));
	}
	
	public WebElement getSubjectInput() {
		return find(By.xpath("//input[@data-qa='subject']"));
	}
	
	public WebElement getMessageTextarea() {
		return find(By.xpath("//*[@data-qa='message']"));
	}
	
	public WebElement getUploadFileInput() {
		return find(By.name("upload_file"));
	}
	
	public WebElement getSubmitButton() {
		return find(By.xpath("//input[@data-qa='submit-button']"));
	}
	
	public String getSuccessMessage() {
		return find(By.xpath("//div[contains(@class, 'status')]")).getText();
	}
	
	public WebElement getHomeButton() {
		return find(By.className("btn-success"));
	}
	
	public void uploadFile(String relativePath) {
		File file = new File(relativePath);
		if (file.exists()) {
			String absolutePath = file.getAbsolutePath();
			this.getUploadFileInput().sendKeys(absolutePath);
		} else {
			System.out.println("Fajl ne postoji: " + relativePath);
		}
		
	}
	
	public void fillOutTheContactUsFormWithFile(String name, String email, String subject, String message, String fileRelativePath) {
		this.getNameInput().sendKeys(name);
		this.getEmailInput().sendKeys(email);
		this.getSubjectInput().sendKeys(subject);
		this.getMessageTextarea().sendKeys(message);
		this.getUploadFileInput().sendKeys(fileRelativePath);
		this.getSubmitButton().click();
	}
	
	 // Dodatna metoda za čekanje na uspešnu poruku
    public void waitForSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'status')]")));
    }
}
