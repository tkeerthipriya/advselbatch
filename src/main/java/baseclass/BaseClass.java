package baseclass;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import GenericUtilities.PropertiesUtility;
import GenericUtilities.webDriverutility;
import ObjectRepository.homepage;
import ObjectRepository.loginpage;

public class BaseClass {
public	WebDriver driver=null;
public static WebDriver sdriver=null;//listeners
	public PropertiesUtility putil= new PropertiesUtility();
	public webDriverutility wutil= new webDriverutility();
	

@BeforeSuite(groups = {"smoke","regression"})
public void databaseO() {
	System.out.println("DB Connectivity Open");
}
//@Parameters("BROWSER1")
@BeforeClass(groups = {"smoke","regression"})
public void launchBrowser() throws IOException {
	//String BROWSER1 = BROWSER;
	
	String BROWSER = putil.togetDataFromPropertiesFile("Browser");
	
	if (BROWSER.equals("Edge")) {
		 driver=new EdgeDriver();
	}
	else if(BROWSER.equals("Chrome")) {
		 driver=new ChromeDriver();
	}
	else if (BROWSER.equals("Firefox")) {
	 driver= new FirefoxDriver();
	}
	sdriver=driver;
	System.out.println("launch Browser");
}
@BeforeMethod(groups = {"smoke","regression"})
public void loginDetails() throws IOException {
	String URL = putil.togetDataFromPropertiesFile("URL");
	String UN = putil.togetDataFromPropertiesFile("UN");
	String PSW = putil.togetDataFromPropertiesFile("PSW");
	driver.manage().window().maximize();
	wutil.togetWaitForPageLoad(driver);
	driver.get(URL);
	loginpage lp=new loginpage(driver);
	lp.getUN().sendKeys(UN);
	lp.getPSW().sendKeys(PSW);
	lp.getLogin().click();
	System.out.println("Login");
}
@AfterMethod(groups = {"smoke","regression"})
public void logoutAction() {
	homepage hp= new homepage(driver);
	WebElement mousehauver = hp.getLogout();
	wutil.mouseHoverActions(driver, mousehauver);
WebElement logout = hp.getLogout();
	
wutil.mouseHoverActionsClickOn(driver, logout);
	
	System.out.println("LogOut");

}
@AfterClass(groups = {"smoke","regression"})
public void closeBrowse() {
	driver.quit();
	System.out.println("Close Browser");
}
@AfterSuite(groups = {"smoke","regression"})
public void dbClose() {
	System.out.println("DB Connectivity Close");
}
	

}
