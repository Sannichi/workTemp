package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.generators.LocaleGenerator;
//import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.navigation.Starter;

public class BaseBuyCreditConfirmPageNextFragment extends BaseBuyCreditConfirmPageFragment{

	public BaseBuyCreditConfirmPageNextFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.IFRAME_WAIT_TIME);
    	wait.until(ExpectedConditions.visibilityOf(backToDashboardButton));
	}

	@FindBy(css = "div[class='padd']")
	private List<WebElement> paddsList;

	@FindBy(className = "button-normal")
	private WebElement backToDashboardButton;

	@FindBy(css = "div.float30")
	private List<WebElement> amountNumberDate;
	
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getPaymentStatus(){
		
		return paddsList.get(0).getText();		
	}

	public void clickBackToDashboardButton(){
		
//		backToDashboardButton.click();
		clickButton(backToDashboardButton);
	}

	public String getTransactionAmountValue(){
		
		return amountNumberDate.get(0).getText().split("\n")[1].split(" ")[0];		
	}

	public String getTransactionNumber(){
		
		return amountNumberDate.get(1).getText().split("\n")[1];
	}

	public String getTransactionDate(){
		
		return amountNumberDate.get(2).getText().split("\n")[1].split(" ")[0];
	}

	public String getTransactionTime(){
		
		return amountNumberDate.get(2).getText().split("\n")[1].split(" ")[1];
	}
	
	public boolean isTransactionPending(){
		
		return getPaymentStatus().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.PAYMENT_PENDING));
	}
}
