package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviders {
	
	
	
	@Test(dataProvider = "loginDetails")
		public void login(String FN,String LN) {
			System.out.println(FN+" "+LN);
		}
	@DataProvider
	public Object[][] loginDetails() {
		Object[][] objarr= new Object[3][2];
		
		objarr[0][0]="john";
		objarr[0][1]="jruth";
		objarr[1][0]="keelu";
		objarr[1][1]="priya";
		objarr[2][0]="venu";
		objarr[2][1]="vidhya";
		
		return objarr;
		
	}
	

}
