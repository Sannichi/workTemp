package com.nymgo.tests.pages.nymgo.account;

import com.nymgo.tests.fragments.nymgo.account.ViewResellerAccountDetailsPageFragment;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public class ViewResellerAccountDetailsPage extends AbstractViewAccountPage{

	ViewResellerAccountDetailsPageFragment viewResellerAccountDetailsPageFragment;
	
	public ViewResellerAccountDetailsPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		viewResellerAccountDetailsPageFragment = new ViewResellerAccountDetailsPageFragment(driver);
	}

	private static final String VIEW_NORMAL_ACCOUNT_PAGE_NAME_EN = "ViewNormalAccountDetailsPage";
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return VIEW_NORMAL_ACCOUNT_PAGE_NAME_EN;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return viewResellerAccountDetailsPageFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return viewResellerAccountDetailsPageFragment.getCorrectURL();
	}
}
