package com.nymgo.tests.pages.admin.popups;

import com.nymgo.tests.starter.Starter;

public class TransactionCancelledPopup extends AbstractPopup{
	
	public TransactionCancelledPopup(Starter starter) {
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
	
    public void closeTransactionCancelledPopup(){

    	closePopup(getPageName());
    }

}
