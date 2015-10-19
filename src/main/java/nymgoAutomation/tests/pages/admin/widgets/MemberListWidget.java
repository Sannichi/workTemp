package nymgoAutomation.tests.pages.admin.widgets;

import nymgoAutomation.tests.fragments.admin.widgets.MemberListWidgetFragment;
import nymgoAutomation.tests.navigation.Starter;

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
	}

    public void closeMemberListWidget(){
    	
    	closeWidget(getPageName());
    }
}
