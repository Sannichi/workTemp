package com.nymgo.tests.fragments.nymgo.transactions;

import org.openqa.selenium.WebDriver;
/**
 * Created by Iuliia Khikmatova on Oct 23, 2015
 */
public class PendingIframeTransactionFragment extends BaseIframeTransactionFragment{

	public PendingTransactionFragment pendingTransactionFragment;
	
	public PendingIframeTransactionFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		pendingTransactionFragment = new PendingTransactionFragment(driver);
	}

}
