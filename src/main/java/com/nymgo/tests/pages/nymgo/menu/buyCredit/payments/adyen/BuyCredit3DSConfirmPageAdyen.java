package com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.adyen.BuyCredit3DSConfirmPageAdyenFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.starter.Starter;
/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCredit3DSConfirmPageAdyen extends AbstractLoggedInPage{
	
	private BuyCredit3DSConfirmPageAdyenFragment buyCredit3DSConfirmPageAdyenFragment;

	public BuyCredit3DSConfirmPageAdyen(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCredit3DSConfirmPageAdyenFragment = new BuyCredit3DSConfirmPageAdyenFragment(driver);
	}

	private static final String BUY_CREDIT_PROCEED_PAGE_ADYEN_NAME_ENG = "BuyCreditProceedAdyenPage"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_PROCEED_PAGE_ADYEN_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return buyCredit3DSConfirmPageAdyenFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return buyCredit3DSConfirmPageAdyenFragment.getCorrectURL();
	}


	private void setUsername(String username){
		
		buyCredit3DSConfirmPageAdyenFragment.setUsername(username);
	}

	private void setPassword(String password){
		
		buyCredit3DSConfirmPageAdyenFragment.setPassword(password);
	}
	
	private void clickSubmitButton(){
		
		buyCredit3DSConfirmPageAdyenFragment.clickSubmitButton();
	}
	
	public PendingTransactionAdyen3DSPage setUserDataAndClickSubmit(String username, String password){
		
		setUsername(username);
		setPassword(password);
		clickSubmitButton();
		PendingTransactionAdyen3DSPage pendingTransactionAdyen3DSPage = new PendingTransactionAdyen3DSPage(starter);
		PageNavigation<PendingTransactionAdyen3DSPage> navigation = new PageNavigation<PendingTransactionAdyen3DSPage>(pendingTransactionAdyen3DSPage);
		navigation.NavigatedTo();
		return pendingTransactionAdyen3DSPage;
	}
}
