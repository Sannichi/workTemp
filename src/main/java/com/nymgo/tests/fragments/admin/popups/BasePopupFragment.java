package com.nymgo.tests.fragments.admin.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nymgo.tests.fragments.BaseFragment;

public class BasePopupFragment extends BaseFragment{

	public BasePopupFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		setPopupContainer();
	}

    private WebElement popup;

    private void setPopupContainer() throws NotFoundException{
    	
    	try{
        	popup = driver.findElement(By.id("facebox"));
    	}
    	catch(NoSuchElementException e){
    		LOGGER.fatal("Seems like Popup is absent on the screen");
    		popup = null;
    	}
    };

    public boolean isPopupExist(){

        try{
            setPopupContainer();
            return popup.isDisplayed();
        }
        catch (NotFoundException e){
            return false;
        }
        catch (NullPointerException e){
            return false;
        }
    }

    private WebElement getPopupContentArea() throws NotFoundException{
    	
    	if (popup != null){
    		return popup.findElement(By.xpath(".//div[@class='content']"));
    	}
    	else{
    		return null;
    	}
    };

    public String getPopupText() throws NotFoundException{
    	
    	WebElement popupContentArea = getPopupContentArea();
    	if(popupContentArea != null){
    		return getPopupContentArea().getText();
    	}
    	else{
    		return "";
    	}
    };

    public void clickOnCloseButton(){
    	
    	popup.findElement(By.xpath(".//img[@title='close']")).click();
        LOGGER.info("Popup close button was clicked");
    }
}
