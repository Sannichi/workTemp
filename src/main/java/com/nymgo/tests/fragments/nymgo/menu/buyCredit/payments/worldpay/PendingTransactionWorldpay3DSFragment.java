package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.worldpay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

import com.nymgo.tests.enums.BROWSERS;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.PROPERTIES;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.transactions.PendingTransactionFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class PendingTransactionWorldpay3DSFragment extends PendingTransactionFragment{

	public PendingTransactionWorldpay3DSFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String PENDING_TRANSACTION_WP_3DS_CHROME_URL = Starter.SECURE_PART_PATTERN + 
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/wp3ds-return/";	
	private static final String PENDING_TRANSACTION_WP_3DS_URL = Starter.SECURE_PART_PATTERN + 
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/generate";	
//	private static final String PENDING_TRANSACTION_WP_3DS_CHROME_URL = Starter.SECURE_PART + 
//			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/wp3ds-return/";	
//	private static final String PENDING_TRANSACTION_WP_3DS_URL = Starter.SECURE_PART + 
//			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/generate";	

	private String defineCorrectURL(){
		BROWSERS BROWSER = BROWSERS.valueOf(Starter.PROPS.getProperty(PROPERTIES.BROWSER.name()));
        switch (BROWSER)
        {
            case FIREFOX:
                return PENDING_TRANSACTION_WP_3DS_URL;
            case CHROME:
                return PENDING_TRANSACTION_WP_3DS_CHROME_URL;
            case IE:
                return PENDING_TRANSACTION_WP_3DS_URL;
            default:
                return PENDING_TRANSACTION_WP_3DS_URL;
        }
	}
	
	public boolean isCorrectURL(){

		Pattern p = Pattern.compile(defineCorrectURL());
        Matcher m = p.matcher(getCurrentURL());	
        return m.find();
		
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return defineCorrectURL();    	
	}

}
