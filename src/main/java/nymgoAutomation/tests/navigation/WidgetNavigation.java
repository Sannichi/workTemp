package nymgoAutomation.tests.navigation;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import nymgoAutomation.tests.pages.admin.widgets.AbstractWidget;
import nymgoAutomation.tests.testCases.AbstractCase;

/**
 * Created by Iuliia Khikmatova on Oct 28, 2015
 */
public class WidgetNavigation<T extends AbstractWidget>
{
    private T widget;
    private Logger LOGGER = AbstractCase.LOGGER;
	
	public WidgetNavigation(T arg){
		widget = arg;
	}
	
	public String getWidgetName(){
		return widget.getPageName();
	}
	
	public boolean isCorrectPage(){
		return widget.isCorrectPage();
	}
	
	public void NavigatedTo(){
		
		boolean result = false;
		try{
			result = isCorrectPage();
		}
		catch (TimeoutException e){
			LOGGER.fatal("Could not navigate to page: " + getWidgetName());
		}
		Assert.assertTrue(result, "Could not navigate to page: " + getWidgetName() + ", current Widget Name is '" + widget.getWidgetName() + "', should be '" + 
				widget.getPageURL() + "'");
		LOGGER.info("Successfully navigated to page: " + getWidgetName());		
	}
}
