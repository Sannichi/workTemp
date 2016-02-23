package com.nymgo.tests.pages.admin.popups;

import org.testng.Assert;

import com.nymgo.tests.starter.Starter;
/**
 * Created by Iuliia Khikmatova on Feb 23, 2016
 */
public class DealAcceptedPopup extends AbstractPopup{
	
	public DealAcceptedPopup(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		
	}
	
	private static final String DEAL_ACCEPTED_POPUP_NAME_ENG = "DealAcceptedPopup"; 
	private static final String DEAL_ACCEPTED_POPUP_TEXT_ENG = "  Call API Donetransaction accepted successfully And queued successfully"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return DEAL_ACCEPTED_POPUP_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return getPopupText().equals(DEAL_ACCEPTED_POPUP_TEXT_ENG);
	}
	
	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return DEAL_ACCEPTED_POPUP_TEXT_ENG;
	}

	public void closeDealAcceptedPopup(){
    	
		for(int i = 0; i < 5; i++){
			delay(2000);
			if(isPopupExist()){
				clickOnCloseButton();
		        delay(2000);
	            LOGGER.info("Closing the Deal Accepted Popup");            
		    	Assert.assertFalse(isPopupExist(), "Deal Accepted Popup was not closed");
				break;
			}
			if(i == 4){
				LOGGER.fatal("Deal Accepted Popup was not appeared in 10 seconds");
			}
		}
    }
}
