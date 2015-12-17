package com.nymgo.tests.navigation;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.AbstractPage;

public class PageNavigation<T extends AbstractPage>
{
    private T page;
    private Logger LOGGER = AbstractCase.LOGGER;
	
	public PageNavigation(T arg){
		page = arg;
	}
	
	private String getPageName(){
		return page.getPageName();
	}
	
	private boolean isCorrectPage(){
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
