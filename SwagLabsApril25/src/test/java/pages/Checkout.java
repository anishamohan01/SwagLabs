package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
	
	WebDriver driver;
	public Checkout(WebDriver dr) {
		PageFactory.initElements(dr, this);
		this.driver = dr;
	}
	
	// Page Elements
	
	@FindBy(id="first-name")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement lastName;
	
	@FindBy(name="postalCode")
	private WebElement postalCode;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continueBtn;
	
	
	// Page Actions
	
	public void enterFirstName() {
		firstName.sendKeys("Anisha");	
	}
	
	public void enterLastName() {
		lastName.sendKeys("Verkot Mohan");
	}
	
	public void enterPostalCode() {
		postalCode.sendKeys("N3T3R6");
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}

}
