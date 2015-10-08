package nymgoAutomation.tests.fragments.admin.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.fragments.HasURL;
import nymgoAutomation.tests.navigation.Starter;

/*
 * 
 * Any Admin logged page with search possibility  
 * 
 */

public class AdminPageWithSearchFragment extends BaseLoggedAdminFragment implements HasURL{

	public AdminPageWithSearchFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlContains("admin.nymgo.com"));
	}
}
