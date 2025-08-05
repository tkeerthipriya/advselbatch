package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class readdatafromproperty {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
Properties prop = new Properties();
prop.load(fis);
String BROWSER = prop.getProperty("Browser");
String URL = prop.getProperty("URL");
String UN = prop.getProperty("UN");
String PSW = prop.getProperty("PSW");
System.out.println(BROWSER);
System.out.println(URL);
System.out.println(UN);
System.out.println(PSW);
WebDriver driver=null;

if (BROWSER.equals("Edge")) {
	 driver=new EdgeDriver();
}
else if(BROWSER.equals("Chrome")) {
	 driver=new ChromeDriver();
}
else if (BROWSER.equals("Firefox")) {
 driver= new FirefoxDriver();
}

Thread.sleep(3000);
//actual script
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get(URL);
driver.findElement(By.id("inputPassword")).sendKeys(PSW);
driver.findElement(By.id("username")).sendKeys(UN);
driver.findElement(By.xpath("//button[@type='submit']")).click();


	}

}
