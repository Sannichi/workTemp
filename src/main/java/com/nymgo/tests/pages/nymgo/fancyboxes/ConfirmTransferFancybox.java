package com.nymgo.tests.pages.nymgo.fancyboxes;

import com.nymgo.tests.fragments.nymgo.fancyboxes.MasterRechargeAccountFancyboxFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.transferCredits.NormalAccountTransferCreditPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Mar 10, 2016
 */
public class ConfirmTransferFancybox extends AbstractFancybox {
	
	private MasterRechargeAccountFancyboxFragment masterRechargeAccountFancyboxFragment;

	public ConfirmTransferFancybox(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		masterRechargeAccountFancyboxFragment = new MasterRechargeAccountFancyboxFragment(driver);
	}

	private static final String CONFIRM_TRANSFER_NAME_ENG = "ConfirmTransferFancybox"; 
	private static final String CONFIRM_TRANSFER_TEXT_ENG = "Confirm Transfer"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return CONFIRM_TRANSFER_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return getHelpText().contains(CONFIRM_TRANSFER_TEXT_ENG);
	}
	
	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return CONFIRM_TRANSFER_TEXT_ENG;
	}

	public String getHelpText(){
		
		return masterRechargeAccountFancyboxFragment.getHelpText();
	}

	public void setAmount(String amount){
		masterRechargeAccountFancyboxFragment.setAmount(amount);
	}

	public void clickSendButton(){
		masterRechargeAccountFancyboxFragment.clickSend();
	}

	public void clickCancelButton(){
		masterRechargeAccountFancyboxFragment.clickCancel();
	}
	
	public NormalAccountTransferCreditPage clickSendAmountNormalAccount(){
		
		clickSendButton();
		NormalAccountTransferCreditPage normalAccountTransferCreditPage = new NormalAccountTransferCreditPage(starter);
		PageNavigation<NormalAccountTransferCreditPage> navigation = new PageNavigation<NormalAccountTransferCreditPage>(normalAccountTransferCreditPage);
		navigation.NavigatedTo();
		return normalAccountTransferCreditPage;
	}
}
