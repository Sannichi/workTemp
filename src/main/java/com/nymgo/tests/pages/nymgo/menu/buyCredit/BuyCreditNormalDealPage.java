package com.nymgo.tests.pages.nymgo.menu.buyCredit;

import org.testng.Assert;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.BuyCreditNormalDealPageFragment;
import com.nymgo.tests.generators.DealsNameGenerator;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.BuyCreditPage;
import com.nymgo.tests.starter.Starter;
import com.nymgo.tests.utils.DealDescription;
import com.nymgo.tests.utils.DealDescriptionMap;

/**
 * Created by Iuliia Khikmatova on Jan 19, 2016
 */
public class BuyCreditNormalDealPage extends BuyCreditPage {

	BuyCreditNormalDealPageFragment buyCreditNormalDealPageFragment;
	
	public BuyCreditNormalDealPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditNormalDealPageFragment = new BuyCreditNormalDealPageFragment(driver);
	}

	private void selectCountryByName(String countryName){
		
		buyCreditNormalDealPageFragment.selectCountryByName(countryName);
	}
	
	private String getCountryByDealCurrency(String dealCurrency){

		return DealsNameGenerator.getDealKeyBySign(dealCurrency);
	}
	
	public void selectCountryByDealCurrency(String dealCurrency){

		String countryName = getCountryByDealCurrency(dealCurrency);
		selectCountryByName(countryName);
	}
	
	public String getDealVATPercent(){
		
		return buyCreditNormalDealPageFragment.getDealVATPercent();
	}

	public String getDealVATValue(){
		
		return buyCreditNormalDealPageFragment.getDealVATValue();
	}

	public String getDealTotalAmountValue(){
		
		return buyCreditNormalDealPageFragment.getDealTotalAmountValue();
	}

	public String getDealMinutesValue(){
		
		return buyCreditNormalDealPageFragment.getDealMinutesValue();
	}

	public String getDealImtuAmountValue(){
		
		return buyCreditNormalDealPageFragment.getDealImtuAmountValue();
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
		int asIs = Integer.valueOf(getDealMinutesValue());
		int shouldBe = dealDescription.getMinutes();
		result = shouldBe == asIs;
		return result;
	}
	
	public boolean verifyDealImtuAmount(DealDescription dealDescription){
		
		boolean result = false;
		int asIs = Integer.valueOf(getDealImtuAmountValue());
		int shouldBe = dealDescription.getMinutes();
		result = shouldBe == asIs;
		return result;
	}
	
	public void selectDealAndQuantityAndVerifyVATAndTotal(String paymentCurrency, String dealCurrency, String countryName, String dealQuantity){
		
		LOGGER.debug("Deal currency is: '" + dealCurrency + "', deal name is '" + countryName == null ? getCountryByDealCurrency(dealCurrency) : countryName + "'");
		DealDescription dealDescription;
		int intQuantity = Integer.valueOf(dealQuantity);
		if(countryName == null){
			selectCountryByDealCurrency(dealCurrency);
			dealDescription = DealDescriptionMap.getFirstDealDescriptionByCurrencySign(dealCurrency);
		}
		else{
			selectCountryByName(countryName);
			dealDescription = DealDescriptionMap.getDealDescriptionByName(countryName);
		}
		Float price = dealDescription.getPriceByPaymentCurrency(paymentCurrency);
		Assert.assertTrue(verifyDealVATValue(intQuantity, price), "Deal VAT is not correct. Current value is '" + getDealVATValue() + "', should be '" + (intQuantity * price * Float.valueOf(getDealVATPercent()) / 100) + "'");
		Assert.assertTrue(verifyDealTotalAmountValue(intQuantity, price), "Deal Total Amount is not correct. Current value is '" + getDealTotalAmountValue() + "', should be '" + (intQuantity * price + Float.valueOf(getDealVATValue())) + "'");
		Assert.assertTrue(verifyDealMinutes(dealDescription), "Deal Minutes are not correct. Current value is '" + getDealMinutesValue() + "', should be '" + (dealDescription.getMinutes()) + "'");
	} 
}
