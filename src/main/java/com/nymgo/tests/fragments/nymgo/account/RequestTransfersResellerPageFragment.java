package com.nymgo.tests.fragments.nymgo.account;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseLoggedInFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Mar 31, 2016
 */
public class RequestTransfersResellerPageFragment extends BaseLoggedInFragment {

	public RequestTransfersResellerPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String REQUEST_TRANSFERS_RESELER_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +	
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/account/request-transfers";
	
	@FindBy(id = "amount-el")
	private WebElement requestAmountField; 
	
	@FindBy(id = "save-el")
	private WebElement requestTransferButton; 

	@Override
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlToBe(REQUEST_TRANSFERS_RESELER_PAGE_URL));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return REQUEST_TRANSFERS_RESELER_PAGE_URL;
	}

	public void setRequestAmountValue(String requestAmountValue){
		
		setTextToEditField(requestAmountField, requestAmountValue);
	}

	public void clickRequestTransfersButton(){
		
		clickInputButton(requestTransferButton);
	}

}
