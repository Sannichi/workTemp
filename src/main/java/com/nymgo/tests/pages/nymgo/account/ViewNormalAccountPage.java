package com.nymgo.tests.pages.nymgo.account;

import com.nymgo.tests.fragments.nymgo.account.ViewNormalAccountPageFragment;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 13, 2015
 */
public class ViewNormalAccountPage extends AbstractViewAccountPage{

	private ViewNormalAccountPageFragment viewNormalAccountPageFragment;
	
	public ViewNormalAccountPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		viewNormalAccountPageFragment = new ViewNormalAccountPageFragment(driver);
	}

	private static final String VIEW_NORMAL_ACCOUNT_PAGE_NAME_EN = "ViewNormalAccountPage";
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return VIEW_NORMAL_ACCOUNT_PAGE_NAME_EN;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return viewNormalAccountPageFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return viewNormalAccountPageFragment.getCorrectURL();
	}
}
