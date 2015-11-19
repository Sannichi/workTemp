package com.nymgo.tests.pages.admin.base;

import com.nymgo.tests.fragments.admin.base.AdminPageFragment;
import com.nymgo.tests.starter.Starter;

/*
 * 
 * Any Admin logged page  
 * 
 */

public class AdminPage extends AbstractLoggedAdminPage{

	private AdminPageFragment adminPageFragment;
	
    public AdminPage(Starter starter) {
        super(starter);
        adminPageFragment = new AdminPageFragment(driver);
    }

    private static final String ADMIN_PAGE_NAME_ENG = "AdminNymgoPage"; 
	
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return adminPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return ADMIN_PAGE_NAME_ENG;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return adminPageFragment.getCorrectURL();
	}
    
}
