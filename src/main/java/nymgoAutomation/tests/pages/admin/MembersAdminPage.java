package nymgoAutomation.tests.pages.admin;

import nymgoAutomation.tests.fragments.admin.MembersAdminPageFragment;
import nymgoAutomation.tests.navigation.WidgetNavigation;
import nymgoAutomation.tests.pages.admin.base.AbstractLoggedAdminPageWithSearch;
import nymgoAutomation.tests.pages.admin.widgets.MemberListWidget;
import nymgoAutomation.tests.starter.Starter;

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

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return membersAdminPageFragment.getCorrectURL();
	}
	
	private void clickEditUserByUsername(String username){

		membersAdminPageFragment.clickEditUserByUsername(username);
	}

	public MemberListWidget openEditUserWidgetByUsername(String username){

		clickEditUserByUsername(username.toLowerCase());
		MemberListWidget memberListWidget = new MemberListWidget(starter);
		WidgetNavigation<MemberListWidget> navigation = new WidgetNavigation<MemberListWidget>(memberListWidget);
		navigation.NavigatedTo();
		return memberListWidget;
	}
}
