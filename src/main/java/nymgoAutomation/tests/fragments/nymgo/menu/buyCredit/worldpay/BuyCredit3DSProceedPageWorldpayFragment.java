package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.worldpay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.base.BaseBuyCredit3DSProceedPageFragment;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
//public class BuyCreditProceedPageWorldpayFragment extends BaseBuyCreditProceedPageFragment{
public class BuyCredit3DSProceedPageWorldpayFragment extends BaseBuyCredit3DSProceedPageFragment{

	public BuyCredit3DSProceedPageWorldpayFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css = "input[data-worldpay='number']")
	private WebElement cardNumber;
	
	@FindBy(css = "input[data-worldpay='name']")
	private WebElement nameOnCard;
	
	@FindBy(css = "select[data-worldpay='exp-month']")
	private WebElement expiryMonthSelect;

	@FindBy(css = "select[data-worldpay='exp-year']")
	private WebElement expiryYearSelect;

	@FindBy(css = "input[data-worldpay='cvc']")
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
