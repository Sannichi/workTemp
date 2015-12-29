package com.nymgo.tests.pages.tempMail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

import org.testng.Assert;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.tempMail.TempMailActivationSuccessPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 22, 2015
 */
public class TempMailActivationSuccessPage extends AbstractTempMailEmailContentPage {

	@SuppressWarnings("unused")
	private TempMailActivationSuccessPageFragment tempMailActivationSuccessPageFragment;
	
	public TempMailActivationSuccessPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		tempMailActivationSuccessPageFragment = new TempMailActivationSuccessPageFragment(driver);
	}

	public TempMailActivationSuccessPage verifyActivationSuccessEmailTitle(){

		Assert.assertEquals(getEmailSubjectText(), LocaleGenerator.getLocaleKey(LOCALE_CONST.ACTIVATION_SUCCESS_EMAIL_SUBJECT));
		LOGGER.info("Activation message title is correct");
		return this;
	}

	public TempMailActivationSuccessPage verifyActivationSuccessEmailContent(String fullName, String username){

		Object[] registrationArgs = {fullName, username.toLowerCase()};
		BufferedReader bufferedReader = null;
		String activationExample = new String();
		
		try {
			bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Starter.ACTIVATION_FILE_PATH), "UTF-8"));
			int num=0;
			while((num=bufferedReader.read()) != -1)
			{	
				activationExample += (char)num; 
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
		if (activationExample.codePointAt(0)==0xFEFF){
			activationExample = activationExample.substring(1);
		}
		MessageFormat messageFormat = new MessageFormat(activationExample);
		Assert.assertTrue(getEmailContentText().equals(messageFormat.format(registrationArgs)), "Message '" + getEmailContentText() + "' not equals '" + messageFormat.format(registrationArgs) + "'");
		
		LOGGER.info("Activation message content is correct");
/*		PrintWriter writer;
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
*/		return this;
	}
}
