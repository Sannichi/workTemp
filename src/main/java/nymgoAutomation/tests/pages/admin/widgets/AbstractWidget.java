package nymgoAutomation.tests.pages.admin.widgets;

import org.testng.Assert;

import nymgoAutomation.tests.fragments.admin.widgets.BaseWidgetFragment;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.AbstractPage;

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

    protected void delay(final long amount) {
        try {
            Thread.sleep(amount);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    protected void closeWidget(String widgetName){
    	
		for(int i = 0; i < 5; i++){
			delay(2000);
	    	if(isWidgetExist()){
				clickOnCloseButton();
		        LOGGER.info("Closing the " + widgetName);
		        for (int j = 0; j < 5; j++){
		        	if (isWidgetExist())
		        		delay(2000);
		        	else
		        		break;
		        }
		    	Assert.assertFalse(isWidgetExist(), widgetName + " was not closed within 10 seconds");
				break;
			}
			if (i == 4){
		        LOGGER.fatal(widgetName + " was not appeared in 10 seconds");            
			}
		}
    }
    
}
