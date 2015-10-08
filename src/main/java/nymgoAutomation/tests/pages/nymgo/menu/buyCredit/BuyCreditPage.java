package nymgoAutomation.tests.pages.nymgo.menu.buyCredit;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BuyCreditPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.nymgo.base.AbstractLoggedInPage;

public class BuyCreditPage extends AbstractLoggedInPage{

	private BuyCreditPageFragment buyCreditPageFragment;
	
	private static final String BUY_CREDIT_PAGE_NAME_ENG = "BuyCreditPage"; 
			
    public BuyCreditPage(Starter starter) {
        super(starter);
        buyCreditPageFragment = new BuyCreditPageFragment(driver);
    }
    
    @Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_PAGE_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return buyCreditPageFragment.isCorrectURL();
	}

	public List<String> getAllAdyenOptionsDescription(){
		
		return buyCreditPageFragment.getAllAdyenOptionsDescription();
	}

	private ArrayList<Integer> getDisabledAdyenOptionsValues(){
		
		return buyCreditPageFragment.getDisabledAdyenOptionsValues();	
	}

	private List<String> getAllCurencyValuesOptions(){
		
		return buyCreditPageFragment.getAllCurencyValuesOptions();	
	}

	private String getCheckedOptionDescription(){
		
		return buyCreditPageFragment.getCheckedOptionDescription();
	}

	private int getCheckedOptionValue(){
		
		return Integer.parseInt(getCheckedOptionDescription().split(" ")[1]);
	}
	
	private void checkOptionByValue(int value){
		
		buyCreditPageFragment.checkOptionByValue(value);
		Assert.assertTrue(getCheckedOptionValue() == value, "Could not select option!");
	}

	private boolean isValueDisabled(int value){

		return buyCreditPageFragment.isValueDisabled(value);
	}
	
	private void clickContinueButton(){
		
		buyCreditPageFragment.clickContinueButton();
	}
	
	//can return GC, Worldpay and Adyen
	public void selectAmountAndClickContinue(int amount){
		
		checkOptionByValue(amount);
		clickContinueButton();
	} 

	public BuyCreditProceedPageGlobalCollect selectAmountAndClickContinueToGlobalCollect(int amount){
		
		checkOptionByValue(amount);
		clickContinueButton();
		BuyCreditProceedPageGlobalCollect buyCreditProceedPageGlobalCollect = new BuyCreditProceedPageGlobalCollect(starter);
		PageNavigation<BuyCreditProceedPageGlobalCollect> navigation = new PageNavigation<BuyCreditProceedPageGlobalCollect>(buyCreditProceedPageGlobalCollect);
		navigation.NavigatedTo();
		return buyCreditProceedPageGlobalCollect;
	} 
}
