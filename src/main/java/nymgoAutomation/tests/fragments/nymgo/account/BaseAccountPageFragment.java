package nymgoAutomation.tests.fragments.nymgo.account;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.enums.URL_CONST;
import nymgoAutomation.tests.fragments.nymgo.base.BaseLoggedInFragment;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.generators.ServerGenerator;
import nymgoAutomation.tests.navigation.Starter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAccountPageFragment extends BaseLoggedInFragment{
	
	public BaseAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String ACCOUNT_PAGE_URL_EN = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/user/dashboard";
	
	private static final String language = LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL);
	
	private static final String accountMyBalanceBlockClassName = "block my-balance";
	private static final String accountBuyCreditXpath = "//div[@class='" + accountMyBalanceBlockClassName + "']//a[@href='" + language + "/buy-credits']";
	
	private WebElement accountBuyCreditButton;

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlToBe(ACCOUNT_PAGE_URL_EN));
	}
    
	private void initializeBuyCreditButton() throws NoSuchElementException{
		
		accountBuyCreditButton = driver.findElement(By.xpath(accountBuyCreditXpath));
	}
	
	public void clickAccountBuyCreditButton(){
		
		initializeBuyCreditButton();
//		accountBuyCreditButton.click();
		clickSubmitButton(accountBuyCreditButton);
	}
}
