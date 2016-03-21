package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.worldpay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nymgo.tests.enums.BROWSERS;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.PROPERTIES;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.BaseIframePageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Nov 13, 2015
 */
public class BuyCredit3DSConfirmPageWorldpayFragment extends BaseIframePageFragment{
//public class BuyCredit3DSConfirmPageWorldpayFragment extends PendingTransactionFragment{

	public BuyCredit3DSConfirmPageWorldpayFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_CHROME_URL = "https://secure-test.streamline-esolutions.com/jsp/test/shopper/ThreeDResponseSimulator.jsp";
	private static final String BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL = Starter.SECURE_PART_PATTERN + 
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/generate";	
	
	@FindBy(css = "input[name='continue']")
	private WebElement continueButton;

	private String defineCorrectURL(){
		BROWSERS BROWSER = BROWSERS.valueOf(Starter.PROPS.getProperty(PROPERTIES.BROWSER.name()));
        switch (BROWSER)
        {
            case FIREFOX:
                return BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL;
            case CHROME:
                return BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_CHROME_URL;
            case IE:
                return BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL;
            default:
                return BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL;
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

	public void clickContinueButton(){
		
		clickInputButton(continueButton);
	}
}
