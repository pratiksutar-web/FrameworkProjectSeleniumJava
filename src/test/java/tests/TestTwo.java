package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class TestTwo {

	@Test
	public void twoTestMethod() throws InterruptedException {
		System.out.println("Test two method has been passed");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com");
		Thread.sleep(2000);
		driver.close();
	}
}
