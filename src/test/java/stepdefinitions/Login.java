package stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import resources.Base;

public class Login extends Base {

	public WebDriver driver;
	public Logger log;
	public LandingPage landingPage;
	public LoginPage loginPage;
	public MyAccountPage myAccountPage;
	
	
	@Given("^Open any browser$")
	public void Open_any_browser() throws IOException {
		driver = initializeBrowser();
		log = LogManager.getLogger(Login.class.getName());
		log.debug("Browser got launched");
	}
	
	@And("^Go to the application url and navigate to login page$")
	public void Go_to_the_application_url_and_navigate_to_login_page() {
		
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to the url");
		
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.LoginOption().click();
		
		
	}
	
	@When("^User enter username as \"([^\"]*)\" and password as \"([^\"]*)\" into fields$")
	public void User_enter_username_and_password_into_fields(String email,String password) {
		
		loginPage = new LoginPage(driver);
		loginPage.emailField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);
		
		
		
	}
	
	@And("^User click on the Login button$")
	public void User_click_on_the_Login_button() {
		loginPage.LoginButton().click();
	}
	
	@Then("^User should be logged in to the system successfully$")
	public void User_should_be_logged_into_the_system_successfully() {
		
		myAccountPage = new MyAccountPage(driver);
		Assert.assertTrue(myAccountPage.myAccountInfo().isDisplayed());
		
		
	}
	
	@After
	public void closure() {
		driver.close();
	}
	
}
