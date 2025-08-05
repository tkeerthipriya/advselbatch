package testNG;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertAndSoftAssert {
	@Test
	public void demo() {
	String expTitle=	"Facebook – log in or sign up";
	
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		@Nullable
		String actTitle = driver.getTitle();
		//Assert.assertEquals(expTitle, actTitle);
		SoftAssert soft= new SoftAssert();
		soft.assertEquals(actTitle, expTitle);
		System.out.println("facebook");
	soft.assertAll();
		
	}
	

}
