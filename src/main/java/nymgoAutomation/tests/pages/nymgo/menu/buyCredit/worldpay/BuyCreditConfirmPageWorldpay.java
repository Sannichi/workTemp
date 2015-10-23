package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.worldpay.BuyCreditConfirmPageWorldpayFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPageCancelled;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.base.AbstractBuyCreditConfirmPage;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditConfirmPageWorldpay extends AbstractBuyCreditConfirmPage{

	private BuyCreditConfirmPageWorldpayFragment buyCreditConfirmPageWorldpayFragment;
	
	public BuyCreditConfirmPageWorldpay(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditConfirmPageWorldpayFragment = new BuyCreditConfirmPageWorldpayFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_WP_NAME_ENG = "BuyCreditConfirmWorldpayPage"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_WP_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return buyCreditConfirmPageWorldpayFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return buyCreditConfirmPageWorldpayFragment.getCorrectURL();
	}

	private void setCardNumber(String cardNumberValue){
		
		buyCreditConfirmPageWorldpayFragment.setCardNumberValue(cardNumberValue);
	}

	private void selectExpireDateMonth(String expireDateMonth){
		
		buyCreditConfirmPageWorldpayFragment.selectExpireDateMonthByLCName(expireDateMonth);
	}

	private void selectExpireDateYear(String expireDateYear){
		
		buyCreditConfirmPageWorldpayFragment.selectExpireDateYearByLCName(expireDateYear);
	}

	private void setCVV(String cvvValue){
		
		buyCreditConfirmPageWorldpayFragment.setCVVValue(cvvValue);
	}
	
	private void setCardholdersName(String cardholdersName){
		
		buyCreditConfirmPageWorldpayFragment.setCardholdersName(cardholdersName);
	}
	
	private void clickMakePaymentButton(){
		
		buyCreditConfirmPageWorldpayFragment.clickMakePaymentButton();
	}
	
	private void clickCancelButton(){
		
		buyCreditConfirmPageWorldpayFragment.clickCancelButton();
	}
	
	//TODO instead of void
	public BuyCreditConfirmPageWorldpayNext setCreditCardDataAndClickContinue(String cardNumberValue, String expireDateMonth, String expireDateYear, String cvvValue, String cardholdersName){
		
		setCardNumber(cardNumberValue);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		setCardholdersName(cardholdersName);
		clickMakePaymentButton();
		BuyCreditConfirmPageWorldpayNext buyCreditConfirmPageWorldpayNext = new BuyCreditConfirmPageWorldpayNext(starter);
		PageNavigation<BuyCreditConfirmPageWorldpayNext> navigation = new PageNavigation<BuyCreditConfirmPageWorldpayNext>(buyCreditConfirmPageWorldpayNext);
		navigation.NavigatedTo();
		return buyCreditConfirmPageWorldpayNext;
	}

	//TODO
	public BuyCreditConfirmPageCancelled setCreditCardDataAndClickCancel(String cardNumberValue, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickCancelButton();
		BuyCreditConfirmPageCancelled buyCreditConfirmPageCancelled = new BuyCreditConfirmPageCancelled(starter);
		PageNavigation<BuyCreditConfirmPageCancelled> navigation = new PageNavigation<BuyCreditConfirmPageCancelled>(buyCreditConfirmPageCancelled);
		navigation.NavigatedTo();
		return buyCreditConfirmPageCancelled;
	}
}
