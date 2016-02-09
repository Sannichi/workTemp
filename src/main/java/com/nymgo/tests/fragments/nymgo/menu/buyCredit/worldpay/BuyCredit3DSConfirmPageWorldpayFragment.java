package com.nymgo.tests.fragments.nymgo.menu.buyCredit.worldpay;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.BROWSERS;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.PROPERTIES;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.base.BaseIframePageFragment;
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

//	private static final String BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL = "https://secure-dev.nymgo.com/en/wp3ds-return/d0Vxd25rOW53Q0JNV0ZPUk1FNlQwQT09";	
	private static final String BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_CHROME_URL = "https://secure-test.streamline-esolutions.com/jsp/test/shopper/ThreeDResponseSimulator.jsp";
//	private static final String BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL).replace("http", "https") + 
	private static final String BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL = Starter.SECURE_PART + 
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

    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	String correctURL = defineCorrectURL();
    	try{
//    		wait.until(ExpectedConditions.urlContains(BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL));
    		wait.until(ExpectedConditions.urlContains(correctURL));    		
    		return true;
    	}
    	catch(TimeoutException e){
    		return false;
    	}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
    	String correctURL = defineCorrectURL();
//		return BUY_CREDIT_3DS_CONFIRM_PAGE_WP_NEXT_URL;
		return correctURL;    	
	}

	public void clickContinueButton(){
		
		clickInputButton(continueButton);
	}
}
