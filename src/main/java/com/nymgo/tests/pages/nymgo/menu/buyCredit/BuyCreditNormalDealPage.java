package com.nymgo.tests.pages.nymgo.menu.buyCredit;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.BuyCreditNormalDealPageFragment;
import com.nymgo.tests.generators.DealsCountryNameGenerator;
import com.nymgo.tests.generators.DealsNameGenerator;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.BuyCreditPage;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen.BuyCredit3DSProceedPageAdyen;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.globalCollect.BuyCreditProceedPageGlobalCollect;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay.BuyCredit3DSProceedPageWorldpay;
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

	public void clickContinueDealButton(){
		
		buyCreditNormalDealPageFragment.clickContinueDealButton();
	}
	
	private void selectCountryByName(String countryName){
		
		buyCreditNormalDealPageFragment.selectCountryByName(countryName);
	}
	
	private String getCountryByDealCurrency(String dealCurrency){

		return DealsNameGenerator.getDealKeyBySign(dealCurrency);
	}
	
	public void selectCountryByDealCurrency(String dealCurrency){

//		String dealName = getCountryByDealCurrency(dealCurrency);
//		String countryName = dealName.split(" Deal")[0];
		String countryName = DealsCountryNameGenerator.getDealKeyBySign(dealCurrency); 
		selectCountryByName(countryName);
	}
	
	private String getCheckedDealOptionDescription() throws NoSuchElementException{
		
		return buyCreditNormalDealPageFragment.getCheckedDealOptionDescription();
	}

	private Float getCheckedDealOptionValue(){
		try{
			return Float.parseFloat(getCheckedDealOptionDescription().split(" ")[0]);
		}
		catch(NoSuchElementException e){
			return null;
		}
	}
	
	private void checkDealOptionByPrice(Float price){
		
		buyCreditNormalDealPageFragment.checkDealOptionByPrice(price);
		Assert.assertTrue(getCheckedDealOptionValue().equals(price), "Could not select option " + price + "!");
	}

	public BuyCreditProceedPageGlobalCollect selectPriceAndClickContinueToGlobalCollect(String price){
		
		Float intPrice = Float.valueOf(price);
		checkDealOptionByPrice(intPrice);
		return clickContinueDealToGlobalCollect();
	} 
	
	public BuyCredit3DSProceedPageWorldpay selectPriceAndClickContinueToWorldpay(String price){
		
		Float intPrice = Float.valueOf(price);
		checkDealOptionByPrice(intPrice);
		return clickContinueDealToWorldpay();
	} 
	
	public BuyCredit3DSProceedPageAdyen selectPriceAndClickContinueToAdyen(String price){
		
		Float intPrice = Float.valueOf(price);
		checkDealOptionByPrice(intPrice);
		return clickContinueDealToAdyen();
	} 
	
	public BuyCreditProceedPageGlobalCollect clickContinueDealToGlobalCollect(){
		
		clickContinueDealButton();
		BuyCreditProceedPageGlobalCollect buyCreditProceedPageGlobalCollect = new BuyCreditProceedPageGlobalCollect(starter);
		PageNavigation<BuyCreditProceedPageGlobalCollect> navigation = new PageNavigation<BuyCreditProceedPageGlobalCollect>(buyCreditProceedPageGlobalCollect);
		Assert.assertNotEquals(buyCreditProceedPageGlobalCollect.getErrorMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.ANOTHER_TRANSACTION_IN_PROGRESS_MESSAGE), "Another transaction is in progress");
		navigation.NavigatedTo();
		return buyCreditProceedPageGlobalCollect;
	} 
	
	public BuyCredit3DSProceedPageWorldpay clickContinueDealToWorldpay(){
		
		clickContinueDealButton();
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		PageNavigation<BuyCredit3DSProceedPageWorldpay> navigation = new PageNavigation<BuyCredit3DSProceedPageWorldpay>(buyCredit3DSProceedPageWorldpay);
		Assert.assertNotEquals(buyCredit3DSProceedPageWorldpay.getErrorMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.ANOTHER_TRANSACTION_IN_PROGRESS_MESSAGE), "Another transaction is in progress");
		navigation.NavigatedTo();
		return buyCredit3DSProceedPageWorldpay;
	} 
	
	public BuyCredit3DSProceedPageAdyen clickContinueDealToAdyen(){
		
		clickContinueDealButton();
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		PageNavigation<BuyCredit3DSProceedPageAdyen> navigation = new PageNavigation<BuyCredit3DSProceedPageAdyen>(buyCredit3DSProceedPageAdyen);
		Assert.assertNotEquals(buyCredit3DSProceedPageAdyen.getErrorMessage(), LocaleGenerator.getLocaleKey(LOCALE_CONST.ANOTHER_TRANSACTION_IN_PROGRESS_MESSAGE), "Another transaction is in progress");
		navigation.NavigatedTo();
		return buyCredit3DSProceedPageAdyen;
	} 

	public void selectPriceAndVerifyVAT(String price){
		
		LOGGER.debug("Price is: '" + price + "'");
		Float intPrice = Float.valueOf(price);
		checkDealOptionByPrice(intPrice);
		Assert.assertTrue(verifyDealVATValue(intPrice), "VAT is not correct. Current value is '" + getDealVATValue() + "', should be '" + (intPrice * Float.valueOf(getDealVATPercent()) / 100) + "'");
	} 
	
	public void selectPrice(Float price){
		
//		int intPrice = Integer.valueOf(price);
		checkDealOptionByPrice(price);
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

	public boolean verifyDealVATValue(Float price){
		
		boolean result = false;
		Float asIs = roundFloat(Float.valueOf(getDealVATValue()), 2);
		Float shouldBe = roundFloat(price * Integer.valueOf(getDealVATPercent()) / 100, 2);		
		result = shouldBe.equals(asIs);
		return result;
	}
	
	public boolean verifyDealTotalAmountValue(Float price){
		
		boolean result = false;
		Float dealVAT = roundFloat(Float.valueOf(getDealVATValue()), 2);
		Float asIs = roundFloat(Float.valueOf(getDealTotalAmountValue()), 2);
		Float shouldBe = price + dealVAT;		
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
		int shouldBe = dealDescription.getImtuAmount();
		result = shouldBe == asIs;
		return result;
	}
	
	public void selectCountryAndDealAndVerifyVATAndTotal(String paymentCurrency, String dealCurrency, String dealName){
		
		LOGGER.debug("Deal currency is: '" + dealCurrency + "', deal name is '" + dealName == null ? getCountryByDealCurrency(dealCurrency) : dealName + "'");
		DealDescription dealDescription;
		selectCountryByDealCurrency(dealCurrency);
		if(dealName == null){
			dealDescription = DealDescriptionMap.getFirstDealDescriptionByCurrencySign(dealCurrency);
		}
		else{
			dealDescription = DealDescriptionMap.getDealDescriptionByName(dealName);
		}
		Float price = dealDescription.getPriceByPaymentCurrency(paymentCurrency);
		selectPrice(price);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(verifyDealVATValue(price), "Deal VAT is not correct. Current value is '" + getDealVATValue() + 
				"', should be '" + roundFloat((price * Integer.valueOf(getDealVATPercent()) / 100), 2) + "'");
		softAssert.assertTrue(verifyDealTotalAmountValue(price), "Deal Total Amount is not correct. Current value is '" + getDealTotalAmountValue() + 
				"', should be '" + (price + roundFloat(Float.valueOf(getDealVATValue()), 2)) + "'");
		softAssert.assertTrue(verifyDealMinutes(dealDescription), "Deal Minutes are not correct. Current value is '" + getDealMinutesValue() + 
				"', should be '" + (dealDescription.getMinutes()) + "'");
		softAssert.assertTrue(verifyDealImtuAmount(dealDescription), "Deal Imtu Amount is not correct. Current value is '" + getDealImtuAmountValue() + 
				"', should be '" + (dealDescription.getImtuAmount()) + "'");
	} 
}
