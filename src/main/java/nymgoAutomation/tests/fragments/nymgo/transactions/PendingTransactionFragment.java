package nymgoAutomation.tests.fragments.nymgo.transactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by Iuliia Khikmatova on Oct 23, 2015
 */
public class PendingTransactionFragment extends BaseIframeTransactionFragment{

	public PendingTransactionFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(className = "button-normal")
	private WebElement backToDashboardButton;

	public void clickBackToDashboardButton(){
		
		clickButton(backToDashboardButton);
	}
}
