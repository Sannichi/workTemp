package com.nymgo.tests.pages.nymgo.menu;

import com.nymgo.tests.fragments.nymgo.menu.AppsPageFragment;
import com.nymgo.tests.pages.nymgo.base.AbstractNymgoPage;
import com.nymgo.tests.starter.Starter;

public class AppsPage extends AbstractNymgoPage{
	
	private AppsPageFragment appsPageFragment;
	
	public AppsPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		appsPageFragment = new AppsPageFragment(driver);
	}
	private static final String APPS_PAGE_NAME_EN = "AppsPage";

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return appsPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return APPS_PAGE_NAME_EN;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return appsPageFragment.getCorrectURL();
	}
    
}
