package com.nymgo.tests.pages.nymgo.account;

import com.nymgo.tests.fragments.nymgo.account.ViewMastersListPageFragment;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Mar 16, 2016
 */
public class ViewMastersListPage extends AbstractLoggedInPage {
	
	private ViewMastersListPageFragment viewMastersListPageFragment;

	public ViewMastersListPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		viewMastersListPageFragment = new ViewMastersListPageFragment(driver);
	}

	private static final String VIEW_MASTERS_LIST_PAGE_NAME_EN = "ViewMastersListPage";

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return VIEW_MASTERS_LIST_PAGE_NAME_EN;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return viewMastersListPageFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return viewMastersListPageFragment.getCorrectURL();
	}

}
