package nymgoAutomation.tests.fragments.nymgo.transactions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.base.BaseIframePageFragment;
import nymgoAutomation.tests.generators.LocaleGenerator;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public class BaseIframeTransactionFragment extends BaseIframePageFragment{
	
	public BaseIframeTransactionFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "div[class='padd']")
	private List<WebElement> paddsList;

	@FindBy(css = "div.float30")
	private List<WebElement> amountNumberDate;

	public String getPaymentStatus(){
		
		return paddsList.get(0).getText();		
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

	public boolean isTransactionDeclined(){
		
		return getPaymentStatus().equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.PAYMENT_DECLINED));
	}
}
