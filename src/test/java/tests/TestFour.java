package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFour {

	public WebDriver driver;
	@Test
	public void testFour() throws InterruptedException {
		System.out.println("Test Four has been passed");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com");
		Thread.sleep(2000);
		
		Assert.assertTrue(false);
		
	}
	
	@AfterMethod()
	public void closeApplication() {
		driver.close();
	}
}
