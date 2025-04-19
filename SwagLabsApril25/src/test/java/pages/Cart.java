package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	WebDriver driver;
	public Cart(WebDriver dr){
		PageFactory.initElements(dr, this);
		this.driver = dr;
		
	}
	
	//Page Elements
	@FindBy(className="cart_item")
	private List<WebElement> items;
	
	@FindBy(xpath = "//button[@name = \"checkout\"]")
	private WebElement checkOutBtn;
	
	public int getItemsLength() {
		return items.size();
	}
	
	
// Page Action
	
	public void clickCheckOutBtn() {
		checkOutBtn.click();
	}

}
