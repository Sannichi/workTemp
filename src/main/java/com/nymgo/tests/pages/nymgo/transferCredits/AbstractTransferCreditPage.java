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

	private void setUsername(String username){
		baseTransferCreditPageFragment.setUsername(username);
	}
	
	private void setAmount(String amount){
		baseTransferCreditPageFragment.setAmount(amount);
	}
	
	private void setPassword(String password){
		baseTransferCreditPageFragment.setPassword(password);
	}
	
	private void clickTransferButton(){
		baseTransferCreditPageFragment.clickTransferButton();
	}

	//TODO instead of void
	public void setDataAndClickTransferCredit(String username, String password, String amount){
		setUsername(username);
		setPassword(password);
		setAmount(amount);
		clickTransferButton();
		
	}
}
