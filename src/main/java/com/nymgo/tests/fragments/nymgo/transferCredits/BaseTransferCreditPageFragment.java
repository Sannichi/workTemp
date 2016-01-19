package com.nymgo.tests.fragments.nymgo.transferCredits;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.nymgo.base.LoggedNymgoPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 30, 2015
 */
public class BaseTransferCreditPageFragment extends LoggedNymgoPageFragment {

	public BaseTransferCreditPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String TRANSFER_CREDIT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/user/credits/transfer-credits";
	
	@Override
	public boolean isCorrectURL() {

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlToBe(TRANSFER_CREDIT_PAGE_URL));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	@Override
	public String getCorrectURL() {

		return TRANSFER_CREDIT_PAGE_URL;
	}
	
}
