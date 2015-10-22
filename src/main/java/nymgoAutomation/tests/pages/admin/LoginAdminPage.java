package nymgoAutomation.tests.pages.admin;

import nymgoAutomation.tests.fragments.admin.LoginAdminPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.admin.base.AbstractAdminPage;
import nymgoAutomation.tests.starter.Starter;

public class LoginAdminPage extends AbstractAdminPage{

	private LoginAdminPageFragment loginAdminPageFragment;
	
	public LoginAdminPage(Starter starter) {

        super(starter);
        loginAdminPageFragment = new LoginAdminPageFragment(driver);
    }

	private static final String LOGIN_PAGE_NAME_ENG = "AdminLoginPage"; 
	
    private LoginAdminPage typeUsername(String login){

    	loginAdminPageFragment.typeUsername(login);
    	return this;
    }
    
    private LoginAdminPage typePassword(String password){
    	
    	loginAdminPageFragment.typePassword(password);
    	return this;
    }

    private void clickLogin(){

    	loginAdminPageFragment.clickLogin();
    }
    
    public MembersAdminPage signInUserSuccess(String login, String password){
    	
    	typeUsername(login);
    	typePassword(password);
    	clickLogin();
    	MembersAdminPage membersAdminPage = new MembersAdminPage(starter);
		PageNavigation<MembersAdminPage> navigation = new PageNavigation<MembersAdminPage>(membersAdminPage); 
		navigation.NavigatedTo();
		return membersAdminPage;
    }

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return LOGIN_PAGE_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return loginAdminPageFragment.isCorrectURL();
	}
}
