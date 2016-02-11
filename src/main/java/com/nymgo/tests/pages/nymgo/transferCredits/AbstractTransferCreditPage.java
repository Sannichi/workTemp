package com.nymgo.tests.pages.nymgo.transferCredits;

import com.nymgo.tests.fragments.nymgo.transferCredits.BaseTransferCreditPageFragment;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 30, 2015
 */
public abstract class AbstractTransferCreditPage extends LoggedNymgoPage {
	
	BaseTransferCreditPageFragment baseTransferCreditPageFragment;

	public AbstractTransferCreditPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseTransferCreditPageFragment = new BaseTransferCreditPageFragment(driver);
	}

}
