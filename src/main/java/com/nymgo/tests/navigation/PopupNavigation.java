package com.nymgo.tests.navigation;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.admin.popups.AbstractPopup;

public class PopupNavigation<T extends AbstractPopup>
{
    private T page;
    private Logger LOGGER = AbstractCase.LOGGER;
	
	public PopupNavigation(T arg){
		page = arg;
	}
	
	public String getPageName(){
		return page.getPageName();
	}
	
	public boolean isCorrectPage(){
		return page.isCorrectPage();
	}
	
	public void NavigatedTo(){
		
		boolean result = false;
		try{
			result = isCorrectPage();
		}
		catch (TimeoutException e){
			LOGGER.fatal("Could not navigate to popup: " + getPageName());
		}
		Assert.assertTrue(result, "Could not navigate to popup: " + getPageName() + ", current Popup text is " + page.getPopupText() + "', should be '" + 
				page.getPageURL() + "'");
		LOGGER.info("Successfully navigated to popup : " + getPageName());		
	}
	
}
