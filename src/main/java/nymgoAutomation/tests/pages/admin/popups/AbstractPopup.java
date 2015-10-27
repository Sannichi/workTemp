package nymgoAutomation.tests.pages.admin.popups;

import org.testng.Assert;

import nymgoAutomation.tests.fragments.admin.popups.BasePopupFragment;
import nymgoAutomation.tests.pages.AbstractPage;
import nymgoAutomation.tests.starter.Starter;

public abstract class AbstractPopup extends AbstractPage{
	
	BasePopupFragment basePopupFragment;

	public AbstractPopup(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		basePopupFragment = new BasePopupFragment(driver);
	}

    public boolean isPopupExist(){

        return basePopupFragment.isPopupExist();
    }

    public void closePopups(){
    	
    	TransactionAcceptedPopup transactionAcceptedPopup = new TransactionAcceptedPopup(starter);
    	if(transactionAcceptedPopup.isPopupExist()){
            delay(2000);
    		transactionAcceptedPopup.clickOnCloseButton();
            LOGGER.info("Closing the Transaction Accepted Popup");            
        } 
        /*
        else if() {
        	
        }
        */
    }
    
    public String getPopupText(){
    	
    	return basePopupFragment.getPopupText();
    }
    
    public void clickOnCloseButton(){
    	
    	basePopupFragment.clickOnCloseButton();
    }

    protected  void closePopup(String popupName){
    	
		for(int i = 0; i < 5; i++){
			delay(2000);
	        LOGGER.info("Waiting 2 seconds...");
			if(isPopupExist()){
				clickOnCloseButton();
		        for (int j = 0; j < 5; j++){
		        	if (isPopupExist()){
		        		delay(2000);
		    	        LOGGER.info("Waiting 2 seconds for closing...");
		        	}
		        	else
		        		break;
		        }
		        LOGGER.info("Closing the " + popupName);            
		    	Assert.assertFalse(isPopupExist(), popupName + " was not closed within 10 seconds");
				break;
			}
			if(i == 4){
				LOGGER.fatal(popupName + " was not appeared in 10 seconds");
			}
		}
    }
    
}
