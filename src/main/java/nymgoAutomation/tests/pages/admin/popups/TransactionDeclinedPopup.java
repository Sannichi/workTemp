package nymgoAutomation.tests.pages.admin.popups;

import nymgoAutomation.tests.starter.Starter;

public class TransactionDeclinedPopup extends AbstractPopup{
	
	public TransactionDeclinedPopup(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		
	}
	
	private static final String TRANSACTION_DECLINED_POPUP_NAME_ENG = "Transaction Declined Popup"; 
	private static final String TRANSACTION_DECLINED_POPUP_TEXT_ENG = "  transaction declined successfully And queued successfully"; 
	
	
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return TRANSACTION_DECLINED_POPUP_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return getPopupText().equals(TRANSACTION_DECLINED_POPUP_TEXT_ENG);
	}
	
	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return TRANSACTION_DECLINED_POPUP_TEXT_ENG;
	}
	
    public void closeTransactionDeclinedPopup(){

    	closePopup(getPageName());
    }

}
