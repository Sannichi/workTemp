
package com.nymgo.tests.pages.admin.base;

import com.nymgo.tests.fragments.admin.base.AdminPageWithSearchFragment;
import com.nymgo.tests.starter.Starter;

/*
 * 
 * Any Admin logged page with search possibility 
 * 
 */

public class AdminPageWithSearch extends AbstractLoggedAdminPageWithSearch{

	private AdminPageWithSearchFragment adminPageWithSearchFragment;
	
    public AdminPageWithSearch(Starter starter) {
        super(starter);
        adminPageWithSearchFragment = new AdminPageWithSearchFragment(driver);
    }

    private static final String ADMIN_PAGE_NAME_ENG = "AdminNymgoPage"; 
	
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return adminPageWithSearchFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return ADMIN_PAGE_NAME_ENG;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return adminPageWithSearchFragment.getCorrectURL();
	}
    
}
