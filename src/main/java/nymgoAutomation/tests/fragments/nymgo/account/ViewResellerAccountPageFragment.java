package nymgoAutomation.tests.fragments.nymgo.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.enums.URL_CONST;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.generators.ServerGenerator;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public class ViewResellerAccountPageFragment extends BaseViewAccountFragment{
	
    public ViewResellerAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String VIEW_RESELLER_ACCOUNT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/account/account-details/account-profile";

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlToBe(VIEW_RESELLER_ACCOUNT_PAGE_URL));
	}
    
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return VIEW_RESELLER_ACCOUNT_PAGE_URL;
	}
	
}
