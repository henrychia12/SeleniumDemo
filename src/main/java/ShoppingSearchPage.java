import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class ShoppingSearchPage {
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
	private WebElement softwareText;
	
	public String getSearch() {
		return softwareText.getText();
	}

}

