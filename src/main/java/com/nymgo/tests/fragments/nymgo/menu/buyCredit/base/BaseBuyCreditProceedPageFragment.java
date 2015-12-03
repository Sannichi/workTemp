package com.nymgo.tests.fragments.nymgo.menu.buyCredit.base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.nymgo.account.baseProfile.BaseProfileInfoFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

public class BaseBuyCreditProceedPageFragment extends BaseProfileInfoFragment{

	public BaseBuyCreditProceedPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	private static final String BUY_CREDIT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
	private static final String BUY_CREDIT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/proceed";	
			
	@FindBy(id = "payment_card")
	private WebElement paymentCardSelect;

	@FindBy(id = "country_of_credit")
	private WebElement countryOfCreditSelect;
	
/*	
	@FindBy(css = "div.float30[1]")
	private WebElement nymgoCredit;

	@FindBy(css = "div.float30[2]")
	private WebElement VAT;

	@FindBy(css = "div.float30[3]")
	private WebElement totalAmountCharged;
*/
	@FindBy(css = "div.float30")
	private List<WebElement> nymgoCreditVATAmount;

	@FindBy(id="save-el")
    private WebElement continueButton;

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlToBe(BUY_CREDIT_PAGE_URL));
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_PAGE_URL;
	}
	
	@Override
	public void setStreet(String street){
	
		setCity(street);
	}
	
	@Override
	public String getStreet(){
	
		return getCity();
	}

	public void clickContinueButton(){

		clickSubmitButton(continueButton);
	}

	public void selectPaymentCard(String paymentCardType){

		selectValueFromSelectByLocaleText(paymentCardSelect, paymentCardType);
	}
	
	public String getDefaultPaymentCardValue(){
		
		return LocaleGenerator.getLocaleKey(LOCALE_CONST.CARD_TYPE_SELECT);
	}

	public String getSelectedPaymentCard(){
		
		Select select = new Select(paymentCardSelect);
		return select.getFirstSelectedOption().getText();
	}

	public void selectCountryOfCredit(String countryOfCredit){

		selectValueFromSelectByLocaleText(countryOfCreditSelect, countryOfCredit);
	}

	public String getSelectedCountryOfCredit(){
		
		Select select = new Select(countryOfCreditSelect);
		return select.getFirstSelectedOption().getText();
	}

	public String getNymgoCreditValue(){
		
		return nymgoCreditVATAmount.get(0).getText().split("\n")[1].split(" ")[0];		
	}

	public String getVATValue(){
		
		return nymgoCreditVATAmount.get(1).getText().split("\n")[1];
	}

	public String getTotalAmountChargedValue(){
		
		return nymgoCreditVATAmount.get(2).getText().split("\n")[1].split(" ")[0];
	}

}
