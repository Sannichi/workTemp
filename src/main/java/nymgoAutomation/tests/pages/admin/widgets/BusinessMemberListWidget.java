package nymgoAutomation.tests.pages.admin.widgets;

import nymgoAutomation.tests.fragments.admin.widgets.BusinessMemberListWidgetFragment;
import nymgoAutomation.tests.navigation.AlertNavigation;
import nymgoAutomation.tests.pages.admin.alerts.MemberEditAlert;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public class BusinessMemberListWidget extends AbstractWidget{

	BusinessMemberListWidgetFragment businessMemberListWidgetFragment;
	
	public BusinessMemberListWidget(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		businessMemberListWidgetFragment = new BusinessMemberListWidgetFragment(driver);
	}

	private static final String WIDGET_BUSINESS_MEMBERS_LIST_NAME_ENG = "Info"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return businessMemberListWidgetFragment.getWidgetName();
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return getPageName().equals(WIDGET_BUSINESS_MEMBERS_LIST_NAME_ENG);
	}
	
	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return WIDGET_BUSINESS_MEMBERS_LIST_NAME_ENG;
	}

	private BusinessMemberListWidget navigateToBusinessUserPaymentMethodTab(){
		
		businessMemberListWidgetFragment.navigateToBusinessPaymentMethodTab();
		return this;
	}
	
	private void selectPaymentMethod(String paymentMethodName){
		
		businessMemberListWidgetFragment.selectPaymentMethod(paymentMethodName);
	}

	private void clickEditPaymentMethodButton(){
		
		businessMemberListWidgetFragment.clickEditPaymentMethodButton();
	}

	public void editBusinessUserPaymentMethod(String paymentMethodName){
		
		navigateToBusinessUserPaymentMethodTab();
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
