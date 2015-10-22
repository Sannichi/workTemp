package nymgoAutomation.tests.pages.admin.base;

import nymgoAutomation.tests.fragments.admin.base.AdminPageWithSearchFragment;
import nymgoAutomation.tests.starter.Starter;

/*
 * 
 * Any Admin logged page  
 * 
 */

public class AdminPageWithSearch extends AbstractLoggedAdminPage{

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
    
}
