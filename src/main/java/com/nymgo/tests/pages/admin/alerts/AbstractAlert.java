package com.nymgo.tests.pages.admin.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.pages.AbstractPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public abstract class AbstractAlert extends AbstractPage{

	public AbstractAlert(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
	}

	private Alert alert;
	
	public void setAlert() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Starter.ELEMENT_WAIT_TIME);
	        wait.until(ExpectedConditions.alertIsPresent());
	        alert = driver.switchTo().alert();
//	        LOGGER.info("Alert detected with text '" + alert.getText() + "'");
	    } catch (Exception e) {
	        //exception handling
	    	LOGGER.fatal("Alert Exception is handling");
	    	alert = new Alert() {
				
				@Override
				public void setCredentials(Credentials arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void sendKeys(String arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public String getText() {
					// TODO Auto-generated method stub
					return "No Alert!";
				}
				
				@Override
				public void dismiss() {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void authenticateUsing(Credentials arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void accept() {
					// TODO Auto-generated method stub
					
				}
			};
	    }
	}

	public String getAlertText(){
		
		setAlert();
        LOGGER.info("Alert detected with text '" + alert.getText() + "'");		
		return alert.getText();
	}

	public void acceptAlert() {
			
		setAlert();
		alert.accept();
		LOGGER.info("Alert is accepted");
		driver.switchTo().defaultContent();
	}
	
}
