package nymgoAutomation.tests.pages.nymgo.menu.buyCredit;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BuyCreditConfirmPageWorldpayNextFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditConfirmPageWorldpayNext  extends AbstractBuyCreditConfirmPage{

	BuyCreditConfirmPageWorldpayNextFragment buyCreditConfirmPageWorldpayNextFragment;
	
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

	public BuyCreditConfirmPagePendingWorldpay continuePayment(){
		
		clickContinueButton();
		BuyCreditConfirmPagePendingWorldpay buyCreditConfirmPagePendingWorldpay = new BuyCreditConfirmPagePendingWorldpay(starter);
		PageNavigation<BuyCreditConfirmPagePendingWorldpay> navigation = new PageNavigation<BuyCreditConfirmPagePendingWorldpay>(buyCreditConfirmPagePendingWorldpay);
		navigation.NavigatedTo();
		return buyCreditConfirmPagePendingWorldpay;
	}

	
}
