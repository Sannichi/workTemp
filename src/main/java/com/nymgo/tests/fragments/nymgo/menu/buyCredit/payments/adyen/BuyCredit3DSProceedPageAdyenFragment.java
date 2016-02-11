package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.adyen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.BaseBuyCredit3DSProceedPageFragment;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */

//public class BuyCredit3DSProceedPageAdyenFragment extends BaseLoggedInFragment{
public class BuyCredit3DSProceedPageAdyenFragment extends BaseBuyCredit3DSProceedPageFragment{
	
	public BuyCredit3DSProceedPageAdyenFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
/*
	private static final String BUY_CREDIT_PAGE_PROOCEED_ADYEN_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/proceed";	
*/	
	@FindBy(css = "input[data-encrypted-name='number']")
	private WebElement cardNumber;
	
	@FindBy(css = "input[data-encrypted-name='holderName']")
	private WebElement nameOnCard;
	
	@FindBy(css = "select[data-encrypted-name='expiryMonth']")
	private WebElement expiryMonthSelect;

	@FindBy(css = "select[data-encrypted-name='expiryYear']")
	private WebElement expiryYearSelect;

	@FindBy(css = "input[data-encrypted-name='cvc']")
	private WebElement cvv;
/*	
	@FindBy(css = "input[class='button-normal']")
	private WebElement payButton;
	
	@FindBy(css = "a[class='button-normal cancel']")
	private WebElement cancelButton;
*/
/*	
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

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_PAGE_PROOCEED_ADYEN_URL;
	}
*/
	public void setCardNumber(String cardNumberValue){
		
		setTextToEditField(cardNumber, cardNumberValue);
	}
	
	public String getCardNumber(){
		
		return cardNumber.getText();
	}
	
	public void selectExpireDateMonthByValue(String monthValue){
		
		selectValueFromSelectByValue(expiryMonthSelect, monthValue);
	}
	
	public String getSelectedExpireDateMonthValue(){
		
		Select select = new Select(expiryMonthSelect);
		return select.getFirstSelectedOption().getCssValue("value");
	}
	
	public String getSelectedExpireDateMonth(){
		
		Select select = new Select(expiryMonthSelect);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectExpireDateYearByLCName(String yearValue){
		
		selectValueFromSelectByVisibleText(expiryYearSelect, yearValue);
	}
	
	public String getSelectedExpireDateYear(){
		
		Select select = new Select(expiryYearSelect);
		return select.getFirstSelectedOption().getText();
	}
	
	public void setCVV(String cvvValue){
		
		setTextToEditField(cvv, cvvValue);
	}

	public String getCVV(){
		
		return cvv.getText();
	}
	
	public void setCardholdersName(String cardholdersName){
		
		setTextToEditField(nameOnCard, cardholdersName);
	}

	public String getCardholdersName(){
		
		return nameOnCard.getText();
	}
/*	
	public void clickPayButton(){
		
		clickInputButton(payButton);
	}

	public void clickCancelButton(){
		
		clickInputButton(cancelButton);
	}
*/}
