package com.nymgo.tests.pages.nymgo.transferCredits;

import org.openqa.selenium.WebElement;

import com.nymgo.tests.fragments.nymgo.transferCredits.BaseTransferCreditPageFragment;
import com.nymgo.tests.fragments.nymgo.transferCredits.TransferCreditData;
import com.nymgo.tests.navigation.FancyboxNavigation;
import com.nymgo.tests.pages.nymgo.base.LoggedNymgoPage;
import com.nymgo.tests.pages.nymgo.fancyboxes.ConfirmTransferFancybox;
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
	public ConfirmTransferFancybox setDataAndClickTransferCredit(String username, String password, String transferAmount){
		setUsername(username);
		setPassword(password);
		setAmount(transferAmount);
		clickTransferButton();
		ConfirmTransferFancybox confirmTransferFancybox = new ConfirmTransferFancybox(starter);
		FancyboxNavigation<ConfirmTransferFancybox> navigation = new FancyboxNavigation<ConfirmTransferFancybox>(confirmTransferFancybox);
		navigation.NavigatedTo();
		return confirmTransferFancybox;
	}

	public TransferCreditData getLastTransferData(){
		
		return baseTransferCreditPageFragment.getLastTransferData();
	}
	
	public String getLastTransferActivity(){
		
		return baseTransferCreditPageFragment.getLastTransferActivity();
	}

	public String getLastTransferSender(){
		
		return baseTransferCreditPageFragment.getLastTransferSender();
	}
	
	public String getLastTransferRecipient(){
		
		return baseTransferCreditPageFragment.getLastTransferRecipient();
	}
	
	public String getLastTransferAmount(){
		
		return baseTransferCreditPageFragment.getLastTransferAmount();
	}
}
