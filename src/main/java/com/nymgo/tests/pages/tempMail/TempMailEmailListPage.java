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

		String emailSubject = LocaleGenerator.getLocaleKey(LOCALE_CONST.REGISTRATION_SUCCESS_EMAIL_SUBJECT).substring(0, 25);
		for (int i = 0; i < 30; i++){
			if(!isEmailBySubjectExists(emailSubject)){
				LOGGER.info("Waiting for Registration Success email...");
				delay(2);
			}
			else{
				return true;
			}
		}
		LOGGER.fatal("Registration Sussess Email with title '" + emailSubject + "' was not received within 60 seconds");
		return false;
	}

	public TempMailRegistrationSuccessPage openRegistrationSuccessEmail(){

		String emailSubject = LocaleGenerator.getLocaleKey(LOCALE_CONST.REGISTRATION_SUCCESS_EMAIL_SUBJECT).substring(0, 25);
		clickEmailBySubject(emailSubject);
		TempMailRegistrationSuccessPage tempMailRegistrationSuccessPage = new TempMailRegistrationSuccessPage(starter);
		PageNavigation<TempMailRegistrationSuccessPage> navigation = new PageNavigation<TempMailRegistrationSuccessPage>(tempMailRegistrationSuccessPage);
		navigation.NavigatedTo();
		return tempMailRegistrationSuccessPage;
	}

	public boolean isActivationSuccessEmailExists(){

		String emailSubject = LocaleGenerator.getLocaleKey(LOCALE_CONST.ACTIVATION_SUCCESS_EMAIL_SUBJECT).substring(0, 25);
		for (int i = 0; i < 30; i++){
			if(!isEmailBySubjectExists(emailSubject)){
				LOGGER.info("Waiting for Activation Success email...");
				delay(2);
			}
			else{
				return true;
			}
		}
		LOGGER.fatal("Activation Sussess Email with title '" + emailSubject + "' was not received within 60 seconds");
		return false;
	}

	public TempMailActivationSuccessPage openActivationSuccessEmail(){

		String emailSubject = LocaleGenerator.getLocaleKey(LOCALE_CONST.ACTIVATION_SUCCESS_EMAIL_SUBJECT).substring(0, 25);
		clickEmailBySubject(emailSubject);
		TempMailActivationSuccessPage tempMailActivationSuccessPage = new TempMailActivationSuccessPage(starter);
		PageNavigation<TempMailActivationSuccessPage> navigation = new PageNavigation<TempMailActivationSuccessPage>(tempMailActivationSuccessPage);
		navigation.NavigatedTo();
		return tempMailActivationSuccessPage;
	}

}
