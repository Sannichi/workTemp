package nymgoAutomation.tests.fragments.admin.widgets;

import org.openqa.selenium.WebDriver;

import nymgoAutomation.tests.enums.BUSINESS_MEMBER_PAYMENT_HISTORY_TABS;
/**
 * Created by Iuliia Khikmatova on Oct 28, 2015
 */
public class BusinessMemberPaymentHistoryWidgetFragment extends BaseWidgetFragment{

	public PaymentActionFragment paymentActionFragment;
	
	public BusinessMemberPaymentHistoryWidgetFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		paymentActionFragment = new PaymentActionFragment(driver);
	}

	public void navigateToBusinessPaymentActionTab(){
		
		clickOnTabByAltText(BUSINESS_MEMBER_PAYMENT_HISTORY_TABS.BUSINESS_PAYMENT_ACTION.toString());
	}

}
