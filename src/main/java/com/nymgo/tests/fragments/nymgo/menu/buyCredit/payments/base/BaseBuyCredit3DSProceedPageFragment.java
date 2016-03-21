package com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.BaseRecurrentCreditCardFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Nov 10, 2015
 */
//Adyen and Worldpay payments
public class BaseBuyCredit3DSProceedPageFragment extends BaseRecurrentCreditCardFragment{
	
	public BaseBuyCredit3DSProceedPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUY_CREDIT_3DS_PAGE_PROOCEED_URL = Starter.SECURE_PART_PATTERN +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/proceed";	
	
	@FindBy(css = "input[class='button-normal']")
	private WebElement payButton;
	
	@FindBy(css = "a[class='button-normal cancel']")
	private WebElement cancelButton;

	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(BUY_CREDIT_3DS_PAGE_PROOCEED_URL);
        Matcher m = p.matcher(getCurrentURL());	
        return m.matches();
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_3DS_PAGE_PROOCEED_URL;
	}
	
	public void clickPayButton(){
		
		clickInputButton(payButton);
	}

	public void clickCancelButton(){
		
		clickInputButton(cancelButton);
	}
}
