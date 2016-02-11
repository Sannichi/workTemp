package com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.worldpay.BuyCredit3DSConfirmPageWorldpayFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCredit3DSConfirmPageWorldpay extends AbstractLoggedInPage{

	private BuyCredit3DSConfirmPageWorldpayFragment buyCredit3DSConfirmPageWorldpayFragment;
	
	public BuyCredit3DSConfirmPageWorldpay(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCredit3DSConfirmPageWorldpayFragment = new BuyCredit3DSConfirmPageWorldpayFragment(driver);
	}
	private static final String BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_NAME_ENG = "BuyCreditConfirmWorldpayNextPage"; 

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return buyCredit3DSConfirmPageWorldpayFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return buyCredit3DSConfirmPageWorldpayFragment.getCorrectURL();
	}

	private void clickContinueButton(){
		
		buyCredit3DSConfirmPageWorldpayFragment.clickContinueButton();
	}

	public PendingTransactionWorldpay3DSPage continuePayment(){
		
		clickContinueButton();
		PendingTransactionWorldpay3DSPage pendingTransactionWorldpay3DSPage = new PendingTransactionWorldpay3DSPage(starter);
		PageNavigation<PendingTransactionWorldpay3DSPage> navigation = new PageNavigation<PendingTransactionWorldpay3DSPage>(pendingTransactionWorldpay3DSPage);
		navigation.NavigatedTo();
		return pendingTransactionWorldpay3DSPage;
	}
}
