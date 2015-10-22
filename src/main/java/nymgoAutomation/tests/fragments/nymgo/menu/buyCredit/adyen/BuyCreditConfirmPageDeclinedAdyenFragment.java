package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.adyen;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.fragments.HasURL;
import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.base.BaseTransactionFragment;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public class BuyCreditConfirmPageDeclinedAdyenFragment extends BaseTransactionFragment implements HasURL{

	public BuyCreditConfirmPageDeclinedAdyenFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_CANCELLED_ADYEN_URL = "https://secure-dev.nymgo.com/en/generate";	

	@Override
	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	try{
    		wait.until(ExpectedConditions.urlContains(BUY_CREDIT_CONFIRM_PAGE_CANCELLED_ADYEN_URL));
    		return true;
    	}
    	catch(TimeoutException e){
    		return false;
    	}
	}

	@FindBy(className = "button-normal")
	private WebElement tryAgainButton;

	public void clickTryAgainButton(){
		
		clickButton(tryAgainButton);
	}

	public boolean isTransactionDeclined(){
		
		return getPaymentStatus().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.PAYMENT_DECLINED));
	}
}
