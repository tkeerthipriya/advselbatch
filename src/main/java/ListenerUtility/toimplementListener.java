package ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseclass.BaseClass;

public class toimplementListener implements ISuiteListener,ITestListener{
	
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "==="+result.getMethod().getMethodName()+"Execution Started===");
		//Reporter.log("==="+result.getMethod().getMethodName()+"Execution Started===", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "==="+result.getMethod().getMethodName()+"Success===");
		//Reporter.log("==="+result.getMethod().getMethodName()+"Success===", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		String testname = result.getMethod().getMethodName();
		//Reporter.log("===="+testname+"Failed", true);
		Date d=new Date();
		String newDate = d.toString().replace(" ","_").replace(":", "_");
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		 String temp = ts.getScreenshotAs(OutputType.BASE64);
		/*File perm=new File("./errorshots/"+testname+" "+newDate+".png");
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 test.addScreenCaptureFromBase64String(temp,testname+newDate);
		 test.log(Status.FAIL,"===="+testname+"Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "==="+result.getMethod().getMethodName()+"Skipped===");
		//Reporter.log("==="+result.getMethod().getMethodName()+"Skipped===", true);
	}

	@Override
	public void onStart(ISuite suite) {
		Date d=new Date();
		String newDate = d.toString().replace(" ","_").replace(":", "_");
		
		 spark=new ExtentSparkReporter("./AdvanceReports/report_"+newDate+".html");
		spark.config().setDocumentTitle("NinzaCRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows10");
		report.setSystemInfo("Browser", "Edge");
		
		
		
		
		Reporter.log("Report Configuration", true);
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		
		Reporter.log("Report Backup", true);
	}
	

}
