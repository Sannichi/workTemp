package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.globalCollect;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.BROWSERS;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.PROPERTIES;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.transactions.PendingIframeTransactionFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;
/**
 * Created by Iuliia Khikmatova on Feb 8, 2016
 */
public class SuccessfulTransactionGlobalCollectFragment extends PendingIframeTransactionFragment{

	public SuccessfulTransactionGlobalCollectFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_GC_SUCCESSFUL_CHROME_URL = "https://secure-dev.nymgo.com/gcreturn?REF=";	
	private static final String BUY_CREDIT_CONFIRM_PAGE_GC_SUCCESSFUL_URL = Starter.SECURE_PART + 
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/generate";	

	private String defineCorrectURL(){
		BROWSERS BROWSER = BROWSERS.valueOf(Starter.PROPS.getProperty(PROPERTIES.BROWSER.name()));
        switch (BROWSER)
        {
            case FIREFOX:
                return BUY_CREDIT_CONFIRM_PAGE_GC_SUCCESSFUL_URL;
            case CHROME:
                return BUY_CREDIT_CONFIRM_PAGE_GC_SUCCESSFUL_CHROME_URL;
            case IE:
                return BUY_CREDIT_CONFIRM_PAGE_GC_SUCCESSFUL_URL;
            default:
                return BUY_CREDIT_CONFIRM_PAGE_GC_SUCCESSFUL_URL;
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
