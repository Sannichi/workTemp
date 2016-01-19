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

	private void setUsername(String username){
		normalAccountTransferCreditPageFragment.setUsername(username);
	}
	
	private void setAmount(String amount){
		normalAccountTransferCreditPageFragment.setAmount(amount);
	}
	
	private void setPassword(String password){
		normalAccountTransferCreditPageFragment.setPassword(password);
	}
	
	private void clickTransferButton(){
		normalAccountTransferCreditPageFragment.clickTransferButton();
	}

	//TODO instead of void
	public void setDataAndClickTransferCredit(String username, String password, String amount){
		setUsername(username);
		setPassword(password);
		setAmount(amount);
		clickTransferButton();
		
	}
}
