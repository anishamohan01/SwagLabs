package testcases;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Cart;
import pages.Checkout;
import pages.CheckoutOverview;
import pages.LoginPage;
import pages.Products;

public class Shopping {
	
	WebDriver driver;
	Cart cart;
	
	@BeforeClass
	public void beforeClass() {
		driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));	
	}
	
	
	@AfterTest()
	public void afterTest() {
		driver.quit();
	}
	
	
	@Test
	public void tc1_testLogin() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName("standard_user");
		lp.enterPassword("secret_sauce");
		lp.clickLoginBtn();
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("/inventory.html"), "Did not navigate to Inventory page");
	}
	
	@Test()
	public void tc2_addToCart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Products p = new Products(driver);
		Assert.assertEquals(p.getButtonText(), "Add to cart");
		p.clickAddToCartBtn();
		Assert.assertEquals(p.getButtonText(), "Remove");
		p.clickCartLink();
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("/cart.html"), "Not Applicable");
		cart = new Cart(driver);
		Assert.assertEquals(cart.getItemsLength(), 1);
	}
	
	@Test()
	public void tc3_checkOut() {
		cart.clickCheckOutBtn();
		Checkout checkout = new Checkout(driver);
		checkout.enterFirstName("Anisha");
		checkout.enterLastName("Verkot Mohan");
		checkout.enterPostalCode("k3y2r6");
		checkout.clickContinueBtn();
		CheckoutOverview overview = new CheckoutOverview(driver);
		String title = overview.checkTitle();
		Assert.assertEquals(title, "Checkout: Overview");
	}

}
