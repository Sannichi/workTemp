package com.nymgo.tests.fragments.nymgo.menu.buyCredit.globalCollect;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.base.BaseBuyCredit3DSProceedPageFragment;
/**
 * Created by Iuliia Khikmatova on Feb 05, 2016
 */
public class BuyCredit3DSProceedPageGlobalCollectFragment extends BaseBuyCredit3DSProceedPageFragment{

	public BuyCredit3DSProceedPageGlobalCollectFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

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
}
