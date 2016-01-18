package com.nymgo.tests.fragments.nymgo.menu.buyCredit.globalCollect;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.transactions.PendingIframeTransactionFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

public class PendingTransactionGlobalCollectFragment extends PendingIframeTransactionFragment{

	public PendingTransactionGlobalCollectFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	private static final String BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL = "https://secure-dev.nymgo.com/gcreturn?REF=";	
	private static final String BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL = Starter.SECURE_PART + 
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/generate";	

	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlContains(BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL));
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL;
	}

}
