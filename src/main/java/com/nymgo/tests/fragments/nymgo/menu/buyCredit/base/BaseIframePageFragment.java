package com.nymgo.tests.fragments.nymgo.menu.buyCredit.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;

import com.nymgo.tests.fragments.BaseFragment;
import com.nymgo.tests.starter.Starter;

//public abstract class BaseIframePageFragment extends BaseTransactionFragment{
public abstract class BaseIframePageFragment extends BaseFragment{

	public BaseIframePageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
    	driver.manage().timeouts().implicitlyWait(Starter.IFRAME_WAIT_TIME, TimeUnit.SECONDS);
    	driver.switchTo().defaultContent();
    	try{
    		driver.switchTo().frame(0);
    	}
    	catch(NoSuchFrameException e){
    		LOGGER.fatal("There is no Iframe element on the page");
    	}
    	driver.manage().timeouts().implicitlyWait(Starter.IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);
	}
}
