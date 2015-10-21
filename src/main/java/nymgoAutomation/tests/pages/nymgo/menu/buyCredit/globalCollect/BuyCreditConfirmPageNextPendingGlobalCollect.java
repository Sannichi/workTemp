package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.globalCollect;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.globalCollect.BuyCreditConfirmPageNextPendingGlobalCollectFragment;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.base.AbstractBuyCreditConfirmPageNext;

public class BuyCreditConfirmPageNextPendingGlobalCollect extends AbstractBuyCreditConfirmPageNext{

	private BuyCreditConfirmPageNextPendingGlobalCollectFragment buyCreditConfirmPageNextPendingGlobalCollectFragment;
	
	public BuyCreditConfirmPageNextPendingGlobalCollect(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditConfirmPageNextPendingGlobalCollectFragment = new BuyCreditConfirmPageNextPendingGlobalCollectFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_PENDING_GC_NAME_ENG = "BuyCreditConfirmPagePendingGlobalCollect"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_PENDING_GC_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return buyCreditConfirmPageNextPendingGlobalCollectFragment.isCorrectURL();
	}
}
