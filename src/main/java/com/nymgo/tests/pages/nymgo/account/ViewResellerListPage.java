package com.nymgo.tests.pages.nymgo.account;

import com.nymgo.tests.fragments.nymgo.account.ViewResellerListPageFragment;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Mar 16, 2016
 */
public class ViewResellerListPage extends AbstractLoggedInPage {
	
	private ViewResellerListPageFragment viewResellerListPageFragment;

	public ViewResellerListPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		viewResellerListPageFragment = new ViewResellerListPageFragment(driver);
	}

	private static final String VIEW_RESELLER_LIST_PAGE_NAME_EN = "ViewResellerListPage";

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return VIEW_RESELLER_LIST_PAGE_NAME_EN;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return viewResellerListPageFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return viewResellerListPageFragment.getCorrectURL();
	}

	public String getResellerBalanceCurrencyByResellerName(String resellerName){
		
		return viewResellerListPageFragment.getResellerBalanceCurrencyByResellerName(resellerName);
	}

	public String getResellerBalanceValueByResellerName(String resellerName){
		
		return viewResellerListPageFragment.getResellerBalanceValueByResellerName(resellerName);
	}
	
	//TODO
	public void clickTransferCreditByResellerName(String resellerName){
		
		viewResellerListPageFragment.clickTransferCreditByResellerName(resellerName);
	}
}
