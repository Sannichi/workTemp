package com.nymgo.tests.fragments.nymgo.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 13, 2015
 */

public class ViewNormalAccountPageFragment extends BaseViewAccountFragment{
	
    public ViewNormalAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String VIEW_NORMAL_ACCOUNT_PAGE_URL = Starter.SECURE_PART_PATTERN +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/user/account/view/profile";

	@Override
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(VIEW_NORMAL_ACCOUNT_PAGE_URL);
        Matcher m = p.matcher(getCurrentURL());	
        return m.matches();
	}
    
	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return VIEW_NORMAL_ACCOUNT_PAGE_URL;
	}
	
}
