package com.nymgo.tests.pages.nymgo.account;

import com.nymgo.tests.fragments.nymgo.account.BaseMasterResellerTransferCreditPageFragment;
import com.nymgo.tests.navigation.FancyboxNavigation;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.pages.nymgo.fancyboxes.MasterRechargeAccountFancybox;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Mar 16, 2016
 */
public abstract class AbstractMasterResellerTransferCreditPage extends AbstractLoggedInPage {
	
	private BaseMasterResellerTransferCreditPageFragment baseMasterResellerTransferCreditPageFragment;

	public AbstractMasterResellerTransferCreditPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseMasterResellerTransferCreditPageFragment = new BaseMasterResellerTransferCreditPageFragment(driver);
	}

	public String getAccountBalanceValue(){
		
		return baseMasterResellerTransferCreditPageFragment.getAccountBalanceValue();
	}

	public String getResellerBalanceCurrencyByResellerName(String resellerName){
		
		return baseMasterResellerTransferCreditPageFragment.getResellerBalanceCurrencyByResellerName(resellerName);
	}

	public String getResellerBalanceValueByResellerName(String resellerName){
		
		return baseMasterResellerTransferCreditPageFragment.getResellerBalanceValueByResellerName(resellerName);
	}
	
	public MasterRechargeAccountFancybox clickTransferCreditByResellerName(String resellerName){
		
		baseMasterResellerTransferCreditPageFragment.clickTransferCreditByResellerName(resellerName);
		MasterRechargeAccountFancybox masterRechargeAccountFancybox = new MasterRechargeAccountFancybox(starter);
		FancyboxNavigation<MasterRechargeAccountFancybox> navigation = new FancyboxNavigation<MasterRechargeAccountFancybox>(masterRechargeAccountFancybox);
		navigation.NavigatedTo();
		return masterRechargeAccountFancybox;
	}
}
