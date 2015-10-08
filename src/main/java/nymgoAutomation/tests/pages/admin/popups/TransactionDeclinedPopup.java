package nymgoAutomation.tests.pages.admin.popups;

import org.testng.Assert;

//import nymgoAutomation.tests.fragments.admin.popups.TransactionAcceptedPopupFragment;
import nymgoAutomation.tests.navigation.Starter;

public class TransactionDeclinedPopup extends AbstractPopup{
	
	public TransactionDeclinedPopup(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		
	}
	
	private static final String TRANSACTION_DECLINED_POPUP_NAME_ENG = "TransactionDeclinedPopup"; 
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
	
    public void closeTransactionDeclinedPopup(){
    	
		for(int i = 0; i < 5; i++){
			delay(2000);
			if(isPopupExist()){
				clickOnCloseButton();
		        delay(2000);
		        LOGGER.info("Closing the Transaction Declined Popup");            
		    	Assert.assertFalse(isPopupExist(), "Transaction Declined Popup was not closed");
				break;
			}
			if(i == 4){
				LOGGER.fatal("Transaction Declined Popup was not appeared in 10 seconds");
			}
		}
    }
	
}
