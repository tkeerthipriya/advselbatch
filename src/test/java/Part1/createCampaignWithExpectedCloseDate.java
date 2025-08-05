package Part1;


import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
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
import org.openqa.selenium.support.ui.WebDriverWait;

public class createCampaignWithExpectedCloseDate {

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

		
		FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\Book1Selenium.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet2");
		Row rw = sh.getRow(1);
		String campname = rw.getCell(2).toString();
		System.out.println(campname);
		String target = rw.getCell(3).toString();
		System.out.println(target);
		
		
		
		
		
		
		
	
		
		
		Random randcount = new Random();
		int rand = randcount.nextInt(1000);
		
		//expected close date
		Date date = new Date();
		SimpleDateFormat simple= new SimpleDateFormat("dd-MM-yyy");
		simple.format(date);
		Calendar cal = simple.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String daterequired = simple.format(cal.getTime());
		
		
		//create Campaign
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(campname+rand);
		WebElement target1 = driver.findElement(By.name("targetSize"));
		target1.clear();
		target1.sendKeys(target);
		driver.findElement(By.name("campaignStatus")).sendKeys("Pending");
		
	WebElement EXPECTEDCLOSEDATE = driver.findElement(By.name("expectedCloseDate"));
	Actions act = new Actions(driver);
	act.click(EXPECTEDCLOSEDATE).sendKeys(daterequired).perform();
	
	
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//validation
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		if(msg.contains(campname) ){
			System.out.println("Campaign is created succcessfully");
			
		}
		else {
			System.out.println("not created");
		
		}
  driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		WebElement mousehauver = driver.findElement(By.xpath("//div[@class='user-icon']"));
		act.moveToElement(mousehauver).perform();
	WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		
		act.moveToElement(logout).click().perform();
		driver.quit();

	}




	}


