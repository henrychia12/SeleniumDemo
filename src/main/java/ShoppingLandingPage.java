import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingLandingPage {
	
	@FindBy(xpath = "//*[@id=\"search_query_top\"]")
	private WebElement searchbox;
	
	public void searchItem(String searchText) {
		searchbox.sendKeys(searchText);
		searchbox.submit();
	}

}
