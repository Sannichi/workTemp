package com.nymgo.tests.pages.tempMail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

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

	public TempMailRegistrationSuccessPage verifyRegistrationSuccessEmailContent(String fullName){

		Object[] registrationArgs = {fullName, getVerifyAccountLinkLink()};
		BufferedReader bufferedReader = null;
		String registrationExample = new String();
		
		try {
			bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Starter.REGISTRATION_FILE_PATH), "UTF-8"));
			int num=0;
			while((num=bufferedReader.read()) != -1)
			{	
				registrationExample += (char)num; 
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null){
					bufferedReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if (registrationExample.codePointAt(0)==0xFEFF){
			registrationExample = registrationExample.substring(1);
		}
		MessageFormat messageFormat = new MessageFormat(registrationExample);
		Assert.assertTrue(getEmailContentText().equals(messageFormat.format(registrationArgs)), "Message '" + getEmailContentText() + "' not equals '" + messageFormat.format(registrationArgs) + "'");
		LOGGER.info("Registration message content is correct");
/*		
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
*/
		return this;
	}

	//Link in the same page, Button in the new window (not tab)

	private void clickVerifyAccountButton(){
		
		tempMailRegistrationSuccessPageFragment.clickVerifyAccountButton();
	}

	@SuppressWarnings("unused")
	private String getVerifyAccountButtonLink(){
		
		return tempMailRegistrationSuccessPageFragment.getVerifyAccountButtonLink();
	}

	//TODO instead of void
	@SuppressWarnings("unused")
	private void clickVerifyAccountLink(){
		
		tempMailRegistrationSuccessPageFragment.clickVerifyAccountLink();
	}

	private String getVerifyAccountLinkLink(){
		
		return tempMailRegistrationSuccessPageFragment.getVerifyAccountLinkLink();
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
