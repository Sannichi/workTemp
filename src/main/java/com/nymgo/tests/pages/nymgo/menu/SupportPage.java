package com.nymgo.tests.pages.nymgo.menu;

import com.nymgo.tests.fragments.nymgo.menu.SupportPageFragment;
import com.nymgo.tests.pages.nymgo.base.AbstractNymgoPage;
import com.nymgo.tests.starter.Starter;

public class SupportPage extends AbstractNymgoPage{
	
	private SupportPageFragment supportPageFragment;

	public SupportPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		supportPageFragment = new SupportPageFragment(driver);
	}

	private static final String SUPPORT_PAGE_NAME_EN = "SupportPage";
	
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return supportPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return SUPPORT_PAGE_NAME_EN;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return supportPageFragment.getCorrectURL();
	}
    
}
