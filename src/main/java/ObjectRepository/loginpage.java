package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver driver;
	public loginpage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}
	
	
	@FindAll({@FindBy(id="username"),@FindBy(name="username")})
	private WebElement UN;
	
	@FindBy(id="inputPassword")
	private WebElement PSW;
	
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement Login;

	public WebElement getUN() {
		return UN;
	}

	public void setUN(WebElement uN) {
		UN = uN;
	}

	public WebElement getPSW() {
		return PSW;
	}

	public void setPSW(WebElement pSW) {
		PSW = pSW;
	}

	public WebElement getLogin() {
		return Login;
	}

	public void setLogin(WebElement login) {
		Login = login;
	}
	

	
	

}
