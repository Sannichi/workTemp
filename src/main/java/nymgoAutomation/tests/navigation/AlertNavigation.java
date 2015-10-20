package nymgoAutomation.tests.navigation;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import nymgoAutomation.tests.pages.admin.alerts.AbstractAlert;
import nymgoAutomation.tests.pages.admin.popups.AbstractPopup;
import nymgoAutomation.tests.testCases.AbstractCase;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class AlertNavigation<T extends AbstractAlert>
{
    private T alert;
    private Logger LOGGER = AbstractCase.LOGGER;
	
	public AlertNavigation(T arg){
		alert = arg;
	}
	
	public String getPageName(){
		return alert.getPageName();
	}
	
	public boolean isCorrectPage(){
		return alert.isCorrectPage();
	}
	
	public void NavigatedTo(){
		
		boolean result = false;
		try{
			result = isCorrectPage();
		}
		catch (TimeoutException e){
			LOGGER.fatal("Could not navigate to page: " + getPageName());
		}
		Assert.assertTrue(result, "Could not navigate to alert: " + getPageName() + ", current Alert text is " + alert.getAlertText());
		LOGGER.info("Successfully navigated to alert: " + getPageName());		
	}
	
}
