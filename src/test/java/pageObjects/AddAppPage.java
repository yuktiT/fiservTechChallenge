package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;

public class AddAppPage extends BaseClass{
	
	public AddAppPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	By AddAPIApp = By.xpath("//a[text()=' + Add API app']");
	By DialogBox = By.xpath("//div[@role='dialog']");
	By DisplayName = By.xpath("//input[@name='displayName[0][value]']");
	By Discription = By.xpath("//*[@name='description[0][value]']");
	By EnvironmentBtn = By.xpath("//div[contains(@class,'environment form-check')]/label[contains(text(),'Production')]");
	By Confirmbtn = By.xpath("//button[contains(@class,'confirm_app')]");
	By Cancelbtn = By.xpath("//button[@class='edit-step app-cancel-edit button button--default js-form-submit form-submit btn btn-primary ui-button ui-corner-all ui-widget']");
	By AppNameConfimationPage = By.xpath("//span[ @class=' app-name']");
	By AppEnvOnConfirmationPage= By.xpath("(//span[ @class='field-content']/span)[2]");
	
	public void AddAPIApp() throws InterruptedException {
		driver.findElement(AddAPIApp).click();
		Thread.sleep(3000);
		
	}
	
	public void DialogBox() {
		driver.findElement(DialogBox).isDisplayed();
	}
	
	public void DisplayName(String displayname) {
		driver.findElement(DisplayName).sendKeys(displayname);;
	}
	
	public void Discription(String discription) {
		driver.findElement(Discription).sendKeys(discription);
	}
	
	public void EnvironmentBtn() {
		driver.findElement(EnvironmentBtn).click();
		
	}
	
	public void Confirmbtn() throws Exception {
		try {
		WebElement icon = driver.findElement(Confirmbtn);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", icon);
		if (icon.isEnabled() && icon.isDisplayed()) {
			js.executeScript("arguments[0].click();", icon);	
		}
		else {
			System.out.println("Unable to click on element");
		  }
	    }
		catch(StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		}
	}
	
	public String AppNameonConfPage() {
		return driver.findElement(AppNameConfimationPage).getText();
	}
	
	public String EnvOnConfPage() {
		return driver.findElement(AppEnvOnConfirmationPage).getText();
	}
}
