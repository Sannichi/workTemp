package com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.worldpay.PendingTransactionWorldpayFragment;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.base.transactions.PendingTransactionPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class PendingTransactionWorldpayPage extends PendingTransactionPage{

	private PendingTransactionWorldpayFragment pendingTransactionWorldpayFragment;

	public PendingTransactionWorldpayPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		pendingTransactionWorldpayFragment = new PendingTransactionWorldpayFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_PENDING_WP_NAME_ENG = "BuyCreditConfirmPagePendingWorldpay"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_PENDING_WP_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return pendingTransactionWorldpayFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return pendingTransactionWorldpayFragment.getCorrectURL();
	}
}
