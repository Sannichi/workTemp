package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.BaseIframePageFragment;
import com.nymgo.tests.starter.Starter;

public class BuyCreditConfirmPageCancelledFragment extends BaseIframePageFragment{

	public BuyCreditConfirmPageCancelledFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_CANCELLED_URL = "https://eu.gcsip.nl/orb/orb?ACTION=DO_START&REF=";	

	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlContains(BUY_CREDIT_CONFIRM_PAGE_CANCELLED_URL));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_CANCELLED_URL;
	}

}
