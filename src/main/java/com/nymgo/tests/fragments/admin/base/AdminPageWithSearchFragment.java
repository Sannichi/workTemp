package com.nymgo.tests.fragments.admin.base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
/*
 * 
 * Any Admin logged page with search possibility  
 * 
 */
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.starter.Starter;

public class AdminPageWithSearchFragment extends BaseLoggedAdminPageWithSearchFragment{

	public AdminPageWithSearchFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlContains("admin.nymgo.com"));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return "*admin.nymgo.page*";
	}
}
