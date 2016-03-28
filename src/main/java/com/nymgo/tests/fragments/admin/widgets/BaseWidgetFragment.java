package com.nymgo.tests.fragments.admin.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nymgo.tests.fragments.BaseFragment;

public class BaseWidgetFragment extends BaseFragment{

	public BaseWidgetFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		setWidgetContainer();
		setWidgetName();
	}

    protected WebElement widgetContainer;
    protected String widgetName;

    protected void setWidgetContainer() throws NotFoundException{
    	
    	try{
    		widgetContainer = driver.findElement(By.id("widjectWindow"));
    	}
    	catch(NoSuchElementException e){
    		LOGGER.fatal("Seems like widget container is absent on the screen");
    		widgetContainer = null;
    	}
    };

    protected void setWidgetName() throws NotFoundException{
    	
    	setWidgetContainer();
    	if (widgetContainer != null){
        	widgetName = widgetContainer.findElement(By.xpath(".//div[@class='drag-handle']")).getText().split("\n")[0];
    	}
    	else{
        	widgetName = null;
    	}
    };

    public String getWidgetName(){

    	setWidgetName();
    	return widgetName;
    };

    public boolean isWidgetExist(){

        try{
            setWidgetName();
            if (widgetName != null){
            	return widgetContainer.isDisplayed();
            }else{
            	return false;
            }
        }
        catch (NotFoundException e){
            return false;
        }
        catch (NullPointerException e){
            return false;
        }
    }

    protected WebElement getWidgetContentArea() throws NotFoundException{
    	
    	return widgetContainer.findElement(By.id("drag-contentarea"));
    };

    protected WebElement getCloseButton() throws NotFoundException{
    	
    	return widgetContainer.findElement(By.xpath(".//img[@title='Close']"));
    };

    public void clickOnCloseButton(){
    	
        getCloseButton().click();
        LOGGER.info("Widget close button was clicked");
    }

    public boolean isContentAreaDisplayed(){
	    return getWidgetContentArea().isDisplayed();
    }

    public void clickOnTabByAltText(String tabText){

    	String imageXpath = ".//img[@alt='" + tabText + "']";
		WebElement imageByAlt = widgetContainer.findElement(By.xpath(imageXpath));
		clickWidgetTabImage(imageByAlt);
    }
    
}
