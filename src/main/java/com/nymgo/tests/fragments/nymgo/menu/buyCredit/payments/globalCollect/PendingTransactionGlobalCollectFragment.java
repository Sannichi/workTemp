package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.globalCollect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

import com.nymgo.tests.enums.BROWSERS;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.PROPERTIES;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.transactions.PendingIframeTransactionFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

public class PendingTransactionGlobalCollectFragment extends PendingIframeTransactionFragment{

	public PendingTransactionGlobalCollectFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_CHROME_URL = Starter.SECURE_PART_PATTERN + "/gcreturn?REF=";	
	private static final String BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL = Starter.SECURE_PART_PATTERN + 
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/generate";	

	private String defineCorrectURL(){
		BROWSERS BROWSER = BROWSERS.valueOf(Starter.PROPS.getProperty(PROPERTIES.BROWSER.name()));
        switch (BROWSER)
        {
            case FIREFOX:
                return BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL;
            case CHROME:
                return BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_CHROME_URL;
            case IE:
                return BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL;
            default:
                return BUY_CREDIT_CONFIRM_PAGE_GC_PENDING_URL;
        }
	}
	
	public boolean isCorrectURL(){

		Pattern p = Pattern.compile(defineCorrectURL());
        Matcher m = p.matcher(getCurrentURL());	
        return m.matches();
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return defineCorrectURL();    	
	}

}
