package com.nymgo.tests.pages.nymgo.menu.buyCredit;

//import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.BuyCreditPageFragment;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.adyen.BuyCredit3DSProceedPageAdyen;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.globalCollect.BuyCreditProceedPageGlobalCollect;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.worldpay.BuyCredit3DSProceedPageWorldpay;
import com.nymgo.tests.starter.Starter;

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
/*
	private ArrayList<Integer> getDisabledAdyenOptionsValues(){
		
		return buyCreditPageFragment.getDisabledAdyenOptionsValues();	
	}

	private List<String> getAllCurencyValuesOptions(){
		
		return buyCreditPageFragment.getAllCurencyValuesOptions();	
	}
*/
	private String getCheckedOptionDescription() throws NoSuchElementException{
		
		return buyCreditPageFragment.getCheckedOptionDescription();
	}

	private int getCheckedOptionValue(){
		try{
			return Integer.parseInt(getCheckedOptionDescription().split(" ")[1]);
		}
		catch(NoSuchElementException e){
			return 0;
		}
	}
	
	private void checkOptionByValue(int value){
		
		buyCreditPageFragment.checkOptionByValue(value);
		Assert.assertTrue(getCheckedOptionValue() == value, "Could not select option " + value + "!");
	}
/*
	private boolean isValueDisabled(int value){

		return buyCreditPageFragment.isValueDisabled(value);
	}
*/	
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
	
//	public BuyCredit3DSProceedPageGlobalCollect selectAmountAndClickContinueToGlobalCollect(String amount){
//		
//		int intAmount = Integer.valueOf(amount);
//		checkOptionByValue(intAmount);
//		return clickContinueToGlobalCollect();
//	} 
	
	public BuyCredit3DSProceedPageWorldpay selectAmountAndClickContinueToWorldpay(String amount){
		
		int intAmount = Integer.valueOf(amount);
		checkOptionByValue(intAmount);
		return clickContinueToWorldpay();
	} 
	
	public BuyCredit3DSProceedPageAdyen selectAmountAndClickContinueToAdyen(String amount){
		
		int intAmount = Integer.valueOf(amount);
		checkOptionByValue(intAmount);
		return clickContinueToAdyen();
	} 
	
	public BuyCreditProceedPageGlobalCollect clickContinueToGlobalCollect(){
		
		clickContinueButton();
		BuyCreditProceedPageGlobalCollect buyCreditProceedPageGlobalCollect = new BuyCreditProceedPageGlobalCollect(starter);
		buyCreditProceedPageGlobalCollect.getUpperMessage();
		PageNavigation<BuyCreditProceedPageGlobalCollect> navigation = new PageNavigation<BuyCreditProceedPageGlobalCollect>(buyCreditProceedPageGlobalCollect);
		navigation.NavigatedTo();
		return buyCreditProceedPageGlobalCollect;
	} 
	
//	public BuyCredit3DSProceedPageGlobalCollect clickContinueToGlobalCollect(){
//		
//		clickContinueButton();
//		BuyCredit3DSProceedPageGlobalCollect buyCredit3DSProceedPageGlobalCollect = new BuyCredit3DSProceedPageGlobalCollect(starter);
//		PageNavigation<BuyCredit3DSProceedPageGlobalCollect> navigation = new PageNavigation<BuyCredit3DSProceedPageGlobalCollect>(buyCredit3DSProceedPageGlobalCollect);
//		navigation.NavigatedTo();
//		return buyCredit3DSProceedPageGlobalCollect;
//	} 
	
	public BuyCredit3DSProceedPageWorldpay clickContinueToWorldpay(){
		
		clickContinueButton();
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		PageNavigation<BuyCredit3DSProceedPageWorldpay> navigation = new PageNavigation<BuyCredit3DSProceedPageWorldpay>(buyCredit3DSProceedPageWorldpay);
		navigation.NavigatedTo();
		return buyCredit3DSProceedPageWorldpay;
	} 
	
	public BuyCredit3DSProceedPageAdyen clickContinueToAdyen(){
		
		clickContinueButton();
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		PageNavigation<BuyCredit3DSProceedPageAdyen> navigation = new PageNavigation<BuyCredit3DSProceedPageAdyen>(buyCredit3DSProceedPageAdyen);
		navigation.NavigatedTo();
		return buyCredit3DSProceedPageAdyen;
	} 
/*
	public void selectMinAmountByCurrency(String paymentCurrency){
		
		checkOptionByValue(CurrencyDescriptionMap.getCurrencyDescriptionByKey(CURRENCY_SIGNS.valueOf(paymentCurrency)).getFirstValue());
	}
	
	public void selectMaxAmountByCurrency(String paymentCurrency){
		
		checkOptionByValue(CurrencyDescriptionMap.getCurrencyDescriptionByKey(CURRENCY_SIGNS.valueOf(paymentCurrency)).getThirdValue());
	}
*/
	public void selectAmountAndVerifyVAT(String amount){
		
		LOGGER.debug("Amount is: '" + amount + "'");
		int intAmount = Integer.valueOf(amount);
		checkOptionByValue(intAmount);
		Assert.assertTrue(verifyVATValue(intAmount), "VAT is not correct. Current value is '" + getVATValue() + "', should be '" + (intAmount * Float.valueOf(getVATPercent()) / 100) + "'");
	} 
	
	public void selectAmount(String amount){
		
		int intAmount = Integer.valueOf(amount);
		checkOptionByValue(intAmount);
//		Assert.assertTrue(verifyVATValue(intAmount), "VAT is not correct. Current value is '" + getVATValue() + "', should be '" + (intAmount * Float.valueOf(getVATPercent()) / 100) + "'");
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
