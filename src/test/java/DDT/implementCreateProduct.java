package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertiesUtility;
import GenericUtilities.javaUtilityFile;
import GenericUtilities.webDriverutility;
import ObjectRepository.campaignpage;
import ObjectRepository.homepage;
import ObjectRepository.loginpage;
import ObjectRepository.productpage;
import baseclass.BaseClass;

public class implementCreateProduct extends BaseClass {
	@Test

	public  void createproduct() throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		PropertiesUtility putil= new PropertiesUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		javaUtilityFile jutil=new javaUtilityFile();
		webDriverutility wutil= new webDriverutility();
	
		//actual script
	String p1 = eutil.togetDataFromExcelFile("product", 1, 2);
		String q1 = eutil.togetDataFromExcelFile("product", 1, 3);
		String p12 = eutil.togetDataFromExcelFile("product", 1, 4);
		
		productpage pp=new productpage(driver);
		homepage hp= new homepage(driver);
		hp.getProductlink().click();
	hp.getCreateproduct().click();
		
		pp.getProductname().sendKeys(p1+jutil.togetRandonNumber());
		WebElement category = pp.getProdcat();
		wutil.selByVisibleText(category, "Others");

WebElement vendorid = pp.getVendorId();

wutil.selByValue(vendorid,"VID_001");
 WebElement price = pp.getPrice();
price.clear();
price.sendKeys(p12);

pp.getQuantity().sendKeys(q1);
pp.getButton().click();



//validation
campaignpage cp=new campaignpage(driver);
WebElement toastmsg = cp.getToastmsg();
wutil.waitForVisibilityOfElements(driver, toastmsg);
String msg = toastmsg.getText();
if(msg.contains(p1))
{
	System.out.println("product is successfully created");
}
else {
	System.out.println("product is not created");
	
}

cp.getClosemsg().click();

//logout

	}

}
