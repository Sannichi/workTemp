package com.nymgo.tests.fragments.nymgo.account;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseLoggedInFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;
/**
 * Created by Iuliia Khikmatova on Mar 16, 2016
 */
public class ViewMastersListPageFragment extends BaseLoggedInFragment{
	
    public ViewMastersListPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String VIEW_MASTERS_LIST_PAGE_URL = Starter.SECURE_PART +	
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/master-resellers/view-master-list";

	@Override
	public boolean isCorrectURL() {

		WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlToBe(VIEW_MASTERS_LIST_PAGE_URL));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return VIEW_MASTERS_LIST_PAGE_URL;
	}

}
