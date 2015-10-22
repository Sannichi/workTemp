package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import nymgoAutomation.tests.fragments.HasURL;
import nymgoAutomation.tests.starter.Starter;

public abstract class BaseBuyCreditConfirmPageFragment extends BaseTransactionFragment implements HasURL{

	public BaseBuyCreditConfirmPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
    	driver.manage().timeouts().implicitlyWait(Starter.IFRAME_WAIT_TIME, TimeUnit.SECONDS);
    	driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
    	driver.manage().timeouts().implicitlyWait(Starter.IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);
	}
}
