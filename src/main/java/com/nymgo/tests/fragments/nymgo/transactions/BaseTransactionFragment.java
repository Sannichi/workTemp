package com.nymgo.tests.fragments.nymgo.transactions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.BaseFragment;
import com.nymgo.tests.generators.LocaleGenerator;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public class BaseTransactionFragment extends BaseFragment{
	
	public BaseTransactionFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "div[class='padd']")
	private List<WebElement> paddsList;

	@FindBy(css = "div.float30")
	private List<WebElement> amountNumberDate;

	public String getPaymentStatus(){
		
		if(paddsList.size() > 0){
			return paddsList.get(0).getText();
		}
		else{
			return "There is no line with Payment Status";
		}
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
