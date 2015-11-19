package com.nymgo.tests.fragments.nymgo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.fragments.nymgo.base.BaseNymgoFragment;
import com.nymgo.tests.starter.Starter;

public class HomePageFragment extends BaseNymgoFragment{

public HomePageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlToBe(getHomeURL()));
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return getHomeURL();
	}
}
