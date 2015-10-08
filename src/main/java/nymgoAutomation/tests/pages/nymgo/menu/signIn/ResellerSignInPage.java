package nymgoAutomation.tests.pages.nymgo.menu.signIn;

import nymgoAutomation.tests.fragments.nymgo.menu.signIn.ResellerSignInPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.nymgo.account.ResellerAccountPage;
import nymgoAutomation.tests.pages.nymgo.base.AbstractNymgoPage;

public class ResellerSignInPage extends AbstractNymgoPage{
	
	private ResellerSignInPageFragment resellerSignInPageFragment;
	
	public ResellerSignInPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		resellerSignInPageFragment = new ResellerSignInPageFragment(driver);
	}

	private static final String RESELLER_ACCOUNT_PAGE_NAME_EN = "ResellerSignInPage";
	
    private ResellerSignInPage typeUsername(String login){
    	
    	resellerSignInPageFragment.typeUsername(login);
    	return this;
    }
    
    private ResellerSignInPage typePassword(String password){
    	
    	resellerSignInPageFragment.typePassword(password);
    	return this;
    }

    private void clickSignIn(){

    	resellerSignInPageFragment.clickSignIn();
    }

    private void signInReseller(String login, String password){

    	typeUsername(login);
    	typePassword(password);
    	clickSignIn();
    }
    
    public ResellerAccountPage signInResellerSuccess(String login, String password){
    	
    	signInReseller(login, password);
    	ResellerAccountPage resellerAccountPage = new ResellerAccountPage(starter);
		PageNavigation<ResellerAccountPage> navigation = new PageNavigation<ResellerAccountPage>(resellerAccountPage); 
		navigation.NavigatedTo();
		return resellerAccountPage;
    }

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return resellerSignInPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return RESELLER_ACCOUNT_PAGE_NAME_EN;
	}
}
