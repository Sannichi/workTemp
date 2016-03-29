package com.nymgo.tests.fragments.nymgo.transferCredits;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Mar 09, 2016
 */
public class ResellerAccountTransferCreditPageFragment extends BaseTransferCreditPageFragment {
	
	public ResellerAccountTransferCreditPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static final String TRANSFER_CREDIT_PAGE_URL = Starter.SECURE_PART_PATTERN +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "\\/reseller\\/credits\\/transfer-credits";
	
	@Override
	public boolean isCorrectURL() {

		Pattern p = Pattern.compile(TRANSFER_CREDIT_PAGE_URL);
        Matcher m = p.matcher(getCurrentURL());	
        return m.matches();
	}

	@Override
	public String getCorrectURL() {

		return TRANSFER_CREDIT_PAGE_URL;
	}
}