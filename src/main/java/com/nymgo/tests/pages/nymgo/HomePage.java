package com.nymgo.tests.pages.nymgo;

import com.nymgo.tests.fragments.nymgo.HomePageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.base.AbstractNymgoPage;
import com.nymgo.tests.pages.nymgo.signUp.NormalUserSignUpPage;
import com.nymgo.tests.starter.Starter;

public class HomePage extends AbstractNymgoPage{

	private HomePageFragment homePageFragment;
	
	private static final String HOME_PAGE_NAME_ENG = "HomePage"; 
			
    public HomePage(Starter starter) {

    	super(starter);
    	homePageFragment = new HomePageFragment(driver);
    }

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return HOME_PAGE_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return homePageFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return homePageFragment.getCorrectURL();
	}

	private void pressJoinNowButton(){
		
		homePageFragment.clickJoinNowButton();
	}
	
	public NormalUserSignUpPage clickJoinNowButton(){
		
		pressJoinNowButton();
		NormalUserSignUpPage normalUserSignUpPage = new NormalUserSignUpPage(starter);
		PageNavigation<NormalUserSignUpPage> navigation = new PageNavigation<NormalUserSignUpPage>(normalUserSignUpPage);
		navigation.NavigatedTo();
		return normalUserSignUpPage;
	}
}
