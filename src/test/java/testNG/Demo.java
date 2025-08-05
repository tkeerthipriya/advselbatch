package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo {
	@Test
	public void a11() {
		Reporter.log("a11 executed",true);
	}
	@Test
	public void a23() {
		Reporter.log("a23 executed",true);
	}
	@Test
	public void b24() {
		Reporter.log("b24 executed",true);
	}
	@Test
	public void b26() {
		Reporter.log("b26 executed",true);
	}
	@Test
	public void a18() {
		Reporter.log("a18 executed",true);
	}


}
