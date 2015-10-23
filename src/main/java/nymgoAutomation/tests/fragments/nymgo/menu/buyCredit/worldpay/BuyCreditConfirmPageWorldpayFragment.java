package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.worldpay;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.base.BaseIframePageFragment;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditConfirmPageWorldpayFragment extends BaseIframePageFragment{

	public BuyCreditConfirmPageWorldpayFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.IFRAME_WAIT_TIME);
    	wait.until(ExpectedConditions.visibilityOf(cardNumber));
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_WP_URL = "https://secure-test.worldpay.com/wcc/card?Lang=";	

	@FindBy(id = "cardNoInput")
	private WebElement cardNumber;
	
	@FindBy(name = "cardExp.month")
	private WebElement expireDateMonth;

	@FindBy(name = "cardExp.year")
	private WebElement expireDateYear;

	@FindBy(id = "cardCVV")
	private WebElement cvv;

	@FindBy(id = "name")
	private WebElement nameOnCard;

	@FindBy(id = "op-PMMakePayment")
	private WebElement makePaymentButton;

	@FindBy(css = "img[src='/i/300210/cancel.png']")
	private WebElement cancelButton;
	
	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	try{
    		wait.until(ExpectedConditions.urlContains(BUY_CREDIT_CONFIRM_PAGE_WP_URL));
    		return true;
    	}
    	catch(TimeoutException e){
    		return false;
    	}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_WP_URL;
	}
	
	public void setCardNumberValue(String cardNumberValue){
		
		setTextToEditField(cardNumber, cardNumberValue);
	}
	
	public void selectExpireDateMonthByLCName(String monthValue){
		
		selectValueFromSelectByVisibleText(expireDateMonth, monthValue);
	}
	
	public void selectExpireDateYearByLCName(String yearValue){
		
		selectValueFromSelectByVisibleText(expireDateYear, yearValue);
	}
	
	public void setCVVValue(String cvvValue){
		
		setTextToEditField(cvv, cvvValue);
	}

	public void setCardholdersName(String cardholdersName){
		
		setTextToEditField(nameOnCard, cardholdersName);
	}

	public void clickMakePaymentButton(){
		
		clickInputButton(makePaymentButton);
	}

	public void clickCancelButton(){
		
		clickInputButton(cancelButton);
	}

	public String getSelectedExpireDateMonth(){
		
		Select select = new Select(expireDateMonth);
		return select.getFirstSelectedOption().getText();
	}
	
	public String getSelectedExpireDateYear(){
		
		Select select = new Select(expireDateYear);
		return select.getFirstSelectedOption().getText();
	}

}
