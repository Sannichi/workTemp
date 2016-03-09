package com.nymgo.tests.pages.nymgo.transferCredits;

import com.nymgo.tests.fragments.nymgo.transferCredits.ResellerAccountTransferCreditPageFragment;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Mar 09, 2016
 */
public class ResellerAccountTransferCreditPage extends AbstractTransferCreditPage {

	ResellerAccountTransferCreditPageFragment resellerAccountTransferCreditPageFragment;
	
	public ResellerAccountTransferCreditPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		resellerAccountTransferCreditPageFragment = new ResellerAccountTransferCreditPageFragment(driver);
	}

}
