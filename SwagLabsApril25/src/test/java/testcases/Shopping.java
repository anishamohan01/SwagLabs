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
import pages.LoginPage;
import pages.Products;

public class Shopping {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
		driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));	
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	
	@AfterTest()
	public void afterTest() {
		System.out.println("afterTest");
//		driver.quit();
	}
	
	
	@Test
	public void testLogin() throws InterruptedException {
		System.out.println("testLogin");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName("standard_user");
		lp.enterPassword("secret_sauce");
		lp.clickLoginBtn();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("/inventory.html"), "Did not navigate to Inventory page");
	}
	
	@Test(priority=1)
	public void addToCart() {
		System.out.println("addToCart");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Products p = new Products(driver);
		Assert.assertEquals(p.getButtonText(), "Add to cart");
		p.clickAddToCartBtn();
		System.out.println(p.getButtonText());
		Assert.assertEquals(p.getButtonText(), "Remove");
		p.clickCartLink();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("/cart.html"), "Not Applicable");
		Cart c = new Cart(driver);
		Assert.assertEquals(c.getItemsLength(), 1);
	}
	

}
