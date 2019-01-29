import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingLandingPage {
	
	@FindBy(id = "sb_form_q")
	private WebElement searchbox;
	
	public void searchBing(String searchText) {
		searchbox.sendKeys(searchText);
		searchbox.submit();
	}

}
