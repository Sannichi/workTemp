package com.nymgo.tests.pages.tempMail;

import org.testng.Assert;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.tempMail.TempMailActivationSuccessPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 22, 2015
 */
public class TempMailActivationSuccessPage extends AbstractTempMailEmailContentPage {

	private TempMailActivationSuccessPageFragment tempMailActivationSuccessPageFragment;
	
	public TempMailActivationSuccessPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		tempMailActivationSuccessPageFragment = new TempMailActivationSuccessPageFragment(driver);
	}

	public TempMailActivationSuccessPage verifyActivationSuccessEmailTitle(){

		Assert.assertEquals(getEmailSubjectText(), LocaleGenerator.getLocaleKey(LOCALE_CONST.ACTIVATION_SUCCESS_EMAIL_SUBJECT));
		LOGGER.info("Activation message title is correct");
		LOGGER.info(getEmailSubjectText());
		return this;
	}

	public TempMailActivationSuccessPage verifyActivationSuccessEmailContent(){

		LOGGER.info("Activation message content is correct");
		LOGGER.info(getEmailContentText());
		return this;
	}
}
