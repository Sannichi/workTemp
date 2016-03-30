package com.nymgo.tests.pages.nymgo.fancyboxes;

import com.nymgo.tests.fragments.nymgo.fancyboxes.MasterRechargeAccountFancyboxFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.account.ViewMastersListPage;
import com.nymgo.tests.pages.nymgo.account.ViewResellerListPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Mar 10, 2016
 */
public class MasterRechargeAccountFancybox extends AbstractFancybox {
	
	private MasterRechargeAccountFancyboxFragment masterRechargeAccountFancyboxFragment;

	public MasterRechargeAccountFancybox(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		masterRechargeAccountFancyboxFragment = new MasterRechargeAccountFancyboxFragment(driver);
	}

	private static final String MASTER_RECHARGE_ACCOUNT_NAME_ENG = "MasterRechargeAccountFancybox"; 
	private static final String MASTER_RECHARGE_ACCOUNT_TEXT_ENG = "Recharge account"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return MASTER_RECHARGE_ACCOUNT_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return getHelpText().contains(MASTER_RECHARGE_ACCOUNT_TEXT_ENG);
	}
	
	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return MASTER_RECHARGE_ACCOUNT_TEXT_ENG;
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
	
	public ViewResellerListPage setResellerAmountAndClickSend(String transferAmount){
		
		setAmount(transferAmount);
		clickSendButton();
		ViewResellerListPage viewResellerListPage = new ViewResellerListPage(starter);
		PageNavigation<ViewResellerListPage> navigation = new PageNavigation<ViewResellerListPage>(viewResellerListPage);
		navigation.NavigatedTo();
		return viewResellerListPage;
	}

	public ViewMastersListPage setMasterAmountAndClickSend(String transferAmount){
		
		setAmount(transferAmount);
		clickSendButton();
		ViewMastersListPage viewMastersListPage = new ViewMastersListPage(starter);
		PageNavigation<ViewMastersListPage> navigation = new PageNavigation<ViewMastersListPage>(viewMastersListPage);
		navigation.NavigatedTo();
		return viewMastersListPage;
	}
}
