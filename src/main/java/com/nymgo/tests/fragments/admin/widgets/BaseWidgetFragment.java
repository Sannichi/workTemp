package com.nymgo.tests.fragments.admin.widgets;

import org.openqa.selenium.By;
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
    	
    	widgetContainer = driver.findElement(By.id("widjectWindow"));
    };

    protected void setWidgetName() throws NotFoundException{
    	
    	setWidgetContainer();
    	widgetName = widgetContainer.findElement(By.xpath(".//div[@class='drag-handle']")).getText().split("\n")[0];
    };

    public String getWidgetName(){

    	setWidgetName();
    	return widgetName;
    };

    public boolean isWidgetExist(){

        try{
//            setWidgetContainer();
            setWidgetName();
        }
        catch (NotFoundException e){
            return false;
        }
        return widgetContainer.isDisplayed();
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
//		imageByAlt.click();
		clickWidgetTabImage(imageByAlt);
    }
    
}
