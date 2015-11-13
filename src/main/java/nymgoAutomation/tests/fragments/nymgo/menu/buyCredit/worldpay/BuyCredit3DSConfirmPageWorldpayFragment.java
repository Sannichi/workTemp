package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.worldpay;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.base.BaseIframePageFragment;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Nov 13, 2015
 */
public class BuyCredit3DSConfirmPageWorldpayFragment extends BaseIframePageFragment{

	public BuyCredit3DSConfirmPageWorldpayFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	private static final String BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL = "https://secure-dev.nymgo.com/en/wp3ds-return/d0Vxd25rOW53Q0JNV0ZPUk1FNlQwQT09";	
	private static final String BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL = "https://secure-test.streamline-esolutions.com/jsp/test/shopper/ThreeDResponseSimulator.jsp";
	
	@FindBy(css = "input[name='continue']")
	private WebElement continueButton;

	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	try{
    		wait.until(ExpectedConditions.urlContains(BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL));
    		return true;
    	}
    	catch(TimeoutException e){
    		return false;
    	}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL;
	}

	public void clickContinueButton(){
		
		clickInputButton(continueButton);
	}
}