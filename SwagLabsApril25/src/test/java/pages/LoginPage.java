package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
		
	}
	
	//Page Elements
	
	@FindBy(id="user-name")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="login-button")
	private WebElement loginBtn;
	
	
	
	
	//Page Actions
	
	public void enterUserName(String name) {
		username.sendKeys(name);	
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}

}
