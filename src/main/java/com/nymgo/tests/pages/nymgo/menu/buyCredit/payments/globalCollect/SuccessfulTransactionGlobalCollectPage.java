package com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.globalCollect;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.globalCollect.SuccessfulTransactionGlobalCollectFragment;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.base.transactions.PendingIframeTransactionPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Feb 8, 2016
 */
public class SuccessfulTransactionGlobalCollectPage  extends PendingIframeTransactionPage{

	private SuccessfulTransactionGlobalCollectFragment successfulTransactionGlobalCollectFragment;
	
	public SuccessfulTransactionGlobalCollectPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		successfulTransactionGlobalCollectFragment = new SuccessfulTransactionGlobalCollectFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_PENDING_GC_NAME_ENG = "BuyCreditConfirmPagePendingGlobalCollect"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_PENDING_GC_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return successfulTransactionGlobalCollectFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return successfulTransactionGlobalCollectFragment.getCorrectURL();
	}
}