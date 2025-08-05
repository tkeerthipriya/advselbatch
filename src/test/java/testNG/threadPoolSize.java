package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class threadPoolSize {
	
	
	@Test(invocationCount = 10,threadPoolSize = 5)
	public void driver() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	
	

}
