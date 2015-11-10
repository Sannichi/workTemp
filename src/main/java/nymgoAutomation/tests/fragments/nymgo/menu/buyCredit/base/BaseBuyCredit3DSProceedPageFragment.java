package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.enums.URL_CONST;
import nymgoAutomation.tests.fragments.nymgo.base.BaseLoggedInFragment;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.generators.ServerGenerator;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Nov 10, 2015
 */
public class BaseBuyCredit3DSProceedPageFragment extends BaseLoggedInFragment{
	
	public BaseBuyCredit3DSProceedPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUY_CREDIT_3DS_PAGE_PROOCEED_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/proceed";	
	
	@FindBy(css = "input[class='button-normal']")
	private WebElement payButton;
	
	@FindBy(css = "a[class='button-normal cancel']")
	private WebElement cancelButton;

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlToBe(BUY_CREDIT_3DS_PAGE_PROOCEED_URL));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_3DS_PAGE_PROOCEED_URL;
	}
	
	public void clickPayButton(){
		
		clickInputButton(payButton);
	}

	public void clickCancelButton(){
		
		clickInputButton(cancelButton);
	}
}
