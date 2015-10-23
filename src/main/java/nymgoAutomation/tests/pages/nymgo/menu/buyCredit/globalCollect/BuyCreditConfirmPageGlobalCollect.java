package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.globalCollect;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.globalCollect.BuyCreditConfirmPageGlobalCollectFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPageCancelled;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.base.AbstractBuyCreditConfirmPage;
import nymgoAutomation.tests.starter.Starter;

public class BuyCreditConfirmPageGlobalCollect extends AbstractBuyCreditConfirmPage{

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
	
	//TODO instead of void
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
