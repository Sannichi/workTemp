package nymgoAutomation.tests.fragments.nymgo.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iuliia Khikmatova on Oct 13, 2015
 */

public class NormalAccountPageFragment extends BaseAccountPageFragment{
	
    public NormalAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@class='view-profile']")
	private WebElement viewFullAccountButton;

	public void clickViewFullAccountButton(){
		
		clickSubmitButton(viewFullAccountButton);
	}

}
