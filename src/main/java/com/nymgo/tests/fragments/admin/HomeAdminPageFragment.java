package com.nymgo.tests.fragments.admin;

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
    	return wait.until(ExpectedConditions.urlMatches(HOME_PAGE_URL_ENG));
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return HOME_PAGE_URL_ENG;
	}
}