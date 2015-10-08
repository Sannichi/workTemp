package nymgoAutomation.tests.navigation;

import nymgoAutomation.tests.pages.admin.popups.AbstractPopup;
import nymgoAutomation.tests.testCases.AbstractCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

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
			LOGGER.fatal("Could not navigate to page: " + getPageName());
		}
		Assert.assertTrue(result, "Could not navigate to page: " + getPageName() + ", current Popup text is " + page.getPopupText());
		LOGGER.info("Successfully navigated to page: " + getPageName());		
	}
	
}
