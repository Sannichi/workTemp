package nymgoAutomation.tests.pages.nymgo.menu.buyCredit;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BuyCreditProceedPageAdyenFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.nymgo.base.AbstractLoggedInPage;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditProceedPageAdyen extends AbstractLoggedInPage{
	
	BuyCreditProceedPageAdyenFragment buyCreditProceedPageAdyenFragment;

	public BuyCreditProceedPageAdyen(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditProceedPageAdyenFragment = new BuyCreditProceedPageAdyenFragment(driver);
	}

	private static final String BUY_CREDIT_PROCEED_PAGE_ADYEN_NAME_ENG = "BuyCreditProceedAdyenPage"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_PROCEED_PAGE_ADYEN_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return buyCreditProceedPageAdyenFragment.isCorrectURL();
	}

	private void setCardNumber(String cardNumberValue){
		
		buyCreditProceedPageAdyenFragment.setCardNumberValue(cardNumberValue);
	}

	public void setCardholdersName(String cardholdersName){
		
		buyCreditProceedPageAdyenFragment.setCardholdersName(cardholdersName);
	}
	
	private void selectExpireDateMonth(String expireDateMonth){
		
		buyCreditProceedPageAdyenFragment.selectExpireDateMonthByValue(expireDateMonth);
	}

	private void selectExpireDateYear(String expireDateYear){
		
		buyCreditProceedPageAdyenFragment.selectExpireDateYearByLCName(expireDateYear);
	}

	private void setCVV(String cvvValue){
		
		buyCreditProceedPageAdyenFragment.setCVVValue(cvvValue);
	}
	
	private void clickPayButton(){
		
		buyCreditProceedPageAdyenFragment.clickPayButton();
	}
	
	private void clickCancelButton(){
		
		buyCreditProceedPageAdyenFragment.clickCancelButton();
	}
	
	//TODO instead of void
	public BuyCreditConfirmPageDeclinedAdyen setCreditCardDataAndClickContinue(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		BuyCreditConfirmPageDeclinedAdyen buyCreditConfirmPageDeclinedAdyen = new BuyCreditConfirmPageDeclinedAdyen(starter);
		PageNavigation<BuyCreditConfirmPageDeclinedAdyen> navigation = new PageNavigation<BuyCreditConfirmPageDeclinedAdyen>(buyCreditConfirmPageDeclinedAdyen);
		navigation.NavigatedTo();
		return buyCreditConfirmPageDeclinedAdyen;
	}

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
