package nymgoAutomation.tests.fragments.admin.widgets;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import nymgoAutomation.tests.enums.BUSINESS_MEMBERS_LIST_TABS;
/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public class BusinessMemberListWidgetFragment extends BaseWidgetFragment{

	public BusinessMemberListWidgetFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath=".//select[@name='payment_method']")
	private WebElement paymentMethodSelect;

	@FindBy(xpath=".//input[@value='EDIT']")
	private List<WebElement> editButtons;
	
	public void navigateToBusinessPaymentMethodTab(){
		
		clickOnTabByAltText(BUSINESS_MEMBERS_LIST_TABS.BUSINESS_PAYMENT_METHOD.toString());
	}
	
	public void selectPaymentMethod(String paymentMethodName){
		
		selectValueFromSelectByVisibleText(paymentMethodSelect, paymentMethodName);
	}

	public void clickEditPaymentMethodButton(){
		
		clickInputButton(editButtons.get(0));
	}
}
