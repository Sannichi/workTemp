package com.nymgo.tests.fragments.admin;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.admin.base.BaseLoggedAdminFragment;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

public class HomeAdminPageFragment extends BaseLoggedAdminFragment{

	public HomeAdminPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String HOME_PAGE_URL_ENG = ServerGenerator.getServerKey(URL_CONST.ADMIN_URL); 
			
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlMatches(HOME_PAGE_URL_ENG));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return HOME_PAGE_URL_ENG;
	}
}
