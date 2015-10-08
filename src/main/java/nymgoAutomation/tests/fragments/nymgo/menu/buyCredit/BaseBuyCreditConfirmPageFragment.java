package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import nymgoAutomation.tests.fragments.HasURL;
import nymgoAutomation.tests.fragments.nymgo.base.BaseLoggedInFragment;
import nymgoAutomation.tests.navigation.Starter;

public abstract class BaseBuyCreditConfirmPageFragment extends BaseLoggedInFragment implements HasURL{

	public BaseBuyCreditConfirmPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
    	driver.manage().timeouts().implicitlyWait(Starter.IFRAME_WAIT_TIME, TimeUnit.SECONDS);
    	driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
    	driver.manage().timeouts().implicitlyWait(Starter.IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);
	}
/*	
	private static final String BUY_CREDIT_CONFIRM_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/generate";	

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlToBe(BUY_CREDIT_CONFIRM_PAGE_URL));
	}
*/	
}
