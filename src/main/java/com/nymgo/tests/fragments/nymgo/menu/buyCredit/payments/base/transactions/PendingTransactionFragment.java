package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.transactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by Iuliia Khikmatova on Nov 10, 2015
 */
public class PendingTransactionFragment extends BaseTransactionFragment{

	public PendingTransactionFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(className = "button-normal")
	private WebElement backToDashboardButton;

	public void clickBackToDashboardButton(){
		
		clickButton(backToDashboardButton);
	}
}
