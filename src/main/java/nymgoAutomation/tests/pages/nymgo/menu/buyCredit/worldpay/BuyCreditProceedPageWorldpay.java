package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.worldpay.BuyCreditProceedPageWorldpayFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.base.AbstractBuyCreditProceedPage;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditProceedPageWorldpay extends AbstractBuyCreditProceedPage{

	private BuyCreditProceedPageWorldpayFragment buyCreditProceedPageWorldpayFragment;
	
	private static final String BUY_CREDIT_PROCEED_PAGE_WP_NAME_ENG = "BuyCreditProceedWorldpayPage"; 
			
	public BuyCreditProceedPageWorldpay(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditProceedPageWorldpayFragment = new BuyCreditProceedPageWorldpayFragment(driver);
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_PROCEED_PAGE_WP_NAME_ENG;
	}

	public BuyCreditConfirmPageWorldpay verifyDataAndClickContinue(String cardType, String countryOfCredit,
			String nymgoCreditValue, String VAT, String totalAmountCharged){
		
		verifyPaymentBlock(cardType, countryOfCredit);
		verifySkrillFooterBlock(nymgoCreditValue, VAT, totalAmountCharged);
		clickContinueButton();
		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		PageNavigation<BuyCreditConfirmPageWorldpay> navigation = new PageNavigation<BuyCreditConfirmPageWorldpay>(buyCreditConfirmPageWorldpay);
		navigation.NavigatedTo();
		return buyCreditConfirmPageWorldpay;
	} 

	public void verifyDefaultData(String countryOfResidence, String nymgoCreditValue, String VAT, String totalAmountCharged){
		verifyDefaultPaymentBlock(countryOfResidence);
		verifySkrillFooterBlock(nymgoCreditValue, VAT, totalAmountCharged);
	} 
}
