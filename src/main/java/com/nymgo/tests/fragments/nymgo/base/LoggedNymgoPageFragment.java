package com.nymgo.tests.fragments.nymgo.base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.starter.Starter;
/*
 * 
 * Any logged Nymgo page  
 * 
 */
public class LoggedNymgoPageFragment extends BaseLoggedInFragment{

	public LoggedNymgoPageFragment(WebDriver driver) {
		super(driver);
	}

	public boolean isCorrectURL() {

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlContains("nymgo.com"));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {

		return "*nymgo.com*";
	}
}
