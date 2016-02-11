package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.transactions;

import org.openqa.selenium.WebDriver;
/**
 * Created by Iuliia Khikmatova on Feb 8, 2016
 */
public class SuccessfulIframeTransactionFragment extends BaseIframeTransactionFragment{

	public SuccessfulTransactionFragment successfulTransactionFragment;
	
	public SuccessfulIframeTransactionFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		successfulTransactionFragment = new SuccessfulTransactionFragment(driver);
	}

}
