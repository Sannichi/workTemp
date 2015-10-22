package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.starter.Starter;

public class BaseBuyCreditConfirmPageNextFragment extends BaseBuyCreditConfirmPageFragment{

	public BaseBuyCreditConfirmPageNextFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.IFRAME_WAIT_TIME);
    	wait.until(ExpectedConditions.visibilityOf(backToDashboardButton));
	}

	@FindBy(className = "button-normal")
	private WebElement backToDashboardButton;

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void clickBackToDashboardButton(){
		
		clickButton(backToDashboardButton);
	}
	
	public boolean isTransactionPending(){
		
		return getPaymentStatus().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.PAYMENT_PENDING));
	}
}
