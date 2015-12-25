package com.nymgo.tests.pages.tempMail;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
		PrintWriter writer;
		try {
			writer = new PrintWriter("D:\\work\\nymgo\\automation\\nymgoAutomation\\Activation.txt", "UTF-8");
			writer.println(getEmailContentText());
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
}
