package com.nymgo.tests.pages.nymgo.menu.buyCredit;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.BuyCreditDealPageFragment;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Jan 19, 2016
 */
public class BuyCreditDealPage extends BuyCreditPage {

	BuyCreditDealPageFragment buyCreditDealPageFragment;
	
	public BuyCreditDealPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditDealPageFragment = new BuyCreditDealPageFragment(driver);
	}

	public void selectDealByName(String dealName){
		
		buyCreditDealPageFragment.selectDealByName(dealName);
	}
	
	public void setDealsQuantity(String dealsQuantity){
		
		buyCreditDealPageFragment.setDealsQuantity(dealsQuantity);
	}

	public String getDealVATPercent(){
		
		return buyCreditDealPageFragment.getDealVATPercent();
	}

	public String getDealVATValue(){
		
		return buyCreditDealPageFragment.getDealVATValue();
	}

	public String getDealTotalAmountValue(){
		
		return buyCreditDealPageFragment.getDealTotalAmountValue();
	}
}
