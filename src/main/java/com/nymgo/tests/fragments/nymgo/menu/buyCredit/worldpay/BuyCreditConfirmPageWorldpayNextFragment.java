package com.nymgo.tests.fragments.nymgo.menu.buyCredit.worldpay;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.base.BaseIframePageFragment;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditConfirmPageWorldpayNextFragment extends BaseIframePageFragment{

	public BuyCreditConfirmPageWorldpayNextFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.IFRAME_WAIT_TIME);
    	wait.until(ExpectedConditions.visibilityOf(continueButton));
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_WP_NEXT_URL = "https://secure-test.streamline-esolutions.com/jsp/test/shopper/CardSTSimulator.jsp";	

	@FindBy(css = "input[name='continue']")
	private WebElement continueButton;

	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	try{
    		wait.until(ExpectedConditions.urlContains(BUY_CREDIT_CONFIRM_PAGE_WP_NEXT_URL));
    		return true;
    	}
    	catch(TimeoutException e){
    		return false;
    	}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_WP_NEXT_URL;
	}

	public void clickContinueButton(){
		
		clickInputButton(continueButton);
	}
}
