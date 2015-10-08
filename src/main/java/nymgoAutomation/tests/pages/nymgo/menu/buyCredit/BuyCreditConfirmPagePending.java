package nymgoAutomation.tests.pages.nymgo.menu.buyCredit;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BuyCreditConfirmPagePendingFragment;
import nymgoAutomation.tests.navigation.Starter;

public class BuyCreditConfirmPagePending extends AbstractBuyCreditConfirmPageNext{

	BuyCreditConfirmPagePendingFragment buyCreditConfirmPagePendingFragment;
	
	public BuyCreditConfirmPagePending(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditConfirmPagePendingFragment = new BuyCreditConfirmPagePendingFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_CANCELLED_NAME_ENG = "BuyCreditConfirmPagePending"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_CANCELLED_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return buyCreditConfirmPagePendingFragment.isCorrectURL();
	}
}
