package nymgoAutomation.tests.pages.nymgo.menu.buyCredit;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BuyCreditConfirmPagePendingWorldpayFragment;
import nymgoAutomation.tests.navigation.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditConfirmPagePendingWorldpay extends AbstractBuyCreditConfirmPageNext{

	BuyCreditConfirmPagePendingWorldpayFragment buyCreditConfirmPagePendingWorldpayFragment;

	public BuyCreditConfirmPagePendingWorldpay(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditConfirmPagePendingWorldpayFragment = new BuyCreditConfirmPagePendingWorldpayFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_PENDING_WP_NAME_ENG = "BuyCreditConfirmPagePendingWorldpay"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_PENDING_WP_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return buyCreditConfirmPagePendingWorldpayFragment.isCorrectURL();
	}
}
