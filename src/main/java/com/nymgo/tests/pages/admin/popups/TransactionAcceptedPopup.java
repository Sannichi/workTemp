package com.nymgo.tests.pages.admin.popups;

import com.nymgo.tests.starter.Starter;

public class TransactionAcceptedPopup extends AbstractPopup{
	
	public TransactionAcceptedPopup(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		
	}
	
	private static final String TRANSACTION_ACCEPTED_POPUP_NAME_ENG = "TransactionAcceptedPopup"; 
	private static final String TRANSACTION_ACCEPTED_POPUP_TEXT_ENG = "  transaction accepted successfully And queued successfully"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return TRANSACTION_ACCEPTED_POPUP_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return getPopupText().equals(TRANSACTION_ACCEPTED_POPUP_TEXT_ENG);
	}
	
	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return TRANSACTION_ACCEPTED_POPUP_TEXT_ENG;
	}

//	public void closeTransactionAcceptedPopup(){
//    	
//		for(int i = 0; i < 5; i++){
//			delay(2000);
//			if(isPopupExist()){
//				clickOnCloseButton();
//		        delay(2000);
//	            LOGGER.info("Closing the Transaction Accepted Popup");            
//		    	Assert.assertFalse(isPopupExist(), "Transaction Accepted Popup was not closed");
//				break;
//			}
//			if(i == 4){
//				LOGGER.fatal("Transaction Accepted Popup was not appeared in 10 seconds");
//			}
//		}
//    }

	public void closeTransactionAcceptedPopup(){
	
		closePopup(getPageName());
	}
}
