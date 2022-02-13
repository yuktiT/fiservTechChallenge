 package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddAppPage;
import pageObjects.HomePage;
import utilities.PropertyReader;

public class AddAppStep {
	private WebDriver driver = TestHooks.driver;
	private WebDriverWait wait;
	HomePage HP = new HomePage(driver,wait);
	AddAppPage AP = new AddAppPage(driver,wait);
	
	
	public AddAppStep() throws Exception {
		PropertyReader propertiesReader = new PropertyReader();
		this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
	}

	@Given("User is login into Fiserv Developer Portal using {} and {}")
	public void user_is_login_into_fiserv_developer_portal_using_username_and_password(String username, String Password) throws Exception 
	{
		HP.AcceptCookies();
		HP.LoginButton();
		HP.Username(username);
		HP.Password(Password);	
	}

	@Given("click on login button")
	public void click_on_login_button() {
		HP.LoginBtn();
	}

	@When("user selects the API Apps table to developer portal")
	public void user_selects_the_api_apps_table_to_developer_portal() throws Exception {
		HP.APIAppbtn();
	}
	
	@When("user clicks on Add API App button to create an app")
	public void user_clicks_on_add_api_app_button_to_create_an_app() throws Exception {
		AP.AddAPIApp();
	   
	}
	@When("user inputs the {}, {} and {} to create the app")
	public void user_inputs_the_app_name_discription_and_environment_to_create_the_app(String AppName,String Discription,String Environment) {
		AP.DialogBox();
		AP.DisplayName(AppName);
		AP.Discription(Discription);
		WebElement radioElement = driver.findElement(By.xpath("//div[contains(@class,'environment form-check')]/label[contains(text(),'"+Environment+"')]"));
		boolean selectState = radioElement.isSelected();	
		
		//performing click operation only if element is not selected
		if(selectState==false)
		{
			radioElement.click();
		}
	}
	
	@Then("user clicks on confirm button, to create the app successfully")
	public void user_clicks_on_confirm_button_to_create_the_app_successfully() throws Exception {
	   AP.Confirmbtn();
	   Thread.sleep(5000);
	}
	
	@Then("app should be created successfully having {} and {}")
	public void app_should_be_created_successfully(String AppName,String EnvironmentName) {
		Assert.assertEquals("App Name is not as expected", AP.AppNameonConfPage(), AppName);
		Assert.assertEquals("Description is not as expected", AP.EnvOnConfPage(), EnvironmentName);
	}



}
