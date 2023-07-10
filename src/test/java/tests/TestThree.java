package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestThree {

	public WebDriver driver;
	@Test
	public void testThree() throws InterruptedException {
		System.out.println("Test three has been passed ");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com");
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void closeApplication() {
		driver.close();
	}
}
