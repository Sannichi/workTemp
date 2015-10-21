package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.adyen;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.adyen.BuyCreditConfirmPageDeclinedAdyenFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.nymgo.base.AbstractTransactionPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditPage;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditConfirmPageDeclinedAdyen extends AbstractTransactionPage{

	private BuyCreditConfirmPageDeclinedAdyenFragment buyCreditConfirmPageDeclinedAdyenFragment;
	
	public BuyCreditConfirmPageDeclinedAdyen(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditConfirmPageDeclinedAdyenFragment = new BuyCreditConfirmPageDeclinedAdyenFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_CANCELLED_ADYEN_NAME_ENG = "BuyCreditConfirmPageCancelledAdyen"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_CANCELLED_ADYEN_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return buyCreditConfirmPageDeclinedAdyenFragment.isCorrectURL();
	}

	private void clickTryAgainButton(){
		
		buyCreditConfirmPageDeclinedAdyenFragment.clickTryAgainButton();
	}

	public BuyCreditPage clickTryAgainBuyCreditButton(){
		
		clickTryAgainButton();
		BuyCreditPage buyCreditPage = new BuyCreditPage(starter);
		PageNavigation<BuyCreditPage> navigation = new PageNavigation<BuyCreditPage>(buyCreditPage);
		navigation.NavigatedTo();
		return buyCreditPage;
		
	}
}
