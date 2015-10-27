package nymgoAutomation.tests.fragments.nymgo.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResellerAccountPageFragment extends BaseAccountPageFragment{
	
    public ResellerAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

    @FindBy(xpath = "//div[@id='account-details']/a[@class='button-edit']")
	private WebElement accountDetailsButton;

	public void clickViewAccountDetailsButton(){
		
		clickSubmitButton(accountDetailsButton);
	}
}
