package com.nymgo.tests.navigation;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.fancyboxes.AbstractFancybox;

public class FancyboxNavigation<T extends AbstractFancybox>
{
    private T page;
    private Logger LOGGER = AbstractCase.LOGGER;
	
	public FancyboxNavigation(T arg){
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
			LOGGER.fatal("Could not navigate to fancybox: " + getPageName());
		}
		Assert.assertTrue(result, "Could not navigate to fancybox: " + getPageName() + ", current Fancybox URL is '" + page.getPageURL() + "', should be '" + 
				page.getPageURL() + "'");
		LOGGER.info("Successfully navigated to fancybox: " + getPageName());
	}
	
}
