package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.globalCollect;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.fragments.nymgo.transactions.PendingTransactionFragment;
import nymgoAutomation.tests.starter.Starter;

public class PendingTransactionGlobalCollectFragment extends PendingTransactionFragment{

	public PendingTransactionGlobalCollectFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL = "https://secure-dev.nymgo.com/gcreturn?REF=";	

	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlContains(BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL));
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL;
	}

}
