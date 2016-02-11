package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.transactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by Iuliia Khikmatova on Feb 8, 2016
 */
public class SuccessfulTransactionFragment extends BaseTransactionFragment{

	public SuccessfulTransactionFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(className = "button-normal")
	private WebElement backToDashboardButton;

	public void clickBackToDashboardButton(){
		
		clickButton(backToDashboardButton);
	}
}
