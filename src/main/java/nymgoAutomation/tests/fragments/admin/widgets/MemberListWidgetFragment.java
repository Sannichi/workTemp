package nymgoAutomation.tests.fragments.admin.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import nymgoAutomation.tests.enums.MEMBERS_LIST_TABS;

public class MemberListWidgetFragment extends BaseWidgetFragment{

	public MemberListWidgetFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath=".//select[@name='payment_method']")
	private WebElement paymentMethodSelect;

	@FindBy(xpath=".//input[@value='EDIT']")
	private WebElement editButton;
	
	public void navigateToUserPaymentMethodTab(){
		
		clickOnTabByAltText(MEMBERS_LIST_TABS.USER_PAYMENT_METHOD.toString());
	}
	
	public void selectPaymentMethod(String paymentMethodName){
		
		selectValueFromSelectByVisibleText(paymentMethodSelect, paymentMethodName);
	}

	public void clickEditPaymentMethodButton(){
		
		clickInputButton(editButton);
	}
}
