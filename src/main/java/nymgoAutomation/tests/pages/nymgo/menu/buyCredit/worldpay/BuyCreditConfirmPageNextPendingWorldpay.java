package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.worldpay.BuyCreditConfirmPageNextPendingWorldpayFragment;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.base.AbstractBuyCreditConfirmPageNext;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditConfirmPageNextPendingWorldpay extends AbstractBuyCreditConfirmPageNext{

	private BuyCreditConfirmPageNextPendingWorldpayFragment buyCreditConfirmPageNextPendingWorldpayFragment;

	public BuyCreditConfirmPageNextPendingWorldpay(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditConfirmPageNextPendingWorldpayFragment = new BuyCreditConfirmPageNextPendingWorldpayFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_PENDING_WP_NAME_ENG = "BuyCreditConfirmPagePendingWorldpay"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_PENDING_WP_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return buyCreditConfirmPageNextPendingWorldpayFragment.isCorrectURL();
	}
}
