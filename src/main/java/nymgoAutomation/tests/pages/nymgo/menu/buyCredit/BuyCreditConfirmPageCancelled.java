package nymgoAutomation.tests.pages.nymgo.menu.buyCredit;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BuyCreditConfirmPageCancelledFragment;
import nymgoAutomation.tests.pages.nymgo.transactions.AbstractTransactionPage;
import nymgoAutomation.tests.starter.Starter;

public class BuyCreditConfirmPageCancelled extends AbstractTransactionPage{

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

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return buyCreditConfirmPageCancelledFragment.getCorrectURL();
	}
}
