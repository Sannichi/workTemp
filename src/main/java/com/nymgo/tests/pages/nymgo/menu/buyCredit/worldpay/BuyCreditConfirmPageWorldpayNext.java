package com.nymgo.tests.pages.nymgo.menu.buyCredit.worldpay;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.worldpay.BuyCreditConfirmPageWorldpayNextFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.base.AbstractBuyCreditConfirmPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditConfirmPageWorldpayNext  extends AbstractBuyCreditConfirmPage{

	private BuyCreditConfirmPageWorldpayNextFragment buyCreditConfirmPageWorldpayNextFragment;
	
	public BuyCreditConfirmPageWorldpayNext(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditConfirmPageWorldpayNextFragment = new BuyCreditConfirmPageWorldpayNextFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_WP_NEXT_NAME_ENG = "BuyCreditConfirmWorldpayNextPage"; 

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_WP_NEXT_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return buyCreditConfirmPageWorldpayNextFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return buyCreditConfirmPageWorldpayNextFragment.getCorrectURL();
	}

	private void clickContinueButton(){
		
		buyCreditConfirmPageWorldpayNextFragment.clickContinueButton();
	}

	public PendingTransactionWorldpayPage continuePayment(){
		
		clickContinueButton();
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage = new PendingTransactionWorldpayPage(starter);
		PageNavigation<PendingTransactionWorldpayPage> navigation = new PageNavigation<PendingTransactionWorldpayPage>(pendingTransactionWorldpayPage);
		navigation.NavigatedTo();
		return pendingTransactionWorldpayPage;
	}
}
