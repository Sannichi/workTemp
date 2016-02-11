package com.nymgo.tests.fragments.nymgo.menu;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseNymgoFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

public class SupportPageFragment extends BaseNymgoFragment{
	
	public SupportPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String SUPPORT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/support/";
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlToBe(SUPPORT_PAGE_URL));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return SUPPORT_PAGE_URL;
	}
}
