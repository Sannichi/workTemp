package com.nymgo.tests.pages.admin.widgets;

import org.testng.Assert;

import com.nymgo.tests.fragments.admin.widgets.BaseWidgetFragment;
import com.nymgo.tests.pages.AbstractPage;
import com.nymgo.tests.starter.Starter;

public abstract class AbstractWidget extends AbstractPage{
	
	BaseWidgetFragment baseWidgetFragment;

	public AbstractWidget(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseWidgetFragment = new BaseWidgetFragment(driver);
	}
	
    public boolean isWidgetExist(){

        return baseWidgetFragment.isWidgetExist();
    }

    public String getWidgetName(){
    	
    	return baseWidgetFragment.getWidgetName();
    }
    
    public boolean isContentAreaDisplayed(){

        return baseWidgetFragment.isContentAreaDisplayed();
    }

    public void closeWidgets(){
        MemberListWidget memberListWidget = new MemberListWidget(starter);
        if(memberListWidget.isWidgetExist()){
            delay(2000);
            memberListWidget.clickOnCloseButton();
            LOGGER.info("Closing the Member List widget");            
        } 
        /*
        else if() {
        	
        }
        */
    }
    
    public void clickOnTabByAltText(String tabText){

    	baseWidgetFragment.clickOnTabByAltText(tabText);
    }
    
    public void clickOnCloseButton(){
    	
    	baseWidgetFragment.clickOnCloseButton();
    }

    public void waitForCloseButton(){
    	
    	baseWidgetFragment.clickOnCloseButton();
    }

    protected void closeWidget(String widgetName){
    	
		for(int i = 0; i < 5; i++){
			delay(2000);
	        LOGGER.info("Waiting 2 seconds...");
	    	if(isWidgetExist()){
	    		if(isContentAreaDisplayed()){
					clickOnCloseButton();
			        LOGGER.info("Closing the " + widgetName);
			        for (int j = 0; j < 5; j++){
			        	if (isWidgetExist()){
			        		delay(2000);
			    	        LOGGER.info("Waiting 2 seconds for closing...");
			        	}
			        	else
			        		break;
			        }
			    	Assert.assertFalse(isWidgetExist(), widgetName + " was not closed within 10 seconds");
					break;
	    		}
			}
			if (i == 4){
		        LOGGER.fatal(widgetName + " was not appeared in 10 seconds");            
			}
		}
    }
    
}
