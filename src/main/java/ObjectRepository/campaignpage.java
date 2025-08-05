package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class campaignpage {
	
	WebDriver driver;
	public campaignpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(name = "campaignName")
	private WebElement campname;
	@FindBy(name = "campaignStatus")
	private WebElement status;
	@FindBy(name = "targetSize")
	private WebElement size;
	@FindBy(name = "expectedCloseDate")
	private WebElement expecteddate;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement button;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement toastmsg;
	@FindBy(xpath="//button[@aria-label='close']")
	private WebElement closemsg;
	public WebElement getCampname() {
		return campname;
	}
	public WebElement getStatus() {
		return status;
	}
	public WebElement getSize() {
		return size;
	}
	public WebElement getExpecteddate() {
		return expecteddate;
	}
	public WebElement getButton() {
		return button;
	}
	public WebElement getToastmsg() {
		return toastmsg;
	}
	public WebElement getClosemsg() {
		return closemsg;
	}
	
	
	
}
