package com.nymgo.tests.pages.nymgo.menu.buyCredit.adyen;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.adyen.PendingTransactionAdyen3DSFragment;
import com.nymgo.tests.pages.nymgo.transactions.PendingTransactionPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Nov 11, 2015
 */
public class PendingTransactionAdyen3DSPage extends PendingTransactionPage{

	private PendingTransactionAdyen3DSFragment pendingTransactionAdyen3DSFragment;

	public PendingTransactionAdyen3DSPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		pendingTransactionAdyen3DSFragment = new PendingTransactionAdyen3DSFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_PENDING_ADYEN_NAME_ENG = "BuyCreditConfirmPagePendingAdyen"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_PENDING_ADYEN_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return pendingTransactionAdyen3DSFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return pendingTransactionAdyen3DSFragment.getCorrectURL();
	}
}
