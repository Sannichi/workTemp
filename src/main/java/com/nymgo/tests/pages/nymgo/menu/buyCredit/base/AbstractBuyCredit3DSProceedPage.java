package com.nymgo.tests.pages.nymgo.menu.buyCredit.base;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.base.BaseBuyCredit3DSProceedPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPageCancelled;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
//for Adyen and Worldpay payments
public abstract class AbstractBuyCredit3DSProceedPage extends AbstractLoggedInPage{
	
	private BaseBuyCredit3DSProceedPageFragment baseBuyCredit3DSProceedPageFragment;

	public AbstractBuyCredit3DSProceedPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseBuyCredit3DSProceedPageFragment = new BaseBuyCredit3DSProceedPageFragment(driver);
	}
/*
	private static final String BUY_CREDIT_3DS_PROCEED_PAGE_NAME_ENG = "BuyCreditProceedAdyenPage"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_3DS_PROCEED_PAGE_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return baseBuyCredit3DSProceedPageFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return baseBuyCredit3DSProceedPageFragment.getCorrectURL();
	}
*/
	protected void clickPayButton(){
		
		baseBuyCredit3DSProceedPageFragment.clickPayButton();
	}
	
	protected void clickCancelButton(){
		
		baseBuyCredit3DSProceedPageFragment.clickCancelButton();
	}
	
	protected void setSaveCardCheckbox(){
		
		baseBuyCredit3DSProceedPageFragment.setSaveCardCheckbox();
	}
	
	public AbstractBuyCredit3DSProceedPage checkSavedCard(){
		
		baseBuyCredit3DSProceedPageFragment.checkSavedCard();
		return this;
	}

	public AbstractBuyCredit3DSProceedPage clickAddNewCard(){
		
		baseBuyCredit3DSProceedPageFragment.clickAddNewCard();
		return this;
	}

	public BuyCreditConfirmPageCancelled setCreditCardDataAndClickCancel(String cardNumberValue, String expireDateMonth, String expireDateYear, String cvvValue){
		
/*		setCardNumber(cardNumberValue);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
*/
		clickCancelButton();
		BuyCreditConfirmPageCancelled buyCreditConfirmPageCancelled = new BuyCreditConfirmPageCancelled(starter);
		PageNavigation<BuyCreditConfirmPageCancelled> navigation = new PageNavigation<BuyCreditConfirmPageCancelled>(buyCreditConfirmPageCancelled);
		navigation.NavigatedTo();
		return buyCreditConfirmPageCancelled;
	}
}
