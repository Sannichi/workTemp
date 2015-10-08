package nymgoAutomation.tests.pages.admin.widgets;

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
}
