package nymgoAutomation.tests.fragments.nymgo;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.fragments.nymgo.base.BaseNymgoFragment;
import nymgoAutomation.tests.navigation.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public class SecureHomePageFragment extends BaseNymgoFragment{


	public SecureHomePageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	try{
    		wait.until(ExpectedConditions.urlToBe(getSecureHomeURL()));
    		return true;
    	}
    	catch(TimeoutException e){
    		return false;	
    	}
	}
}
