package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.worldpay;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.BROWSERS;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.PROPERTIES;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.transactions.PendingTransactionFragment;
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

	private static final String PENDING_TRANSACTION_WP_3DS_CHROME_URL = "https://secure-dev.nymgo.com/en/wp3ds-return/";	
	private static final String PENDING_TRANSACTION_WP_3DS_URL = Starter.SECURE_PART + 
	LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/generate";	

	private String defineCorrectURL(){
		BROWSERS BROWSER = BROWSERS.valueOf(Starter.PROPS.getProperty(PROPERTIES.BROWSER.name()));
        switch (BROWSER)
        {
            case FIREFOX:
                return PENDING_TRANSACTION_WP_3DS_URL;
            case CHROME:
                return PENDING_TRANSACTION_WP_3DS_CHROME_URL;
            case IE:
                return PENDING_TRANSACTION_WP_3DS_URL;
            default:
                return PENDING_TRANSACTION_WP_3DS_URL;
        }
	}
	
	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	String correctURL = defineCorrectURL();
		try{
	    	wait.until(ExpectedConditions.urlContains(correctURL));			
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return defineCorrectURL();    	
	}

}
