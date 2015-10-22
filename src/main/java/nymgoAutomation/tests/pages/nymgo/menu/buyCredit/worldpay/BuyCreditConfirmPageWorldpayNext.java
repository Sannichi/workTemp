package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.worldpay.BuyCreditConfirmPageWorldpayNextFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.base.AbstractBuyCreditConfirmPage;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditConfirmPageWorldpayNext  extends AbstractBuyCreditConfirmPage{

	private BuyCreditConfirmPageWorldpayNextFragment buyCreditConfirmPageWorldpayNextFragment;
	
	public BuyCreditConfirmPageWorldpayNext(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditConfirmPageWorldpayNextFragment = new BuyCreditConfirmPageWorldpayNextFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_WP_NEXT_NAME_ENG = "BuyCreditConfirmWorldpayNextPage"; 

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_WP_NEXT_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return buyCreditConfirmPageWorldpayNextFragment.isCorrectURL();
	}

	private void clickContinueButton(){
		
		buyCreditConfirmPageWorldpayNextFragment.clickContinueButton();
	}

	public BuyCreditConfirmPageNextPendingWorldpay continuePayment(){
		
		clickContinueButton();
		BuyCreditConfirmPageNextPendingWorldpay buyCreditConfirmPageNextPendingWorldpay = new BuyCreditConfirmPageNextPendingWorldpay(starter);
		PageNavigation<BuyCreditConfirmPageNextPendingWorldpay> navigation = new PageNavigation<BuyCreditConfirmPageNextPendingWorldpay>(buyCreditConfirmPageNextPendingWorldpay);
		navigation.NavigatedTo();
		return buyCreditConfirmPageNextPendingWorldpay;
	}

	
}
