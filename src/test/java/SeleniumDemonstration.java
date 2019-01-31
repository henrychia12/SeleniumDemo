

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumDemonstration {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("phantomjs.binary.path", Constants.phantomJS);
		driver = new PhantomJSDriver();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	

	@Test
	public void openRunescapeTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://www.bing.com");
		WebElement textbox = driver.findElement(By.name("q"));
		textbox.sendKeys("runescape");
		textbox.submit();
		WebElement sele = driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[1]/h2/a"));
		sele.click();
		Thread.sleep(3000);
//		assertEquals("Runescape Text not found", true, sele.getText().indexOf("RuneScape")!=-1);
	}
	

	@Test
	public void demoSiteTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/");
		WebElement clickAddUser = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		clickAddUser.click();
		WebElement userTextBox = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		userTextBox.sendKeys("hello motto");
		WebElement passTextBox = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		passTextBox.sendKeys("password");
		WebElement saveButton = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		saveButton.click();
		WebElement clickLogin = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		clickLogin.click();
		WebElement logInUserTextBox =driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		logInUserTextBox.sendKeys("hello motto");
		WebElement logInPasstextBox = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		logInPasstextBox.sendKeys("password");
		WebElement testLogInButton = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		testLogInButton.click();
		WebElement successfulLogin = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("Log in unsuccessful", "**Successful Login**", successfulLogin.getText());
		Thread.sleep(3000);
	}
	

	@Test
	public void automationPracticeTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		WebElement dressesNavBar = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
		dressesNavBar.click();
		WebElement printedDressText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
//		printedDressText.click();
		assertEquals("No item found", "Printed Dress", printedDressText.getText());
		Thread.sleep(3000);
	}
	
	@Test
	public void automationPracticeTestTwo() throws InterruptedException {
		driver.get(Constants.shoppingURL);
		ShoppingLandingPage shoppingLandingPage = PageFactory.initElements(driver, ShoppingLandingPage.class);
		shoppingLandingPage.searchItem("dresses");
		
		ShoppingSearchPage shoppingSearchPage = PageFactory.initElements(driver, ShoppingSearchPage.class);
		assertEquals("item not found", "Printed Summer Dress", shoppingSearchPage.getSearch());
	}
	
	@Ignore
	@Test
	public void travelTest() throws InterruptedException {
		driver.get(Constants.shoppingURL);
		TravelLandingPage travelLandingPage = PageFactory.initElements(driver, TravelLandingPage.class);
		travelLandingPage.searchItem("london");
		
	}
	
}