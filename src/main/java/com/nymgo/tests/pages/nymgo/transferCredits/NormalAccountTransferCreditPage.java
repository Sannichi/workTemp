package com.nymgo.tests.pages.nymgo.transferCredits;

import com.nymgo.tests.fragments.nymgo.transferCredits.NormalAccountTransferCreditPageFragment;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 30, 2015
 */
public class NormalAccountTransferCreditPage extends AbstractTransferCreditPage {

	NormalAccountTransferCreditPageFragment normalAccountTransferCreditPageFragment;
	
	public NormalAccountTransferCreditPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		normalAccountTransferCreditPageFragment = new NormalAccountTransferCreditPageFragment(driver);
	}

}
