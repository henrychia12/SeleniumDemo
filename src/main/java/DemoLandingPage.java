import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoLandingPage {
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	private WebElement userbox;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	private WebElement passbox;
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addUserLink;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	private WebElement saveButton;
	
	
	
	public void usernameEnter(String searchText) {
		userbox.sendKeys(searchText);
	}
	
	public void passwordEnter (String searchText) {
		passbox.sendKeys(searchText);
	}
	
	public void selectAddUser() {
		addUserLink.click();
	}
	
	public void saveButton() {
		saveButton.click();
	}
	

}