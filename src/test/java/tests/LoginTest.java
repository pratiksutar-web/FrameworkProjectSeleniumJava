package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import resources.Base;

public class LoginTest extends Base{

	public Logger log;
	
	
	@BeforeMethod()
	public void openApplication() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeBrowser();
		log.debug("Browser Got Launched");
		driver.get(prop.getProperty("url"));
		log.debug("Application url is opened");
		
	}
	
	
	WebDriver driver;
	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedResult) {
		
		
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on MyAccount Dropdown");
		landingPage.LoginOption().click();
		log.debug("Clicked on login option");
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailField().sendKeys(email);
		log.debug("Entered the Email in email field");
		loginPage.passwordField().sendKeys(password);
		log.debug("Entered the Password in password field");
		
		loginPage.LoginButton().click();
		log.debug("Clicked on login button");
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		
		String actualResult = null;
		try {
		if(myAccountPage.myAccountInfo().isDisplayed()) {
			
			actualResult = "Success";
			log.info("Login Successful");
		}
		
		}
		catch(Exception e) {
			actualResult = "Failure";
			log.error("Login Failed");
		}
		
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = {{"pratikjsutar@gmail.com","pratik","Success"},{"example@gmail.com","abc","Failure"}};
		
		return data;
		
	}
	
	
	
	@AfterMethod
	public void closure() {
		driver.close();
	}
}
