package com.nymgo.tests.pages.tempMail;

import org.testng.Assert;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.tempMail.TempMailEmailContentPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 17, 2015
 */
public class TempMailEmailContentPage extends TempMailPage {

	private TempMailEmailContentPageFragment tempMailEmailContentPageFragment;
	
	public TempMailEmailContentPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		tempMailEmailContentPageFragment = new TempMailEmailContentPageFragment(driver);
	}

	public String getEmailSubjectText(){
		
		return tempMailEmailContentPageFragment.getEmailSubjectText();
	}

	public String getEmailContentText(){
		
		return tempMailEmailContentPageFragment.getEmailContentText();
	}

	public TempMailEmailContentPage verifyRegistrationSuccessEmailContent(){

		Assert.assertEquals(getEmailSubjectText(), LocaleGenerator.getLocaleKey(LOCALE_CONST.REGISTRATION_SUCCESS_EMAIL_SUBJECT));
		LOGGER.info(getEmailContentText());
		return this;
	}
}
