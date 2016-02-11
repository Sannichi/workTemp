package com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.adyen.DeclinedTransactionAdyenFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.BuyCreditPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.base.transactions.DeclinedTransactionPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class DeclinedTransactionAdyenPage extends DeclinedTransactionPage{

	private DeclinedTransactionAdyenFragment declinedTransactionAdyenFragment;
	
	public DeclinedTransactionAdyenPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		declinedTransactionAdyenFragment = new DeclinedTransactionAdyenFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_CANCELLED_ADYEN_NAME_ENG = "BuyCreditConfirmPageCancelledAdyen"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_CANCELLED_ADYEN_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return declinedTransactionAdyenFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return declinedTransactionAdyenFragment.getCorrectURL();
	}

	private void clickTryAgainButton(){
		
		declinedTransactionAdyenFragment.clickTryAgainButton();
	}

	public BuyCreditPage clickTryAgainBuyCreditButton(){
		
		clickTryAgainButton();
		BuyCreditPage buyCreditPage = new BuyCreditPage(starter);
		PageNavigation<BuyCreditPage> navigation = new PageNavigation<BuyCreditPage>(buyCreditPage);
		navigation.NavigatedTo();
		return buyCreditPage;
		
	}
}
