package Product;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertiesUtility;
import GenericUtilities.javaUtilityFile;
import GenericUtilities.webDriverutility;
import ObjectRepository.campaignpage;
import ObjectRepository.homepage;
import ObjectRepository.productpage;
import baseclass.BaseClass;
//@Listeners(ListenerUtility.toimplementListener.class)
public class productTest extends BaseClass {
	@Test(groups = "smoke")
	
	public  void createproductTest() throws EncryptedDocumentException, IOException {
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
Assert.assertTrue(msg.contains(p1));

cp.getClosemsg().click();

//logout

	}



}
