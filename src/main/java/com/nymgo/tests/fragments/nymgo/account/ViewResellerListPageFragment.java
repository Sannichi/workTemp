package com.nymgo.tests.fragments.nymgo.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseLoggedInFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;
/**
 * Created by Iuliia Khikmatova on Mar 09, 2016
 */
public class ViewResellerListPageFragment extends BaseLoggedInFragment{
	
    public ViewResellerListPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String VIEW_RESELER_LIST_PAGE_URL = Starter.SECURE_PART_PATTERN +	
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/master-resellers/view-reseller-list";

	@Override
	public boolean isCorrectURL() {

		Pattern p = Pattern.compile(VIEW_RESELER_LIST_PAGE_URL);
        Matcher m = p.matcher(getCurrentURL());	
        return m.matches();
	}

	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return VIEW_RESELER_LIST_PAGE_URL;
	}

}
