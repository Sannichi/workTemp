package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.globalCollect;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.globalCollect.PendingTransactionGlobalCollectFragment;
import nymgoAutomation.tests.pages.nymgo.transactions.PendingIframeTransactionPage;
import nymgoAutomation.tests.starter.Starter;

public class PendingTransactionGlobalCollectPage extends PendingIframeTransactionPage{

	private PendingTransactionGlobalCollectFragment pendingTransactionGlobalCollectFragment;
	
	public PendingTransactionGlobalCollectPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		pendingTransactionGlobalCollectFragment = new PendingTransactionGlobalCollectFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_PENDING_GC_NAME_ENG = "BuyCreditConfirmPagePendingGlobalCollect"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_PENDING_GC_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return pendingTransactionGlobalCollectFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return pendingTransactionGlobalCollectFragment.getCorrectURL();
	}
}
