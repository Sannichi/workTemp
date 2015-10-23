package nymgoAutomation.tests.pages.nymgo.menu.buyCredit;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import nymgoAutomation.tests.enums.CURRENCY_SIGNS;
import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BuyCreditPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.base.AbstractLoggedInPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.adyen.BuyCreditProceedPageAdyen;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.globalCollect.BuyCreditProceedPageGlobalCollect;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCreditProceedPageWorldpay;
import nymgoAutomation.tests.starter.Starter;
import nymgoAutomation.tests.utils.CurrencyDescriptionMap;

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

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return buyCreditPageFragment.getCorrectURL();
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

	public BuyCreditProceedPageGlobalCollect selectAmountAndClickContinueToGlobalCollect(String amount){
		
		int intAmount = Integer.valueOf(amount);
		checkOptionByValue(intAmount);
		return clickContinueToGlobalCollect();
	} 
	
	public BuyCreditProceedPageWorldpay selectAmountAndClickContinueToWorldpay(String amount){
		
		int intAmount = Integer.valueOf(amount);
		checkOptionByValue(intAmount);
		return clickContinueToWorldpay();
	} 
	
	public BuyCreditProceedPageAdyen selectAmountAndClickContinueToAdyen(String amount){
		
		int intAmount = Integer.valueOf(amount);
		checkOptionByValue(intAmount);
		return clickContinueToAdyen();
	} 
	
	public BuyCreditProceedPageGlobalCollect clickContinueToGlobalCollect(){
		
		clickContinueButton();
		BuyCreditProceedPageGlobalCollect buyCreditProceedPageGlobalCollect = new BuyCreditProceedPageGlobalCollect(starter);
		PageNavigation<BuyCreditProceedPageGlobalCollect> navigation = new PageNavigation<BuyCreditProceedPageGlobalCollect>(buyCreditProceedPageGlobalCollect);
		navigation.NavigatedTo();
		return buyCreditProceedPageGlobalCollect;
	} 
	
	public BuyCreditProceedPageWorldpay clickContinueToWorldpay(){
		
		clickContinueButton();
		BuyCreditProceedPageWorldpay buyCreditProceedPageWorldpay = new BuyCreditProceedPageWorldpay(starter);
		PageNavigation<BuyCreditProceedPageWorldpay> navigation = new PageNavigation<BuyCreditProceedPageWorldpay>(buyCreditProceedPageWorldpay);
		navigation.NavigatedTo();
		return buyCreditProceedPageWorldpay;
	} 
	
	public BuyCreditProceedPageAdyen clickContinueToAdyen(){
		
		clickContinueButton();
		BuyCreditProceedPageAdyen buyCreditProceedPageAdyen = new BuyCreditProceedPageAdyen(starter);
		PageNavigation<BuyCreditProceedPageAdyen> navigation = new PageNavigation<BuyCreditProceedPageAdyen>(buyCreditProceedPageAdyen);
		navigation.NavigatedTo();
		return buyCreditProceedPageAdyen;
	} 

	public void selectMinAmountByCurrency(String paymentCurrency){
		
		checkOptionByValue(CurrencyDescriptionMap.getCurrencyDescriptionByKey(CURRENCY_SIGNS.valueOf(paymentCurrency)).getFirstValue());
	}
	
	public void selectMaxAmountByCurrency(String paymentCurrency){
		
		checkOptionByValue(CurrencyDescriptionMap.getCurrencyDescriptionByKey(CURRENCY_SIGNS.valueOf(paymentCurrency)).getThirdValue());
	}

	public void selectAmountAndVerifyVAT(String amount){
		
		int intAmount = Integer.valueOf(amount);
		checkOptionByValue(intAmount);
		Assert.assertTrue(verifyVATValue(intAmount), "VAT is not correct. Current value is '" + getVATValue() + "', should be '" + (intAmount * Float.valueOf(getVATPercent()) / 100) + "'");
	} 
	
	public String getVATPercent(){
		
		return buyCreditPageFragment.getVATPercent();
	}

	public String getVATValue(){
		
		return buyCreditPageFragment.getVATValue();
	}
	
	public boolean verifyVATValue(int nymgoCreditAmount){
		
		boolean result = false;
		Float asIs = Float.valueOf(getVATValue());
		Float shouldBe = nymgoCreditAmount * Float.valueOf(getVATPercent()) / 100;		
		
		result = shouldBe.equals(asIs);
		return result;
	}
}
