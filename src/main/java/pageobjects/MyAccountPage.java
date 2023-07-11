package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	public WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Edit your account information']")
	private WebElement myAccountInfo;
	
	public WebElement myAccountInfo() {
		return myAccountInfo;
		
	}
}
