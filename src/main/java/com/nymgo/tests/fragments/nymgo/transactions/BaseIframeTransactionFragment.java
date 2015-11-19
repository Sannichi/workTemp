package com.nymgo.tests.fragments.nymgo.transactions;

import org.openqa.selenium.WebDriver;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.base.BaseIframePageFragment;

/**
 * Created by Iuliia Khikmatova on Oct 21, 2015
 */
public class BaseIframeTransactionFragment extends BaseIframePageFragment{
	
	public BaseTransactionFragment baseTransactionFragment;
	
	public BaseIframeTransactionFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		baseTransactionFragment = new BaseTransactionFragment(driver);
	}
}
