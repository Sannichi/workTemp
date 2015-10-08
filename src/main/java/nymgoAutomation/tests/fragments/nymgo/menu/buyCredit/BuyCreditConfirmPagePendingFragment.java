package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.navigation.Starter;

public class BuyCreditConfirmPagePendingFragment extends BaseBuyCreditConfirmPageNextFragment{

	public BuyCreditConfirmPagePendingFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_PENDING_URL = "https://secure-dev.nymgo.com/gcreturn?REF=";	

	@Override
	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlContains(BUY_CREDIT_CONFIRM_PAGE_PENDING_URL));
	}

}
