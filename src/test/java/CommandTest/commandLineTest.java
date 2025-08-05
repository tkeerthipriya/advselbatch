package CommandTest;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class commandLineTest {
	@Test
	public void commandLineTest() {
		
		String url = System.getProperty("url");
		String userName = System.getProperty("UserName");
		String password = System.getProperty("Password");
		//Reporter.log(url+""+userName+" "+password);
		System.out.println(url+" "+userName+" "+password);
		
		
		
	}

}
