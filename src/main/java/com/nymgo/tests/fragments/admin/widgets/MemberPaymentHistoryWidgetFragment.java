package com.nymgo.tests.fragments.admin.widgets;

import org.openqa.selenium.WebDriver;

import com.nymgo.tests.enums.MEMBER_PAYMENT_HISTORY_TABS;

public class MemberPaymentHistoryWidgetFragment extends BaseWidgetFragment{

	public PaymentActionFragment paymentActionFragment;
	
	public MemberPaymentHistoryWidgetFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		paymentActionFragment = new PaymentActionFragment(driver);
	}

	public void navigateToPaymentActionTab(){
		
		clickOnTabByAltText(MEMBER_PAYMENT_HISTORY_TABS.PAYMENT_ACTION.toString());
	}

}
