package com.nymgo.tests.pages.nymgo.menu;

import com.nymgo.tests.fragments.nymgo.menu.ResellersPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.base.AbstractNymgoPage;
import com.nymgo.tests.pages.nymgo.menu.signIn.ResellerSignInPage;
import com.nymgo.tests.pages.nymgo.signUp.ResellerSignUpPage;
import com.nymgo.tests.starter.Starter;

public class ResellersPage extends AbstractNymgoPage{
	
	private ResellersPageFragment resellersPageFragment;
	
	public ResellersPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		resellersPageFragment = new ResellersPageFragment(driver);
	}

	private static final String RESELLERS_PAGE_NAME_EN = "ResellersPage";

	public ResellerSignInPage clickResellerSignInButton(){

		resellersPageFragment.clickResellerSignInButton();
    	ResellerSignInPage resellerSignInPage = new ResellerSignInPage(starter);
		PageNavigation<ResellerSignInPage> navigation = new PageNavigation<ResellerSignInPage>(resellerSignInPage); 
		navigation.NavigatedTo();
		return resellerSignInPage;
    }

	public ResellerSignUpPage clickJoinResellerButton(){
		
		resellersPageFragment.clickJoinResellerButton();
    	ResellerSignUpPage resellerSignUpPage = new ResellerSignUpPage(starter);
		PageNavigation<ResellerSignUpPage> navigation = new PageNavigation<ResellerSignUpPage>(resellerSignUpPage); 
		navigation.NavigatedTo();
		return resellerSignUpPage;
	}
	
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return resellersPageFragment.isCorrectURL();
	}


	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return RESELLERS_PAGE_NAME_EN;
	}


	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return resellersPageFragment.getCorrectURL();
	}
    
}
