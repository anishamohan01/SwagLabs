package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {

	WebDriver driver;

	public Products(WebDriver dr) {
		PageFactory.initElements(dr, this);
		driver = dr;
	}

	// Page elements

	@FindBy(id = "item_4_title_link")
	private WebElement product1;

	@FindBy(xpath = "//*[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item_description']//button")
	private WebElement addToCartbtn;

	@FindBy(id = "item_4_title_link")
	private WebElement backPack;

	@FindBy(xpath = "//a[@data-test='shopping-cart-link']")
	private WebElement cart;

	// Page Actions

	public void clickBackpack() {
		backPack.click();
	}

	public void clickAddToCartBtn() {
		addToCartbtn.click();
	}

	public String getButtonText() {
		return addToCartbtn.getText();
	}

	public void clickCartLink() {
		cart.click();
	}

}
