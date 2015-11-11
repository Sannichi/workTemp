package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.adyen;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.base.BaseIframePageFragment;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */

public class BuyCredit3DSConfirmPageAdyenFragment extends BaseIframePageFragment{
	
	public BuyCredit3DSConfirmPageAdyenFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static final String BUY_CREDIT_3DS_PAGE_CONFIRM_ADYEN_URL = "https://test.adyen.com/hpp/3d/validate.shtml";
	
	@FindBy(css = "input[id='username']")
	private WebElement usernameField;
	
	@FindBy(css = "input[id='password']")
	private WebElement passwordField;
	
	@FindBy(css = "input[class='button']")
	private WebElement submitButton;
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlToBe(BUY_CREDIT_3DS_PAGE_CONFIRM_ADYEN_URL));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_3DS_PAGE_CONFIRM_ADYEN_URL;
	}

	public void setUsername(String username){
		
		setTextToEditField(usernameField, username);
	}
	
	public void setPassword(String password){
		
		setTextToEditField(passwordField, password);
	}

	public void clickSubmitButton(){
		
		clickInputButton(submitButton);
	}

}
