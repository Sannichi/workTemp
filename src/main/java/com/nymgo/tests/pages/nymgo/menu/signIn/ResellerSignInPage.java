package com.nymgo.tests.pages.nymgo.menu.signIn;

import com.nymgo.tests.fragments.nymgo.menu.signIn.ResellerSignInPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.account.ResellerAccountPage;
import com.nymgo.tests.pages.nymgo.base.AbstractNymgoPage;
import com.nymgo.tests.starter.Starter;

public class ResellerSignInPage extends AbstractNymgoPage{
	
	private ResellerSignInPageFragment resellerSignInPageFragment;
	
	public ResellerSignInPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		resellerSignInPageFragment = new ResellerSignInPageFragment(driver);
	}

	private static final String RESELLER_ACCOUNT_PAGE_NAME_EN = "ResellerSignInPage";

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

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return resellerSignInPageFragment.getCorrectURL();
	}
	
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
}
