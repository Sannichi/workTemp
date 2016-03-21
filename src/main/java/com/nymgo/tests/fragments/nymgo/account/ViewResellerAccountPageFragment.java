package com.nymgo.tests.fragments.nymgo.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public class ViewResellerAccountPageFragment extends BaseViewAccountFragment{
	
    public ViewResellerAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String VIEW_RESELLER_ACCOUNT_PAGE_URL = Starter.SECURE_PART_PATTERN +    
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/reseller/account/account-details/account-profile";

	@Override
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(VIEW_RESELLER_ACCOUNT_PAGE_URL);
        Matcher m = p.matcher(getCurrentURL());	
        return m.matches();
	}
    
	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return VIEW_RESELLER_ACCOUNT_PAGE_URL;
	}
	
}
