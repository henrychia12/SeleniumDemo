import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

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
	
	@Test
	public void bingSearch() throws InterruptedException{
		driver.get(Constants.URL);
		BingLandingPage bingLandingPage = PageFactory.initElements(driver, BingLandingPage.class);
		bingLandingPage.searchBing("selenium");
		
		BingSearchPage bingSearchPage = PageFactory.initElements(driver, BingSearchPage.class);
		assertEquals("Selenium not found", "Selenium", bingSearchPage.getSearch());
	}

}