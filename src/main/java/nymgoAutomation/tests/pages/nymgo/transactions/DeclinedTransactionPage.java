package nymgoAutomation.tests.pages.nymgo.transactions;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BuyCreditConfirmPageCancelledFragment;
import nymgoAutomation.tests.starter.Starter;

public abstract class DeclinedTransactionPage extends AbstractTransactionPage{

	private BuyCreditConfirmPageCancelledFragment buyCreditConfirmPageCancelledFragment;

	public DeclinedTransactionPage(Starter starter) {
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
