package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
	
	
	WebDriver driver;
	public homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(linkText="Campaigns")
	private WebElement campaign;
	
	@FindBy(linkText = "Products")
	private WebElement products;
	
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement createCampaign;
	
	@FindBy(xpath="//div[@class='user-icon']")
	private WebElement logout;
	
	@FindBy(linkText = "Products")
	private WebElement productlink;
	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement createproduct;
	
	

	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getCreateCampaign() {
		return createCampaign;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getProductlink() {
		return productlink;
	}

	public WebElement getCreateproduct() {
		return createproduct;
	}

	
	
	
	
}