package com.nymgo.tests.pages.tempMail;

import org.testng.Assert;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.tempMail.TempMailRegistrationSuccessPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 22, 2015
 */
public class TempMailRegistrationSuccessPage extends AbstractTempMailEmailContentPage {

	private TempMailRegistrationSuccessPageFragment tempMailRegistrationSuccessPageFragment;
	
	public TempMailRegistrationSuccessPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		tempMailRegistrationSuccessPageFragment = new TempMailRegistrationSuccessPageFragment(driver);
	}

	public TempMailRegistrationSuccessPage verifyRegistrationSuccessEmailTitle(){

		Assert.assertEquals(getEmailSubjectText(), LocaleGenerator.getLocaleKey(LOCALE_CONST.REGISTRATION_SUCCESS_EMAIL_SUBJECT));
		LOGGER.info("Registration message title is correct");
		LOGGER.info(getEmailSubjectText());
		return this;
	}

	public TempMailRegistrationSuccessPage verifyRegistrationSuccessEmailContent(){

		LOGGER.info("Registration message content is correct");
		LOGGER.info(getEmailContentText());
		return this;
	}

	//Link in the same page, Button in the new window (not tab)

	//TODO instead of void
	public void clickVerifyAccountButton(){
		
		tempMailRegistrationSuccessPageFragment.clickVerifyAccountButton();
	}

	//TODO instead of void
	public void clickVerifyAccountLink(){
		
		tempMailRegistrationSuccessPageFragment.clickVerifyAccountLink();
	}
}
