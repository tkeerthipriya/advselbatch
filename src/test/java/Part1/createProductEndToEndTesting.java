package Part1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createProductEndToEndTesting {

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
		
		
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();

		
		
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\Book1Selenium.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
	Sheet productname = wb.getSheet("product");
		
	String p1 = productname.getRow(1).getCell(2).getStringCellValue();
		 Sheet quantity = wb.getSheet("product");
		String q1 = quantity .getRow(1).getCell(3).getStringCellValue();
		 Sheet price = wb.getSheet("product");
		String p12 = price.getRow(1).getCell(4).getStringCellValue();
		
			
		
		Random ran=new Random();
		int randcount = ran.nextInt(1000);

		
	
		
		driver.findElement(By.name("productName")).sendKeys(p1+randcount);
		WebElement category = driver.findElement(By.name("productCategory"));
		Select sel = new Select(category);
		sel.selectByVisibleText("Others");
		WebElement quantity1 = driver.findElement(By.name("quantity"));
		quantity1.clear();
		quantity1.sendKeys(q1);
WebElement price1 = driver.findElement(By.name("price"));
price1.clear();
price1.sendKeys(p12);
WebElement vendorid = driver.findElement(By.name("vendorId"));
Select sel1=new Select(vendorid);
sel1.selectByValue("VID_001");
driver.findElement(By.xpath("//button[@type='submit']")).click();

//validation
WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(toastmsg));
String msg = toastmsg.getText();
if(msg.contains(p1))
{
	System.out.println("product is successfully created");
}
else {
	System.out.println("product is not created");
	
}

driver.findElement(By.xpath("//button[@aria-label='close']")).click();
//logout
Actions act = new Actions(driver);
WebElement mousehaver = driver.findElement(By.xpath("//div[@class='user-icon']"));
act.moveToElement(mousehaver).perform();
WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
	act.moveToElement(logout).click().perform();
	driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
