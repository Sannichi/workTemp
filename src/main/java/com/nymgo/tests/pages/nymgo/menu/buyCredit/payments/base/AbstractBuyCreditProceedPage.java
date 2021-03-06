package com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.base;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.base.BaseBuyCreditProceedPageFragment;
import com.nymgo.tests.pages.nymgo.base.AbstractLoggedInPage;
import com.nymgo.tests.starter.Starter;
//import com.nymgo.tests.utils.CurrencyUtils;

//for GlobalCollect payments
public abstract class AbstractBuyCreditProceedPage extends AbstractLoggedInPage{

	private BaseBuyCreditProceedPageFragment baseBuyCreditProceedPageFragment;
	private SoftAssert softAssert = new SoftAssert();
	
	public AbstractBuyCreditProceedPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
        baseBuyCreditProceedPageFragment = new BaseBuyCreditProceedPageFragment(driver);
	}

//	abstract void verifyDataAndClickContinue();
	
	@Override
	public boolean isCorrectPage(){
		
		return baseBuyCreditProceedPageFragment.isCorrectURL();
	}
	
	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return baseBuyCreditProceedPageFragment.getCorrectURL();
	} 

	protected void clickContinueButton(){
		
		baseBuyCreditProceedPageFragment.clickContinueButton();
	}

	protected String getDefaultCardTypeValue(){
		
		return baseBuyCreditProceedPageFragment.getDefaultPaymentCardValue();
	}

	protected String getSelectedCardType(){
		
		return baseBuyCreditProceedPageFragment.getSelectedPaymentCard();
	}

	protected String getSelectedCountryOfCredit(){
		
		return baseBuyCreditProceedPageFragment.getSelectedCountryOfCredit();
	}

	protected String getNymgoCreditValue(){
		
		return baseBuyCreditProceedPageFragment.getNymgoCreditValue();
	}

	protected String getVATValue(){
		
		return baseBuyCreditProceedPageFragment.getVATValue();
	}

	protected String getTotalAmountChargedValue(){
		
		return baseBuyCreditProceedPageFragment.getTotalAmountChargedValue();
	}
	
	protected void selectPaymentCardType(String paymentCardType){
		
		baseBuyCreditProceedPageFragment.selectPaymentCard(paymentCardType);
		Assert.assertTrue(baseBuyCreditProceedPageFragment.getSelectedPaymentCard().equals(paymentCardType), "Payment type was not selected!");
	}

	protected void selectCountryOfCredit(String countryOfCredit){
		
		baseBuyCreditProceedPageFragment.selectCountryOfCredit(countryOfCredit);
		Assert.assertTrue(baseBuyCreditProceedPageFragment.getSelectedCountryOfCredit().equals(countryOfCredit), "Country of Credit was not selected!");
	}

	//Payment block
	protected void verifyPaymentBlock(String cardType, String country){
		
		softAssert.assertTrue(getSelectedCardType().equals(cardType), "Card Type is not correct! Current value is '" + getSelectedCardType() + 
				"', should be '" + cardType + "'");
		LOGGER.info("Card Type is correct");
		softAssert.assertTrue(getSelectedCountryOfCredit().equals(country), "Country of Credit is not correct! Current value is '" + getSelectedCountryOfCredit() + 
				"', should be '" + country + "'");
		LOGGER.info("Country of Credit is correct");
		softAssert.assertAll();
	}

	protected void verifyDefaultPaymentBlock(String country){
		
		softAssert.assertTrue(getSelectedCardType().equals(getDefaultCardTypeValue()), "Card Type is not correct! Current value is '" + getSelectedCardType() + 
				"', should be '" + getDefaultCardTypeValue() + "'");
		LOGGER.info("Card Type is correct");
		softAssert.assertTrue(getSelectedCountryOfCredit().equals(country), "Country of Residence is not correct! Current value is '" + getSelectedCountryOfCredit() + 
				"', should be '" + country + "'");
		LOGGER.info("Country of Credit is correct");
		softAssert.assertAll();
	}

	public AbstractBuyCreditProceedPage setPaymentBlockData(String paymentCardType, String countryOfCredit){
		
		selectPaymentCardType(paymentCardType);
		if (countryOfCredit != null){
			selectCountryOfCredit(countryOfCredit);
		}
		return this;
	}
	
	//Skrill Footer block
	public void verifySkrillFooterBlock(String nymgoCreditValue, String VAT, String totalAmountCharged){
		
		if (nymgoCreditValue != null){
			softAssert.assertTrue(getNymgoCreditValue().equals(nymgoCreditValue), "Nymgo Credit Value is not correct! Current value is '" + getNymgoCreditValue() + 
				"', should be '" + nymgoCreditValue + "'");
			LOGGER.info("Nymgo Credit Value is correct");
		}
		softAssert.assertTrue(getVATValue().equals(VAT), "VAT is not correct! Current value is '" + getVATValue() + 
				"', should be '" + VAT + "'");
		LOGGER.info("VAT is correct");
		softAssert.assertTrue(getTotalAmountChargedValue().equals(totalAmountCharged), "Total Amount Charged is not correct! Current value is '" + getTotalAmountChargedValue() + 
				"', should be '" + totalAmountCharged + "'");
		LOGGER.info("Total Amount Charged is correct");
		softAssert.assertAll();
	}

	public void verifyInternationalSkrillFooterBlock(String nymgoCreditValue, String totalAmountCharged){
		
		if (nymgoCreditValue != null){
			softAssert.assertTrue(getNymgoCreditValue().equals(nymgoCreditValue), "Nymgo Credit Value is not correct! Current value is '" + getNymgoCreditValue() + 
					"', should be '" + nymgoCreditValue + "'");
			LOGGER.info("Nymgo Credit Value is correct");
			softAssert.assertAll();
		}
	}
}
