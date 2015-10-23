package nymgoAutomation.tests.pages.nymgo.menu.signIn;

import nymgoAutomation.tests.fragments.nymgo.menu.signIn.NormalUserSignInPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.base.AbstractNymgoPage;
import nymgoAutomation.tests.starter.Starter;

public class NormalUserSignInPage extends AbstractNymgoPage{
	
	private NormalUserSignInPageFragment normalUserSignInPageFragment;
	
	public NormalUserSignInPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		normalUserSignInPageFragment = new NormalUserSignInPageFragment(driver);
	}

	private static final String NORMAL_ACCOUNT_PAGE_NAME_EN = "NormalAccountSignInPage";
	
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return normalUserSignInPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return NORMAL_ACCOUNT_PAGE_NAME_EN;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return normalUserSignInPageFragment.getCorrectURL();
	}

	private NormalUserSignInPage typeUsername(String login){

    	normalUserSignInPageFragment.typeUsername(login);
    	return this;
    }
    
    private NormalUserSignInPage typePassword(String password){
    	
    	normalUserSignInPageFragment.typePassword(password);
    	return this;
    }

    private NormalUserSignInPage clickSignIn(){

    	normalUserSignInPageFragment.clickSignIn();
    	return this;
    }
    
    public void signInUser(String login, String password){
    	
    	typeUsername(login);
    	typePassword(password);
    	clickSignIn();
    }

    public NormalAccountPage signInUserSuccess(String login, String password){

    	signInUser(login, password);
    	NormalAccountPage normalAccountPage = new NormalAccountPage(starter);
		PageNavigation<NormalAccountPage> napNavigation = new PageNavigation<NormalAccountPage>(normalAccountPage); 
		napNavigation.NavigatedTo();
		return normalAccountPage;
    }
}
