package com.nymgo.tests.pages.tempMail;

import com.nymgo.tests.fragments.tempMail.TempMailPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.AbstractPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 3, 2015
 */
public abstract class TempMailPage extends AbstractPage {

	private TempMailPageFragment tempMailPageFragment; 
	
	public TempMailPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		tempMailPageFragment = new TempMailPageFragment(driver);
	}

	private static final String TEMP_MAIL_PAGE_NAME_ENG = "TempMailPage";
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return TEMP_MAIL_PAGE_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return tempMailPageFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return tempMailPageFragment.getCorrectURL();
	}

	public String getEmailAddress(){
		
		return tempMailPageFragment.getEmailAddress();
	}

	public TempMailEmailListPage clickRefresh(){
		
		tempMailPageFragment.clickRefresh();
		TempMailEmailListPage tempMailEmailListPage = new TempMailEmailListPage(starter);
		PageNavigation<TempMailEmailListPage> navigation = new PageNavigation<TempMailEmailListPage>(tempMailEmailListPage);
		navigation.NavigatedTo();
		return tempMailEmailListPage;
	}

	public void clickDelete(){
		
		tempMailPageFragment.clickDelete();
	}
}
