package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class dependsOn {
	
	@Test
	public void addCart() {
		Reporter.log("add cart",true);
	}
	@Test(dependsOnMethods = "addCart")
	public void editCart() {
		Reporter.log("edit cart",true);
	}
	@Test(dependsOnMethods = {"addCart","editCart"})
	public void delCart() {
		Reporter.log("del cart",true);
	}
	
	
}
