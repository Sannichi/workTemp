package com.nymgo.tests.fragments.nymgo.fancyboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nymgo.tests.fragments.BaseFragment;

/**
 * Created by Iuliia Khikmatova on Mar 09, 2016
 */
public class BaseFancyboxFragment extends BaseFragment{

	public BaseFancyboxFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		setFancyboxContainer();
	}

    private WebElement fancybox;

    private void setFancyboxContainer() throws NotFoundException{
    	
    	try{
    		fancybox = driver.findElement(By.xpath("//div[@class='fancybox-wrap fancybox-desktop fancybox-type-inline fancybox-opened']"));
    	}
    	catch(NoSuchElementException e){
    		LOGGER.fatal("Seems like Fancybox is absent on the screen");
    		fancybox = null;
    	}
    };

    public boolean isFancyboxExist(){

        try{
            setFancyboxContainer();
            return fancybox.isDisplayed();
        }
        catch (NotFoundException e){
            return false;
        }
        catch (NullPointerException e){
            return false;
        }
    }

    public void clickOnCloseButton(){
    	
    	fancybox.findElement(By.xpath(".//a[@class='fancybox-item fancybox-close']")).click();
        LOGGER.info("Fancybox close button was clicked");
    }
}
