package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.adyen;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.adyen.PendingTransactionAdyenFragment;
import nymgoAutomation.tests.pages.nymgo.transactions.PendingTransactionPage;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Nov 11, 2015
 */
public class PendingTransactionAdyenPage extends PendingTransactionPage{

	private PendingTransactionAdyenFragment pendingTransactionAdyenFragment;

	public PendingTransactionAdyenPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		pendingTransactionAdyenFragment = new PendingTransactionAdyenFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_PENDING_ADYEN_NAME_ENG = "BuyCreditConfirmPagePendingAdyen"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_PENDING_ADYEN_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return pendingTransactionAdyenFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return pendingTransactionAdyenFragment.getCorrectURL();
	}
}
