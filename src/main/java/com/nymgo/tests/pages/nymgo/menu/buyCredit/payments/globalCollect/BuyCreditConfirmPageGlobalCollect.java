package com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.globalCollect;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.globalCollect.BuyCreditConfirmPageGlobalCollectFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.BuyCreditConfirmPageCancelled;
import com.nymgo.tests.starter.Starter;

//public class BuyCreditConfirmPageGlobalCollect extends AbstractBuyCreditConfirmPage{
//public class BuyCreditConfirmPageGlobalCollect extends AbstractTransactionPage{
public class BuyCreditConfirmPageGlobalCollect extends AbstractLoggedInPage{

	private BuyCreditConfirmPageGlobalCollectFragment buyCreditConfirmPageGlobalCollectFragment;
	
	public BuyCreditConfirmPageGlobalCollect(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditConfirmPageGlobalCollectFragment = new BuyCreditConfirmPageGlobalCollectFragment(driver);
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_GC_NAME_ENG = "BuyCreditConfirmGlobalCollectPage"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_GC_NAME_ENG;
	}
	
	@Override
	public boolean isCorrectPage(){
		
		return buyCreditConfirmPageGlobalCollectFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return buyCreditConfirmPageGlobalCollectFragment.getCorrectURL();
	}

	private void setCardNumber(String cardNumberValue){
		
		buyCreditConfirmPageGlobalCollectFragment.setCardNumberValue(cardNumberValue);
	}

	private void selectExpireDateMonth(String expireDateMonth){
		
		buyCreditConfirmPageGlobalCollectFragment.selectExpireDateMonthByLCName(expireDateMonth);
	}

	private void selectExpireDateYear(String expireDateYear){
		
		if(expireDateYear.length()==4){
			expireDateYear = expireDateYear.substring(2);
		}
		buyCreditConfirmPageGlobalCollectFragment.selectExpireDateYearByLCName(expireDateYear);
	}

	private void setCVV(String cvvValue){
		
		buyCreditConfirmPageGlobalCollectFragment.setCVVValue(cvvValue);
	}
	
	private void clickContinueButton(){
		
		buyCreditConfirmPageGlobalCollectFragment.clickContinueButton();
	}
	
	private void clickCancelButton(){
		
		buyCreditConfirmPageGlobalCollectFragment.clickCancelButton();
	}
	
	public PendingTransactionGlobalCollectPage setCreditCardDataAndClickContinue(String cardNumberValue, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickContinueButton();
		PendingTransactionGlobalCollectPage pendingTransactionGlobalCollectPage = new PendingTransactionGlobalCollectPage(starter);
		PageNavigation<PendingTransactionGlobalCollectPage> navigation = new PageNavigation<PendingTransactionGlobalCollectPage>(pendingTransactionGlobalCollectPage);
		navigation.NavigatedTo();
		return pendingTransactionGlobalCollectPage;
	}

	public SuccessfulTransactionGlobalCollectPage setCreditCardDataAndClickContinueSuccessful(String cardNumberValue, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickContinueButton();
		SuccessfulTransactionGlobalCollectPage successfulTransactionGlobalCollectPage = new SuccessfulTransactionGlobalCollectPage(starter);
		PageNavigation<SuccessfulTransactionGlobalCollectPage> navigation = new PageNavigation<SuccessfulTransactionGlobalCollectPage>(successfulTransactionGlobalCollectPage);
		navigation.NavigatedTo();
		return successfulTransactionGlobalCollectPage;
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
