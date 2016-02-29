package com.nymgo.data.utils;

import java.util.ArrayList;
import java.util.List;

import com.nymgo.tests.AbstractCase;
import com.nymgo.tests.pages.nymgo.base.NymgoPage;
import com.nymgo.tests.pages.tempMail.TempMailPage;

/**
 * Created by Iuliia Khikmatova on Dec 2, 2015
 */
public class NewEmailUtils extends AbstractCase{

	public static List<String> getUniqueEmailAndUsername(){

		NymgoPage nymgoPage = new NymgoPage(starter);
		TempMailPage tempMailPage = nymgoPage.navigateToTempMailInNewTab();
		String signUpEmail = tempMailPage.getEmailAddress();
		String signUpUsername = signUpEmail.split("@")[0] + "Test";
		List<String> signUpData = new ArrayList<String>();
		signUpData.add(signUpEmail);
		signUpData.add(signUpUsername);
		return signUpData;
	} 
}
