package com.nymgo.tests.pages.admin;

import com.nymgo.tests.fragments.admin.BusinessMembersAdminPageFragment;
import com.nymgo.tests.navigation.WidgetNavigation;
import com.nymgo.tests.pages.admin.base.AbstractLoggedAdminPageWithSearch;
import com.nymgo.tests.pages.admin.widgets.BusinessMemberListWidget;
import com.nymgo.tests.starter.Starter;
/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public class BusinessMembersAdminPage extends AbstractLoggedAdminPageWithSearch{

	BusinessMembersAdminPageFragment businessMembersAdminPageFragment;
	
    public BusinessMembersAdminPage(Starter starter) {

    	super(starter);
    	businessMembersAdminPageFragment = new BusinessMembersAdminPageFragment(driver);
    }

	private static final String BUSINESS_MEMBERS_PAGE_NAME_ENG = "AdminBusinessMembersPage"; 
			
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
    	return businessMembersAdminPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUSINESS_MEMBERS_PAGE_NAME_ENG;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return businessMembersAdminPageFragment.getCorrectURL();
	}

	public void clickEditUserByUsername(String username){
		
		businessMembersAdminPageFragment.clickEditUserByUsername(username);
	}
	
	public BusinessMemberListWidget openEditBusinessUserWidgetByUsername(String username){

		clickEditUserByUsername(username.toLowerCase());
		BusinessMemberListWidget businessMemberListWidget = new BusinessMemberListWidget(starter);
		WidgetNavigation<BusinessMemberListWidget> navigation = new WidgetNavigation<BusinessMemberListWidget>(businessMemberListWidget);
		navigation.NavigatedTo();
		return businessMemberListWidget;
	}
}
