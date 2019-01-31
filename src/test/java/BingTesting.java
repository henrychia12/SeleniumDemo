import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BingTesting {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Ignore
	@Test
	public void bingSearch() throws InterruptedException {
		driver.get(Constants.URL);
		BingLandingPage bingLandingPage = PageFactory.initElements(driver, BingLandingPage.class);
		bingLandingPage.searchBing("selenium");

		BingSearchPage bingSearchPage = PageFactory.initElements(driver, BingSearchPage.class);
		assertEquals("Selenium not found", "Selenium", bingSearchPage.getSearch());
	}


	@Ignore
	@Test
	public void drawName() throws InterruptedException {
		driver.get("https://www.youidraw.com/apps/painter/");

		Actions action = new Actions(driver);
		action.moveByOffset(300, 500).clickAndHold().moveByOffset(0, 150).moveByOffset(0, -75).moveByOffset(75, 0).moveByOffset(0, 75).release().perform();
		action.moveByOffset(100, 0).clickAndHold().moveByOffset(0, 150).moveByOffset(0, -75).moveByOffset(75, 0).moveByOffset(0, 75).release().perform();
		Thread.sleep(10000);
	}
	
	@Ignore
	@Test
	public void implicitWait() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://christophperrins.github.io/TestingSite/");
		WebElement myDynamicElement = driver.findElement(By.xpath("//*[@id=\"quote\"]/h2"));
		assertEquals("Found you", "-The Shafeeq", myDynamicElement.getText());
		Thread.sleep(2000);
	}
	
	@Ignore
	@Test
	public void explicitWait() throws InterruptedException {
		driver.get("https://christophperrins.github.io/TestingSite/");
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"quote\"]/h2")));
		assertEquals("-The Shafeeq", myDynamicElement.getText());
		Thread.sleep(2000);
	}

}