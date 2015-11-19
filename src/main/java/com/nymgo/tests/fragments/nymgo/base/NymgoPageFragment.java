package com.nymgo.tests.fragments.nymgo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.starter.Starter;

/*
 * 
 * Any Nymgo page  
 * 
 */

public class NymgoPageFragment extends BaseNymgoFragment{

	public NymgoPageFragment(WebDriver driver) {
		super(driver);
	}

	public boolean isCorrectURL() {

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlContains("nymgo.com"));
	}

	public String getCorrectURL() {

		return "*nymgo.com*";
	}
}
