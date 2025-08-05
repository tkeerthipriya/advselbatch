package campaign;

import java.io.IOException;


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
import baseclass.BaseClass;
//@Listeners(ListenerUtility.toimplementListener.class)
public class campaignTest extends BaseClass {
	@Test(groups = "regression")
	public void toCreateCampaignwithMAndatoryFieldsTest() throws IOException{
		
		
		PropertiesUtility putil= new PropertiesUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		javaUtilityFile jutil=new javaUtilityFile();
		webDriverutility wutil= new webDriverutility();
		//actual script
		String campname = eutil.togetDataFromExcelFile("Sheet2", 1, 2);
		System.out.println(campname);
		String size = eutil.togetDataFromExcelFile("Sheet2", 1, 3);
		System.out.println(size);
		String status = eutil.togetDataFromExcelFile("Sheet2", 1, 4);
		System.out.println(status);
		//create Campaign
		homepage hp=new homepage(driver);
		hp.getCampaign();
				campaignpage cp=new campaignpage(driver);
			hp.getCreateCampaign().click();
			cp.getCampname().sendKeys(campname);
			cp.getSize().sendKeys(size);
			cp.getStatus().sendKeys(status);
			cp.getButton().click();
							
			//validation
		WebElement toastmsg = cp.getToastmsg();
	  wutil.waitForVisibilityOfElements(driver, toastmsg);
		String msg = toastmsg.getText();
		Assert.assertTrue(msg.contains(campname));
 cp.getClosemsg().click();
		
	}

	@Test(groups = "smoke")
	public void toCreateCampaignwithExpectedDateTest() throws  IOException{
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
		Assert.assertTrue(msg.contains(campname));

 cp.getClosemsg().click();


	}
	
}





