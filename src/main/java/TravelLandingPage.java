import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelLandingPage {
	
	@FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
	private WebElement searchbox;
	
	public void searchItem(String searchText) {
		searchbox.sendKeys(searchText);
	}

}

