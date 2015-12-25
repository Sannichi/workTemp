package com.nymgo.tests.pages.tempMail;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.testng.Assert;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.tempMail.TempMailRegistrationSuccessPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.menu.signIn.NormalUserSignInPage;
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
		PrintWriter writer;
		try {
			writer = new PrintWriter("D:\\work\\nymgo\\automation\\nymgoAutomation\\Registration.txt", "UTF-8");
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

	//Link in the same page, Button in the new window (not tab)

	private void clickVerifyAccountButton(){
		
		tempMailRegistrationSuccessPageFragment.clickVerifyAccountButton();
	}

	//TODO instead of void
	private void clickVerifyAccountLink(){
		
		tempMailRegistrationSuccessPageFragment.clickVerifyAccountLink();
	}

	public NormalUserSignInPage openVerifyAccountButtonInNewBrowser(){
		
		clickVerifyAccountButton();
		NormalUserSignInPage normalUserSignInPage = new NormalUserSignInPage(starter);
		PageNavigation<NormalUserSignInPage> navigation = new PageNavigation<NormalUserSignInPage>(normalUserSignInPage);
		this.navigateToTabByURLContains(normalUserSignInPage.getPageURL());
		navigation.NavigatedTo();
		return normalUserSignInPage;
	}

}
