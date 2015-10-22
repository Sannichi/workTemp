package nymgoAutomation.tests.fragments.admin.base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.fragments.HasURL;
import nymgoAutomation.tests.starter.Starter;

/*
 * 
 * Any Admin logged page  
 * 
 */

public class AdminPageFragment extends BaseLoggedAdminFragment implements HasURL{

	public AdminPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlContains("admin.nymgo.com"));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}
}
