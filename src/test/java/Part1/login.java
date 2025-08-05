package Part1;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//login
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		//create campaign
		driver.findElement(By.linkText("Campaigns")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("HPLAPTOPkeelu");
		WebElement target = driver.findElement(By.name("targetSize"));
		target.clear();
		target.sendKeys("10");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//validation
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		if(msg.contains("HPLAPTOPkeelu")) {
			System.out.println("campaign created successfully");
		}
		else {
			System.out.println("Campaign not created");
		}
driver.findElement(By.xpath("//button[@aria-label='close']")).click();
//logout
WebElement mousehauver = driver.findElement(By.xpath("//div[@class='user-icon']"));
Actions act = new Actions(driver);
act.moveToElement(mousehauver).perform();
WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
	act.moveToElement(logout).click().perform();
	driver.quit();
	}

}
