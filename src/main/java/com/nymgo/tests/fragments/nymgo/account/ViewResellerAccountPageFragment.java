package com.nymgo.tests.fragments.nymgo.account;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public class ViewResellerAccountPageFragment extends BaseViewAccountFragment{
	
    public ViewResellerAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String VIEW_RESELLER_ACCOUNT_PAGE_URL = Starter.SECURE_PART +    
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/account/account-details/account-profile";

	@Override
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlToBe(VIEW_RESELLER_ACCOUNT_PAGE_URL));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}
    
	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return VIEW_RESELLER_ACCOUNT_PAGE_URL;
	}
	
}
