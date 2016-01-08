package com.nymgo.tests.fragments.nymgo.menu.buyCredit.worldpay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.transactions.PendingTransactionFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class PendingTransactionWorldpay3DSFragment extends PendingTransactionFragment{

	public PendingTransactionWorldpay3DSFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	private static final String PENDING_TRANSACTION_WP_3DS_URL = "https://secure-dev.nymgo.com/en/wp3ds-return/";	
	private static final String PENDING_TRANSACTION_WP_3DS_URL = Starter.SECURE_PART + 
	LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/generate";	

	
	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlContains(PENDING_TRANSACTION_WP_3DS_URL));
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return PENDING_TRANSACTION_WP_3DS_URL;
	}

}
