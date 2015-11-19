package com.nymgo.tests.pages.admin;

import com.nymgo.tests.fragments.admin.HomeAdminPageFragment;
import com.nymgo.tests.pages.admin.base.AbstractLoggedAdminPage;
import com.nymgo.tests.starter.Starter;

public class HomeAdminPage extends AbstractLoggedAdminPage{

	HomeAdminPageFragment homeAdminPageFragment;
	
    public HomeAdminPage(Starter starter) {

    	super(starter);
    	homeAdminPageFragment = new HomeAdminPageFragment(driver);
    }

    private static final String HOME_PAGE_NAME_ENG = "AdminHomePage"; 

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
    	return homeAdminPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return HOME_PAGE_NAME_ENG;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return homeAdminPageFragment.getCorrectURL();
	}
    
}
