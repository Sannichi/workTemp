package com.nymgo.tests.pages.nymgo.menu.buyCredit.globalCollect;

import org.testng.Assert;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.globalCollect.BuyCredit3DSProceedPageGlobalCollectFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.base.AbstractBuyCredit3DSProceedPage;
import com.nymgo.tests.starter.Starter;
/**
 * Created by Iuliia Khikmatova on Feb 05, 2016
 */
public class BuyCredit3DSProceedPageGlobalCollect extends AbstractBuyCredit3DSProceedPage{

	private BuyCredit3DSProceedPageGlobalCollectFragment buyCredit3DSProceedPageGlobalCollectFragment;
	
	private static final String BUY_CREDIT_PROCEED_PAGE_GC_NAME_ENG = "BuyCreditProceedGlobalCollectPage"; 
			
	public BuyCredit3DSProceedPageGlobalCollect(Starter starter) {
        super(starter);
        buyCredit3DSProceedPageGlobalCollectFragment = new BuyCredit3DSProceedPageGlobalCollectFragment(driver);
    }
    
    @Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_PROCEED_PAGE_GC_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return buyCredit3DSProceedPageGlobalCollectFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return buyCredit3DSProceedPageGlobalCollectFragment.getCorrectURL();
	}
	private void setCardNumber(String cardNumberValue){
		
		buyCredit3DSProceedPageGlobalCollectFragment.setCardNumber(cardNumberValue);
	}

	private String getCardNumber(){
		
		return buyCredit3DSProceedPageGlobalCollectFragment.getCardNumber();
	}

	private void setCardholdersName(String cardholdersName){
		
		buyCredit3DSProceedPageGlobalCollectFragment.setCardholdersName(cardholdersName);
	}
	
	private String getCardholdersName(){
		
		return buyCredit3DSProceedPageGlobalCollectFragment.getCardholdersName();
	}

	private void selectExpireDateMonth(String expireDateMonth){
		
		buyCredit3DSProceedPageGlobalCollectFragment.selectExpireDateMonthByValue(expireDateMonth);
	}

	private String getSelectedExpireDateMonth(){
		
		return buyCredit3DSProceedPageGlobalCollectFragment.getSelectedExpireDateMonth();
	}

	private String getSelectedExpireDateMonthValue(){
		
		return buyCredit3DSProceedPageGlobalCollectFragment.getSelectedExpireDateMonthValue();
	}

	private void selectExpireDateYear(String expireDateYear){
		
		buyCredit3DSProceedPageGlobalCollectFragment.selectExpireDateYearByLCName(expireDateYear);
	}

	private String getSelectedExpireDateYear(){
		
		return buyCredit3DSProceedPageGlobalCollectFragment.getSelectedExpireDateYear();
	}

	private void setCVV(String cvvValue){
		
		buyCredit3DSProceedPageGlobalCollectFragment.setCVV(cvvValue);
	}
	
	private String getCVV(){
		
		return buyCredit3DSProceedPageGlobalCollectFragment.getCVV();
	}
	
	public BuyCredit3DSProceedPageGlobalCollect setCreditCardData(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		return this;
	}

	public BuyCredit3DSProceedPageGlobalCollect verifyDefaultData(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		Assert.assertTrue(getCardNumber().equals(cardNumberValue), "Card Number is not correct! Current value is '" + getCardNumber() + 
				"', should be '" + cardNumberValue + "'");
		LOGGER.info("Card Number is correct");
		Assert.assertTrue(getCardholdersName().equals(cardholdersName), "Cardholder's Name is not correct! Current value is '" + getCardholdersName() + 
				"', should be '" + cardholdersName + "'");
		LOGGER.info("Cardholder's Name is correct");
		Assert.assertTrue(getSelectedExpireDateMonthValue().equals(expireDateMonth), "Expire Date Month is not correct! Current value is '" + getSelectedExpireDateMonthValue() + 
				"', should be '" + expireDateMonth + "'");
		LOGGER.info("Expire Date Month is correct");
		Assert.assertTrue(getSelectedExpireDateYear().equals(expireDateYear), "Expire Date Year is not correct! Current value is '" + getSelectedExpireDateYear() + 
				"', should be '" + expireDateYear + "'");
		LOGGER.info("Expire Date Year is correct");
		Assert.assertTrue(getCVV().equals(cvvValue), "CVV is not correct! Current value is '" + getCVV() + 
				"', should be '" + cvvValue + "'");
		LOGGER.info("CVV is correct");
		return this;
	}

	public BuyCredit3DSProceedPageGlobalCollect verifyDefaultData(){
		
		Assert.assertTrue(getCardNumber().equals(""), "Card Number is not correct! Current value is '" + getCardNumber() + 
				"', should be empty");
		LOGGER.info("Card Number is correct");
		Assert.assertTrue(getCardholdersName().equals(""), "Cardholder's Name is not correct! Current value is '" + getCardholdersName() + 
				"', should be empty");
		LOGGER.info("Cardholder's Name is correct");
		String month = LocaleGenerator.getLocaleKey(LOCALE_CONST.MONTH);
		Assert.assertTrue(getSelectedExpireDateMonth().equals(month), "Expire Date Month is not correct! Current value is '" + getSelectedExpireDateMonth() + 
				"', should be '" + month + "'");
		LOGGER.info("Expire Date Month is correct");
		String year = LocaleGenerator.getLocaleKey(LOCALE_CONST.YEAR);
		Assert.assertTrue(getSelectedExpireDateYear().equals(year), "Expire Date Year is not correct! Current value is '" + getSelectedExpireDateYear() + 
				"', should be '" + year + "'");
		LOGGER.info("Expire Date Year is correct");
		Assert.assertTrue(getCVV().equals(""), "CVV is not correct! Current value is '" + getCVV() + 
				"', should be empty");
		LOGGER.info("CVV is correct");
		return this;
	}

	public PendingTransactionGlobalCollectPage setCreditCardDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){	
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		PendingTransactionGlobalCollectPage pendingTransactionGlobalCollectPage = new PendingTransactionGlobalCollectPage(starter);
		PageNavigation<PendingTransactionGlobalCollectPage> navigation = new PageNavigation<PendingTransactionGlobalCollectPage>(pendingTransactionGlobalCollectPage);
		navigation.NavigatedTo();
		return pendingTransactionGlobalCollectPage;
	}

	public BuyCreditConfirmPageGlobalCollect setCreditCardDataAndClickPayToConfirm(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);
		PageNavigation<BuyCreditConfirmPageGlobalCollect> navigation = new PageNavigation<BuyCreditConfirmPageGlobalCollect>(buyCreditConfirmPageGlobalCollect);
		navigation.NavigatedTo();
		return buyCreditConfirmPageGlobalCollect;
	}

	public BuyCreditConfirmPageGlobalCollect verifyDataAndClickPayToConfirm(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		Assert.assertTrue(getCardNumber().equals(cardNumberValue), "Card Number is not correct! Current value is '" + getCardNumber() + 
				"', should be '" + cardNumberValue + "'");
		LOGGER.info("Card Number is correct");
		Assert.assertTrue(getCardholdersName().equals(cardholdersName), "Cardholder's Name is not correct! Current value is '" + getCardholdersName() + 
				"', should be '" + cardholdersName + "'");
		LOGGER.info("Cardholder's Name is correct");
		Assert.assertTrue(getSelectedExpireDateMonthValue().equals(expireDateMonth), "Expire Date Month is not correct! Current value is '" + getSelectedExpireDateMonthValue() + 
				"', should be '" + expireDateMonth + "'");
		LOGGER.info("Expire Date Month is correct");
		Assert.assertTrue(getSelectedExpireDateYear().equals(expireDateYear), "Expire Date Year is not correct! Current value is '" + getSelectedExpireDateYear() + 
				"', should be '" + expireDateYear + "'");
		LOGGER.info("Expire Date Year is correct");
		clickPayButton();
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);
		PageNavigation<BuyCreditConfirmPageGlobalCollect> navigation = new PageNavigation<BuyCreditConfirmPageGlobalCollect>(buyCreditConfirmPageGlobalCollect);
		navigation.NavigatedTo();
		return buyCreditConfirmPageGlobalCollect;
	}

}
