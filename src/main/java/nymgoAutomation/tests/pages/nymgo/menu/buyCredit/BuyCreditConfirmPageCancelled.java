package nymgoAutomation.tests.pages.nymgo.menu.buyCredit;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BuyCreditConfirmPageCancelledFragment;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.base.AbstractBuyCreditConfirmPageNext;

public class BuyCreditConfirmPageCancelled extends AbstractBuyCreditConfirmPageNext{

	private BuyCreditConfirmPageCancelledFragment buyCreditConfirmPageCancelledFragment;
	
	public BuyCreditConfirmPageCancelled(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditConfirmPageCancelledFragment = new BuyCreditConfirmPageCancelledFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_CANCELLED_NAME_ENG = "BuyCreditConfirmPageCancelled"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_CANCELLED_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return buyCreditConfirmPageCancelledFragment.isCorrectURL();
	}
}
