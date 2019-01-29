

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemonstration {
	
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
	public void testOne() throws InterruptedException {
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
	
	

}