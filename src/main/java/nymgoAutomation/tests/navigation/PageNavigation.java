package nymgoAutomation.tests.navigation;

import nymgoAutomation.tests.pages.AbstractPage;
import nymgoAutomation.tests.testCases.AbstractCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

public class PageNavigation<T extends AbstractPage>
{
    private T page;
    private Logger LOGGER = AbstractCase.LOGGER;
	
	public PageNavigation(T arg){
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
		Assert.assertTrue(result, "Could not navigate to page: " + getPageName() + ", current URL is '" + page.getCurrentURL() + "', should be '" + 
				page.getPageURL() + "'");
		LOGGER.info("Successfully navigated to page: " + getPageName());		
	}
	
}
