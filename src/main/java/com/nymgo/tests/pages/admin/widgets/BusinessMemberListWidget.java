package com.nymgo.tests.pages.admin.widgets;

import com.nymgo.tests.enums.BONUS_TYPE_CONST;
import com.nymgo.tests.fragments.admin.widgets.BusinessMemberListWidgetFragment;
import com.nymgo.tests.navigation.AlertNavigation;
import com.nymgo.tests.pages.admin.alerts.BonusTypeEditAlert;
import com.nymgo.tests.pages.admin.alerts.MemberEditAlert;
import com.nymgo.tests.starter.Starter;

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

	public BusinessMemberListWidget navigateToInfoTab(){
		
		businessMemberListWidgetFragment.navigateToInfoTab();
		return this;
	}

	public void selectBonusType(String bonusTypeName){
		
		businessMemberListWidgetFragment.selectBonusType(bonusTypeName);
	}

	public void selectBonusTypeValue(String bonusTypeValue){
		
		businessMemberListWidgetFragment.selectBonusTypeValue(bonusTypeValue);
	}
	
	public void editBusinessUserBonusType(String bonusType, String bonusTypeValue){
		
		navigateToInfoTab();
		BONUS_TYPE_CONST bonusTypeName = BONUS_TYPE_CONST.valueOf(bonusType.toUpperCase());
		BONUS_TYPE_CONST bonusValue = BONUS_TYPE_CONST.valueOf(bonusTypeValue);
		if (bonusTypeName.equals(BONUS_TYPE_CONST.MANUAL)){
			selectBonusType(bonusType);
			selectBonusTypeValue(bonusValue.toString());
		}else{
			// by default if not MANUAL, set AUTOMATIC
			selectBonusType(BONUS_TYPE_CONST.AUTOMATIC.toString());
		}
		BonusTypeEditAlert bonusTypeEditAlert = new BonusTypeEditAlert(starter);
		AlertNavigation<BonusTypeEditAlert> navigation = new AlertNavigation<BonusTypeEditAlert>(bonusTypeEditAlert);
		navigation.NavigatedTo();
		bonusTypeEditAlert.acceptAlert();
	}

	public void closeMemberListWidget(){
    	
    	closeWidget(getPageName());
    }
}
