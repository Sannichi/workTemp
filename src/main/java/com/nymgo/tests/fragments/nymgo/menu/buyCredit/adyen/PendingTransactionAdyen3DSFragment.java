package com.nymgo.tests.fragments.nymgo.menu.buyCredit.adyen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.transactions.PendingTransactionFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Nov 12, 2015
 */
public class PendingTransactionAdyen3DSFragment extends PendingTransactionFragment{

	public PendingTransactionAdyen3DSFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	private static final String BUY_CREDIT_CONFIRM_PAGE_ADYEN_3DS_PENDING_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) + 
//	private static final String BUY_CREDIT_CONFIRM_PAGE_ADYEN_3DS_PENDING_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL).replace("http", "https") + 
	private static final String BUY_CREDIT_CONFIRM_PAGE_ADYEN_3DS_PENDING_URL = Starter.SECURE_PART + 
//			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/adyen3ds-return/";
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/generate";			
	
	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlContains(BUY_CREDIT_CONFIRM_PAGE_ADYEN_3DS_PENDING_URL));    	
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_ADYEN_3DS_PENDING_URL;
	}

}
