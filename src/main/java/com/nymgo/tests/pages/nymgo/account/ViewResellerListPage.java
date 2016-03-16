package com.nymgo.tests.pages.nymgo.account;

import com.nymgo.tests.fragments.nymgo.account.ViewResellerAccountPageFragment;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Mar 16, 2016
 */
public class ViewResellerListPage extends AbstractLoggedInPage {
	
	private ViewResellerAccountPageFragment viewResellerAccountPageFragment;

	public ViewResellerListPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		viewResellerAccountPageFragment = new ViewResellerAccountPageFragment(driver);
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
		return viewResellerAccountPageFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return viewResellerAccountPageFragment.getCorrectURL();
	}

}
