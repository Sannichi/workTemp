package com.nymgo.tests.fragments.admin;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 28, 2015
 */
public class BusinessTransactionsAdminPageFragment extends BaseTransactionsAdminPageFragment{

	public BusinessTransactionsAdminPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@href='/modules/bus_proccessed_transactions/index.php']")
	private WebElement declinedTransactionsLink;
		
	private static final String BUSINESS_TRANSACTIONS_PAGE_URL_ENG = ServerGenerator.getServerKey(URL_CONST.ADMIN_URL) + "/modules/bus_transactions/index.php"; 
	
	@Override
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlMatches(BUSINESS_TRANSACTIONS_PAGE_URL_ENG));
			return true;
		}
    	catch(TimeoutException e){
    		return false;
    	}
	}

	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUSINESS_TRANSACTIONS_PAGE_URL_ENG;
	}

	public void clickDeclinedTransactionsLink()
	{
		
    	clickLink(declinedTransactionsLink);
	}
}
