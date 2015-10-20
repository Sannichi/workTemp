package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.enums.URL_CONST;
import nymgoAutomation.tests.fragments.HasURL;
import nymgoAutomation.tests.fragments.nymgo.base.BaseLoggedInFragment;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.generators.ServerGenerator;
import nymgoAutomation.tests.navigation.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditProceedPageAdyenFragment extends BaseLoggedInFragment implements HasURL{

	public BuyCreditProceedPageAdyenFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUY_CREDIT_PAGE_PROOCEED_ADYEN_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/proceed";	
	
	@FindBy(css = "input[data-encrypted-name='number']")
	private WebElement cardNumber;
	
	@FindBy(css = "input[data-encrypted-name='holderName']")
	private WebElement nameOnCard;
	
	@FindBy(css = "input[data-encrypted-name='expiryMonth']")
	private WebElement expiryMonthSelect;

	@FindBy(css = "input[data-encrypted-name='expiryYear']")
	private WebElement expiryYearSelect;

	@FindBy(css = "input[data-encrypted-name='cvc']")
	private WebElement cvv;
	
	@FindBy(css = "input[class='button-normal']")
	private WebElement payButton;
	
	@FindBy(css = "a[class='button-normal cancel']")
	private WebElement cancelButton;

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlToBe(BUY_CREDIT_PAGE_PROOCEED_ADYEN_URL));
			return true;
		}
		catch(TimeoutException e){
			return false;
		}
	}

	public void setCardNumberValue(String cardNumberValue){
		
		setTextToEditField(cardNumber, cardNumberValue);
	}
	
	public void selectExpireDateMonthByValue(String monthValue){
		
		selectValueFromSelectByValue(expiryMonthSelect, monthValue);
	}
	
	public void selectExpireDateYearByLCName(String yearValue){
		
		selectValueFromSelectByVisibleText(expiryYearSelect, yearValue);
	}
	
	public void setCVVValue(String cvvValue){
		
		setTextToEditField(cvv, cvvValue);
	}

	public void setCardholdersName(String cardholdersName){
		
		setTextToEditField(nameOnCard, cardholdersName);
	}

	public void clickPayButton(){
		
		clickInputButton(payButton);
	}

	public void clickCancelButton(){
		
		clickInputButton(cancelButton);
	}

	public String getSelectedExpireDateMonth(){
		
		Select select = new Select(expiryMonthSelect);
		return select.getFirstSelectedOption().getText();
	}
	
	public String getSelectedExpireDateYear(){
		
		Select select = new Select(expiryYearSelect);
		return select.getFirstSelectedOption().getText();
	}
}
