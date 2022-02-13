package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;

public class HomePage extends BaseClass{

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	By CookiesAgreeButton = By.xpath("//button[text()='OK, I agree']");
	By LoginButton = By.xpath("//a[text()='Log in']");
	By Username = By.xpath("//input[@name='name']");
	By Password = By.xpath("//input[@name='pass']");
	By Loginbtn = By.xpath("//input[@value='Log in']");
	By APIAppsbtn = By.xpath("//a[text()='API Apps']");
	
	public void AcceptCookies() throws Exception{
		Thread.sleep(2000);
		driver.findElement(CookiesAgreeButton).click();
	}
	
	public void LoginButton() {
		driver.findElement(LoginButton).click();
	}
	
	public void Username(String username) {
		driver.findElement(Username).sendKeys(username);
	}
	
	public void Password(String password) {
		driver.findElement(Password).sendKeys(password);
	}
	
	public void LoginBtn() {
		driver.findElement(Loginbtn).click();
	}
	public void APIAppbtn() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(APIAppsbtn).click();
		Thread.sleep(5000);
	}
}
