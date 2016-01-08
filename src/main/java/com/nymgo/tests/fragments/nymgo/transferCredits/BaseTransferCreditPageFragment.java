package com.nymgo.tests.fragments.nymgo.transferCredits;

import org.openqa.selenium.WebDriver;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.nymgo.base.LoggedNymgoPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.generators.ServerGenerator;

/**
 * Created by Iuliia Khikmatova on Dec 30, 2015
 */
public class BaseTransferCreditPageFragment extends LoggedNymgoPageFragment {

	public BaseTransferCreditPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String TRANSFER_CREDIT_PAGE_URL_EN = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/user/credits/transfer-credits";
	
}
