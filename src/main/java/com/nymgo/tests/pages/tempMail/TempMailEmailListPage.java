package com.nymgo.tests.pages.tempMail;

import java.util.List;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.tempMail.TempMailEmailListPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 3, 2015
 */
public class TempMailEmailListPage extends TempMailPage {

	private TempMailEmailListPageFragment tempMailEmailListPageFragment; 
	
	public TempMailEmailListPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		tempMailEmailListPageFragment = new TempMailEmailListPageFragment(driver);
	}

	public List<String> getAllEmailSubjects(){
		
		return tempMailEmailListPageFragment.getAllEmailSubjects();
	}
	
	public boolean isEmailBySubjectExists(String emailSubject){
		
		return tempMailEmailListPageFragment.isEmailBySubjectExists(emailSubject);
	}

	public void clickEmailBySubject(String emailSubject){

		tempMailEmailListPageFragment.clickEmailBySubject(emailSubject);
	}

	public boolean isRegistrationSuccessEmailExists(){

		String emailSubject = LocaleGenerator.getLocaleKey(LOCALE_CONST.REGISTRATION_EMAIL_SUBJECT);
		for (int i = 0; i < 30; i++){
			if(!isEmailBySubjectExists(emailSubject)){
				delay(2);
			}
			else{
				return true;
			}
		}
		LOGGER.fatal("Registration Sussess Email was not received within 60 seconds");
		return false;
	}

	public TempMailEmailContentPage openRegistrationSuccessEmail(){

		String emailSubject = LocaleGenerator.getLocaleKey(LOCALE_CONST.REGISTRATION_EMAIL_SUBJECT);
		clickEmailBySubject(emailSubject);
		TempMailEmailContentPage tempMailEmailContentPage = new TempMailEmailContentPage(starter);
		PageNavigation<TempMailEmailContentPage> navigation = new PageNavigation<TempMailEmailContentPage>(tempMailEmailContentPage);
		navigation.NavigatedTo();
		return tempMailEmailContentPage;
	}
}
