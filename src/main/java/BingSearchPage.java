import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class BingSearchPage {
	
	@FindBy(xpath = "//*[@id=\"b_context\"]/li[1]/div/div[1]/h2")
	private WebElement softwareText;
	
	public String getSearch() {
		return softwareText.getText();
	}

}
