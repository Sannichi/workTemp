package com.nymgo.tests.pages.nymgo.account;

import com.nymgo.tests.fragments.nymgo.account.ResellerAccountPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.starter.Starter;

public class ResellerAccountPage extends AbstractAccountPage{
	
	private ResellerAccountPageFragment resellerAccountPageFragment;
	
    public ResellerAccountPage(Starter starter) {

    	super(starter);
    	resellerAccountPageFragment = new ResellerAccountPageFragment(driver);
    }

	private static final String RESELLER_ACCOUNT_PAGE_NAME_EN = "ResellerAccountPage";
    
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return RESELLER_ACCOUNT_PAGE_NAME_EN;
	}
    
	public ViewResellerAccountPage clickViewAccountDetailsButton(){
		
		resellerAccountPageFragment.clickViewAccountDetailsButton();
		ViewResellerAccountPage viewResellerAccountPage = new ViewResellerAccountPage(starter);
		PageNavigation<ViewResellerAccountPage> navigation = new PageNavigation<ViewResellerAccountPage>(viewResellerAccountPage);
		navigation.NavigatedTo();
		return viewResellerAccountPage;
	}

}
