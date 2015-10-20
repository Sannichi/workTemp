package nymgoAutomation.tests.pages.admin;

import nymgoAutomation.tests.fragments.admin.MembersAdminPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.admin.base.AbstractLoggedAdminPageWithSearch;
import nymgoAutomation.tests.pages.admin.base.AdminPageWithSearch;
import nymgoAutomation.tests.pages.admin.widgets.MemberListWidget;

public class MembersAdminPage extends AbstractLoggedAdminPageWithSearch{

	MembersAdminPageFragment membersAdminPageFragment;
	
    public MembersAdminPage(Starter starter) {

    	super(starter);
    	membersAdminPageFragment = new MembersAdminPageFragment(driver);
    }

	private static final String MEMBERS_PAGE_NAME_ENG = "AdminMembersPage"; 
			
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
    	return membersAdminPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return MEMBERS_PAGE_NAME_ENG;
	}
	
	public MemberListWidget clickEditUserByUsername(String username){

		membersAdminPageFragment.clickEditUserByUsername(username);
		MemberListWidget memberListWidget = new MemberListWidget(starter);
		PageNavigation<MemberListWidget> navigation = new PageNavigation<MemberListWidget>(memberListWidget);
		navigation.NavigatedTo();
		return memberListWidget;
	}

	public MemberListWidget openEditUserWidgetByUsername(String username){

		membersAdminPageFragment.clickEditUserByUsername(username.toLowerCase());
		MemberListWidget memberListWidget = new MemberListWidget(starter);
		PageNavigation<MemberListWidget> navigation = new PageNavigation<MemberListWidget>(memberListWidget);
		navigation.NavigatedTo();
		return memberListWidget;
	}
}
