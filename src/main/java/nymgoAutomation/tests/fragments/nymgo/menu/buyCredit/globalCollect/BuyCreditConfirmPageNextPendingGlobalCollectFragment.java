package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.globalCollect;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.base.BaseBuyCreditConfirmPageNextFragment;
import nymgoAutomation.tests.starter.Starter;

public class BuyCreditConfirmPageNextPendingGlobalCollectFragment extends BaseBuyCreditConfirmPageNextFragment{

	public BuyCreditConfirmPageNextPendingGlobalCollectFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL = "https://secure-dev.nymgo.com/gcreturn?REF=";	

	@Override
	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlContains(BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL));
	}

}
