package nymgoAutomation.tests.fragments.nymgo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.fragments.HasURL;
import nymgoAutomation.tests.navigation.Starter;

/*
 * 
 * Any Nymgo page  
 * 
 */

public class NymgoPageFragment extends BaseNymgoFragment implements HasURL{

	public NymgoPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlContains("nymgo.com"));
	}

}
