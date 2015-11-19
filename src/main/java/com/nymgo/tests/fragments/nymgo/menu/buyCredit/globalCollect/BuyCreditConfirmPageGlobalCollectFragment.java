package com.nymgo.tests.fragments.nymgo.menu.buyCredit.globalCollect;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.base.BaseIframePageFragment;
import com.nymgo.tests.starter.Starter;

public class BuyCreditConfirmPageGlobalCollectFragment extends BaseIframePageFragment{

	public BuyCreditConfirmPageGlobalCollectFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.IFRAME_WAIT_TIME);
    	try{
    		wait.until(ExpectedConditions.visibilityOf(cardNumber));
    	}
    	catch(TimeoutException e){
    		LOGGER.fatal("There is no element CardNumber on this page");
    	}
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_GC_URL = "https://eu.gcsip.nl/orb/orb?ACTION=DO_START&REF=";	

	@FindBy(name = "CREDITCARDNUMBER")
	private WebElement cardNumber;
	
	@FindBy(name = "EXPIRYDATE_MM")
	private WebElement expireDateMonth;

	@FindBy(name = "EXPIRYDATE_YY")
	private WebElement expireDateYear;

	@FindBy(name = "CVV")
	private WebElement cvv;

	@FindBy(id = "btnSubmit")
	private WebElement continueButton;

	@FindBy(id = "btnCancel")
	private WebElement cancelButton;
	
	public boolean isCorrectURL(){

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlContains(BUY_CREDIT_CONFIRM_PAGE_GC_URL));
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_CONFIRM_PAGE_GC_URL;
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

	public void clickContinueButton(){
		
		clickInputButton(continueButton);
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
