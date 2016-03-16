package com.nymgo.tests.pages.nymgo.account;

import com.nymgo.tests.fragments.nymgo.account.MasterAccountPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.starter.Starter;

public class MasterAccountPage extends AbstractAccountPage{
	
	private MasterAccountPageFragment masterAccountPageFragment;
	
    public MasterAccountPage(Starter starter) {

    	super(starter);
    	masterAccountPageFragment = new MasterAccountPageFragment(driver);
    }
    
	private static final String MASTER_ACCOUNT_PAGE_NAME_EN = "MasterAccountPage";

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
    	return MASTER_ACCOUNT_PAGE_NAME_EN;
	}

	public ViewMastersListPage clickViewMastersListButton(){
		
		masterAccountPageFragment.clickViewMastersListButton();
		ViewMastersListPage viewMastersListPage = new ViewMastersListPage(starter);
		PageNavigation<ViewMastersListPage> navigation = new PageNavigation<ViewMastersListPage>(viewMastersListPage);
		navigation.NavigatedTo();
		return viewMastersListPage;
	}

	public ViewResellerListPage clickViewResellerListButton(){
		
		masterAccountPageFragment.clickViewResellerListButton();
		ViewResellerListPage viewResellerListPage = new ViewResellerListPage(starter);
		PageNavigation<ViewResellerListPage> navigation = new PageNavigation<ViewResellerListPage>(viewResellerListPage);
		navigation.NavigatedTo();
		return viewResellerListPage;
	}
}
