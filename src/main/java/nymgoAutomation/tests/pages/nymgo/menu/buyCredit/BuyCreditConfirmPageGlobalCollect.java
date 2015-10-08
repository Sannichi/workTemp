package nymgoAutomation.tests.pages.nymgo.menu.buyCredit;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BuyCreditConfirmPageGlobalCollectFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;

public class BuyCreditConfirmPageGlobalCollect extends AbstractBuyCreditConfirmPage{

	BuyCreditConfirmPageGlobalCollectFragment buyCreditConfirmPageGlobalCollectFragment;
	
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

	private void setCardNumber(String cardNumberValue){
		
		buyCreditConfirmPageGlobalCollectFragment.setCardNumberValue(cardNumberValue);
	}

	private void selectExpireDateMonth(String expireDateMonth){
		
		buyCreditConfirmPageGlobalCollectFragment.selectExpireDateMonthByLCName(expireDateMonth);
	}

	private void selectExpireDateYear(String expireDateYear){
		
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
	public BuyCreditConfirmPagePending setCreditCardDataAndClickContinue(String cardNumberValue, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickContinueButton();
		BuyCreditConfirmPagePending buyCreditConfirmPagePending = new BuyCreditConfirmPagePending(starter);
		PageNavigation<BuyCreditConfirmPagePending> navigation = new PageNavigation<BuyCreditConfirmPagePending>(buyCreditConfirmPagePending);
		navigation.NavigatedTo();
		return buyCreditConfirmPagePending;
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
