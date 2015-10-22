package nymgoAutomation.tests.fragments.nymgo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.fragments.HasURL;
import nymgoAutomation.tests.starter.Starter;

/*
 * 
 * Any logged Nymgo page  
 * 
 */

public class LoggedNymgoPageFragment extends BaseLoggedInFragment implements HasURL{

	public LoggedNymgoPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlContains("nymgo.com"));
	}
}
