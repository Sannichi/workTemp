package com.nymgo.tests.pages.nymgo.menu.buyCredit;

import org.testng.Assert;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.BuyCreditDealPageFragment;
import com.nymgo.tests.generators.DealsNameGenerator;
import com.nymgo.tests.starter.Starter;
import com.nymgo.tests.utils.DealDescription;
import com.nymgo.tests.utils.DealDescriptionMap;

/**
 * Created by Iuliia Khikmatova on Jan 19, 2016
 */
public class BuyCreditDealPage extends BuyCreditPage {

	BuyCreditDealPageFragment buyCreditDealPageFragment;
	
	public BuyCreditDealPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditDealPageFragment = new BuyCreditDealPageFragment(driver);
	}

	private void selectDealByName(String dealName){
		
		buyCreditDealPageFragment.selectDealByName(dealName);
	}
	
	public String getDealNameByDealCurrency(String dealCurrency){

		return DealsNameGenerator.getDealKeyBySign(dealCurrency);
	}
	
	public void selectDealByDealCurrency(String dealCurrency){

		String dealName = getDealNameByDealCurrency(dealCurrency);
		selectDealByName(dealName);
	}
	
	public void setDealsQuantity(String dealsQuantity){
		
		buyCreditDealPageFragment.setDealsQuantity(dealsQuantity);
	}

	public String getDealVATPercent(){
		
		return buyCreditDealPageFragment.getDealVATPercent();
	}

	public String getDealVATValue(){
		
		return buyCreditDealPageFragment.getDealVATValue();
	}

	public String getDealTotalAmountValue(){
		
		return buyCreditDealPageFragment.getDealTotalAmountValue();
	}

	public String getDealPackageMinutesValue(){
		
		return buyCreditDealPageFragment.getDealPackageMinutesValue();
	}

	public String getDealImtuAmountValue(){
		
		return buyCreditDealPageFragment.getDealImtuAmountValue();
	}

	public boolean verifyDealVATValue(int dealQuantity, Float price){
		
		boolean result = false;
		Float asIs = Float.valueOf(getDealVATValue());
		Float shouldBe = dealQuantity * price * Float.valueOf(getDealVATPercent()) / 100;		
		result = shouldBe.equals(asIs);
		return result;
	}
	
	public boolean verifyDealTotalAmountValue(int dealQuantity, Float price){
		
		boolean result = false;
		Float dealVAT = Float.valueOf(getDealVATValue());
		Float asIs = Float.valueOf(getDealTotalAmountValue());
		Float shouldBe = dealQuantity * price + dealVAT;		
		result = shouldBe.equals(asIs);
		return result;
	}
	
	public boolean verifyDealMinutes(DealDescription dealDescription){
		
		boolean result = false;
		int asIs = Integer.valueOf(getDealPackageMinutesValue());
		int shouldBe = dealDescription.getMinutes();
		result = shouldBe == asIs;
		return result;
	}
	
	public void selectDealAndQuantityAndVerifyVATAndTotal(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity){
		
		LOGGER.debug("Deal currency is: '" + dealCurrency + "', deal name is '" + dealName == null ? getDealNameByDealCurrency(dealCurrency) : dealName + "'");
		DealDescription dealDescription;
		int intQuantity = Integer.valueOf(dealQuantity);
		if(dealName == null){
			selectDealByDealCurrency(dealCurrency);
			dealDescription = DealDescriptionMap.getFirstDealDescriptionByCurrencySign(dealCurrency);
		}
		else{
			selectDealByName(dealName);
			dealDescription = DealDescriptionMap.getDealDescriptionByName(dealName);
		}
		setDealsQuantity(dealQuantity);
		Float price = dealDescription.getPriceByPaymentCurrency(paymentCurrency);
		Assert.assertTrue(verifyDealVATValue(intQuantity, price), "Deal VAT is not correct. Current value is '" + getDealVATValue() + "', should be '" + (intQuantity * price * Float.valueOf(getDealVATPercent()) / 100) + "'");
		Assert.assertTrue(verifyDealTotalAmountValue(intQuantity, price), "Deal Total Amount is not correct. Current value is '" + getDealTotalAmountValue() + "', should be '" + (intQuantity * price + Float.valueOf(getDealVATValue())) + "'");
		Assert.assertTrue(verifyDealMinutes(dealDescription), "Deal Minutes are not correct. Current value is '" + getDealPackageMinutesValue() + "', should be '" + (dealDescription.getMinutes()) + "'");
	} 
}