package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertiesUtility;
import GenericUtilities.javaUtilityFile;
import GenericUtilities.webDriverutility;
import ObjectRepository.campaignpage;
import ObjectRepository.homepage;
import ObjectRepository.loginpage;
import baseclass.BaseClass;

public class implementCreateCampaignWithExpectedClosureDate extends BaseClass {
@Test
	public void toCreateCampaignwithExpectedDate() throws  IOException{
		// TODO Auto-generated method stub
		PropertiesUtility putil= new PropertiesUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		javaUtilityFile jutil=new javaUtilityFile();
		webDriverutility wutil= new webDriverutility();
		String campname = eutil.togetDataFromExcelFile("Sheet2", 1, 2);
		System.out.println(campname);
		String size = eutil.togetDataFromExcelFile("Sheet2", 1, 3);
		System.out.println(size);	
		String status = eutil.togetDataFromExcelFile("Sheet2", 1, 4);
		System.out.println(status);
		
		//expected close date
		String daterequired = jutil.togetExpectedCloseDate(30);
		//create Campaign
		campaignpage cp=new campaignpage(driver);
		 homepage hp= new homepage(driver);
		 hp.getCreateCampaign().click();
		cp.getCampname().sendKeys(campname);
		cp.getSize().sendKeys(size);
		cp.getStatus().sendKeys(status);
		
		
	WebElement EXPECTEDCLOSEDATE = cp.getExpecteddate();
	wutil.passInputActions(driver, EXPECTEDCLOSEDATE, daterequired);
	
		
	cp.getButton().click();
		//validation
		WebElement toastmsg = cp.getToastmsg();
		wutil.waitForVisibilityOfElements(driver, toastmsg);
		String msg = toastmsg.getText();
		if(msg.contains(campname) ){
			System.out.println("Campaign is created succcessfully");
			
		}
		else {
			System.out.println("not created");
		
		}

 cp.getClosemsg().click();


	}
		
	}

