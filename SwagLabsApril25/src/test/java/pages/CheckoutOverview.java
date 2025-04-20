package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverview {
	
	WebDriver driver;
	public CheckoutOverview(WebDriver dr) {
		PageFactory.initElements(dr, this);
		this.driver = dr;
	}
	
	// Page Elements
	
	@FindBy(xpath = "//span[@data-test='title']")
	private WebElement title;
	
	// Page Actions
	
	public String checkTitle() {
		return title.getText();
	}
	
	
	
	

}
