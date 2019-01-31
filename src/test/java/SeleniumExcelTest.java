
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class SeleniumExcelTest {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",Constants.WebDriverLocation);
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Ignore
	@Test
	public void logInTest() throws Exception {
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Desktop\\DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		for (int rowNum = 0; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
			for (int colNum = 0; colNum < sheet.getRow(rowNum).getPhysicalNumberOfCells(); colNum++) {
				XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
				String userCell = cell.getStringCellValue();
				System.out.println(userCell);
			}
		}
		
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(1);
		if (cell == null) {
			cell = row.createCell(1);
		}
		cell.setCellValue("hello");
		
	
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Desktop\\DemoSiteDDT.xlsx");

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
		
		file.close();		
	}
	
	@Test
	public void enterUserTest() throws InterruptedException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Desktop\\DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		driver.get(Constants.demoURL);
		DemoLandingPage demoLandingPage = PageFactory.initElements(driver, DemoLandingPage.class);
		
		demoLandingPage.selectAddUser();

		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {

				
				driver.findElement(By.name("username")).sendKeys(sheet.getRow(rowNum).getCell(0).getStringCellValue());
				driver.findElement(By.name("password")).sendKeys(sheet.getRow(rowNum).getCell(1).getStringCellValue());
				driver.findElement(By.name("FormsButton2")).click();
				Thread.sleep(1000);
			}
		}
		

		
		
//		demoLandingPage.selectAddUser();
//		demoLandingPage.usernameEnter("TestOne");
//		demoLandingPage.passwordEnter("PassOne");
//		demoLandingPage.saveButton();
//		Thread.sleep(3000);
		
	}

