package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.adyen;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.transactions.PendingTransactionFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Nov 11, 2015
 */
public class PendingTransactionAdyenFragment extends PendingTransactionFragment{

	public PendingTransactionAdyenFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	private static final String BUY_CREDIT_CONFIRM_PAGE_ADYEN_PENDING_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) + 
	private static final String BUY_CREDIT_CONFIRM_PAGE_ADYEN_PENDING_URL = Starter.SECURE_PART +	
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/generate";
	
	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlMatches(BUY_CREDIT_CONFIRM_PAGE_ADYEN_PENDING_URL));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_ADYEN_PENDING_URL;
	}

}
