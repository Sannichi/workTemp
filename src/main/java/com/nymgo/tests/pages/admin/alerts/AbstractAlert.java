package com.nymgo.tests.pages.admin.alerts;

import org.openqa.selenium.Alert;
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
