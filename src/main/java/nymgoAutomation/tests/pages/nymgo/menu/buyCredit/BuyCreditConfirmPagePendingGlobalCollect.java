package nymgoAutomation.tests.pages.nymgo.menu.buyCredit;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BuyCreditConfirmPagePendingGlobalCollectFragment;
import nymgoAutomation.tests.navigation.Starter;

public class BuyCreditConfirmPagePendingGlobalCollect extends AbstractBuyCreditConfirmPageNext{

	BuyCreditConfirmPagePendingGlobalCollectFragment buyCreditConfirmPagePendingGlobalCollectFragment;
	
	public BuyCreditConfirmPagePendingGlobalCollect(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditConfirmPagePendingGlobalCollectFragment = new BuyCreditConfirmPagePendingGlobalCollectFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_PENDING_GC_NAME_ENG = "BuyCreditConfirmPagePendingGlobalCollect"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_PENDING_GC_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return buyCreditConfirmPagePendingGlobalCollectFragment.isCorrectURL();
	}
}
