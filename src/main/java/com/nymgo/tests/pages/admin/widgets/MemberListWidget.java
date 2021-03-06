package com.nymgo.tests.pages.admin.widgets;

import com.nymgo.tests.fragments.admin.widgets.MemberListWidgetFragment;
import com.nymgo.tests.navigation.AlertNavigation;
import com.nymgo.tests.pages.admin.alerts.MemberEditAlert;
import com.nymgo.tests.starter.Starter;

public class MemberListWidget extends AbstractWidget{

	MemberListWidgetFragment memberListWidgetFragment;
	
	public MemberListWidget(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		memberListWidgetFragment = new MemberListWidgetFragment(driver);
	}

	private static final String WIDGET_MEMBERS_LIST_NAME_ENG = "Member List"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return memberListWidgetFragment.getWidgetName();
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return getPageName().equals(WIDGET_MEMBERS_LIST_NAME_ENG);
	}
	
	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return WIDGET_MEMBERS_LIST_NAME_ENG;
	}

	private MemberListWidget navigateToUserPaymentMethodTab(){
		
		memberListWidgetFragment.navigateToUserPaymentMethodTab();
		return this;
	}
	
	private void selectPaymentMethod(String paymentMethodName){
		
		memberListWidgetFragment.selectPaymentMethod(paymentMethodName);
	}

	private void clickEditPaymentMethodButton(){
		
		memberListWidgetFragment.clickEditPaymentMethodButton();
	}

	public void editUserPaymentMethod(String paymentMethodName){
		
		navigateToUserPaymentMethodTab();
		selectPaymentMethod(paymentMethodName);
		clickEditPaymentMethodButton();
		MemberEditAlert memberEditAlert = new MemberEditAlert(starter);
		AlertNavigation<MemberEditAlert> navigation = new AlertNavigation<MemberEditAlert>(memberEditAlert);
		navigation.NavigatedTo();
		memberEditAlert.acceptAlert();
	}

    public void closeMemberListWidget(){
    	
    	closeWidget(getPageName());
    }
}
