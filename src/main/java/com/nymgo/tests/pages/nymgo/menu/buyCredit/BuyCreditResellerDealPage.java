package com.nymgo.tests.pages.nymgo.menu.buyCredit;

import org.testng.asserts.SoftAssert;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.BuyCreditResellerDealPageFragment;
import com.nymgo.tests.generators.DealsNameGenerator;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.BuyCreditPage;
import com.nymgo.tests.starter.Starter;
import com.nymgo.tests.utils.DealDescription;
import com.nymgo.tests.utils.DealDescriptionMap;
import com.nymgo.tests.utils.Rounder;

/**
 * Created by Iuliia Khikmatova on Jan 19, 2016
 */
public class BuyCreditResellerDealPage extends BuyCreditPage {

	BuyCreditResellerDealPageFragment buyCreditResellerDealPageFragment;
	
	public BuyCreditResellerDealPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditResellerDealPageFragment = new BuyCreditResellerDealPageFragment(driver);
	}

	private void selectDealByName(String dealName){
		
		buyCreditResellerDealPageFragment.selectDealByName(dealName);
	}
	
	public String getDealNameByDealCurrency(String dealCurrency){

		return DealsNameGenerator.getDealKeyBySign(dealCurrency);
	}
	
	public void selectDealByDealCurrency(String dealCurrency){

		String dealName = getDealNameByDealCurrency(dealCurrency);
		selectDealByName(dealName);
	}
	
	public void setDealsQuantity(String dealsQuantity){
		
		buyCreditResellerDealPageFragment.setDealsQuantity(dealsQuantity);
	}

	public String getDealVATPercent(){
		
		return buyCreditResellerDealPageFragment.getDealVATPercent();
	}

	public String getDealVATValue(){
		
		return buyCreditResellerDealPageFragment.getDealVATValue();
	}

	public String getDealTotalAmountValue(){
		
		return buyCreditResellerDealPageFragment.getDealTotalAmountValue();
	}

	public String getDealPackageMinutesValue(){
		
		return buyCreditResellerDealPageFragment.getDealPackageMinutesValue();
	}

	public String getDealImtuAmountValue(){
		
		return buyCreditResellerDealPageFragment.getDealImtuAmountValue();
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
	
	public boolean verifyDealImtuAmount(DealDescription dealDescription){
		
		boolean result = false;
		int asIs = Integer.valueOf(getDealImtuAmountValue());
		int shouldBe = dealDescription.getImtuAmount();
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
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(verifyDealVATValue(intQuantity, price), "Deal VAT is not correct. Current value is '" + getDealVATValue() + 
				"', should be '" + Rounder.roundFloat((price * intQuantity * Integer.valueOf(getDealVATPercent()) / 100), 2) + "'");
		LOGGER.info("Deal VAT value is correct");
		softAssert.assertTrue(verifyDealTotalAmountValue(intQuantity, price), "Deal Total Amount is not correct. Current value is '" + getDealTotalAmountValue() + 
				"', should be '" + (intQuantity * price + Rounder.roundFloat(Float.valueOf(getDealVATValue()), 2)) + "'");
		LOGGER.info("Deal Total Amount value is correct");
		softAssert.assertTrue(verifyDealMinutes(dealDescription), "Deal Minutes are not correct. Current value is '" + getDealPackageMinutesValue() + "', should be '" + (dealDescription.getMinutes()) + "'");
		LOGGER.info("Deal Minutes value is correct");
		softAssert.assertTrue(verifyDealImtuAmount(dealDescription), "Deal Imtu Amount is not correct. Current value is '" + getDealImtuAmountValue() + "', should be '" + (dealDescription.getImtuAmount() + "'"));
		LOGGER.info("Deal Imtu Amount value is correct");
		softAssert.assertAll();
	} 

	public void selectDealAndQuantity(String paymentCurrency, String dealCurrency, String dealName, String dealQuantity){
		
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
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(verifyDealTotalAmountValue(intQuantity, price), "Deal Total Amount is not correct. Current value is '" + getDealTotalAmountValue() + "', should be '" + (intQuantity * price + Float.valueOf(getDealVATValue())) + "'");
		LOGGER.info("Deal Total Amount value is correct");
		softAssert.assertTrue(verifyDealMinutes(dealDescription), "Deal Minutes are not correct. Current value is '" + getDealPackageMinutesValue() + "', should be '" + (dealDescription.getMinutes()) + "'");
		LOGGER.info("Deal Minutes value is correct");
		softAssert.assertTrue(verifyDealImtuAmount(dealDescription), "Deal Imtu Amount is not correct. Current value is '" + getDealImtuAmountValue() + "', should be '" + (dealDescription.getImtuAmount() + "'"));
		LOGGER.info("Deal Imtu Amount value is correct");
		softAssert.assertAll();
	} 
}
