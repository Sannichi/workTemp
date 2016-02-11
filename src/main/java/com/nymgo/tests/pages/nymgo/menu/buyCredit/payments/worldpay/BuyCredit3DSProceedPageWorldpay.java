package com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay;

import org.testng.Assert;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.worldpay.BuyCredit3DSProceedPageWorldpayFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.base.AbstractBuyCredit3DSProceedPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCredit3DSProceedPageWorldpay extends AbstractBuyCredit3DSProceedPage{

	private BuyCredit3DSProceedPageWorldpayFragment buyCredit3DSProceedPageWorldpayFragment;
	
	public BuyCredit3DSProceedPageWorldpay(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCredit3DSProceedPageWorldpayFragment = new BuyCredit3DSProceedPageWorldpayFragment(driver);
	}
/*
	private static final String BUY_CREDIT_PROCEED_PAGE_WP_NAME_ENG = "BuyCreditProceedWorldpayPage"; 
			
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_PROCEED_PAGE_WP_NAME_ENG;
	}

	public BuyCreditConfirmPageWorldpay verifyDataAndClickContinue(String cardType, String countryOfCredit,
			String nymgoCreditValue, String VAT, String totalAmountCharged){
		
		verifyPaymentBlock(cardType, countryOfCredit);
		verifySkrillFooterBlock(nymgoCreditValue, VAT, totalAmountCharged);
		clickContinueButton();
		BuyCreditConfirmPageWorldpay buyCreditConfirmPageWorldpay = new BuyCreditConfirmPageWorldpay(starter);
		PageNavigation<BuyCreditConfirmPageWorldpay> navigation = new PageNavigation<BuyCreditConfirmPageWorldpay>(buyCreditConfirmPageWorldpay);
		navigation.NavigatedTo();
		return buyCreditConfirmPageWorldpay;
	} 

	public void verifyDefaultData(String countryOfResidence, String nymgoCreditValue, String VAT, String totalAmountCharged){
		verifyDefaultPaymentBlock(countryOfResidence);
		verifySkrillFooterBlock(nymgoCreditValue, VAT, totalAmountCharged);
	}
*/
	private static final String BUY_CREDIT_PROCEED_PAGE_WP_NAME_ENG = "BuyCreditProceedWorldpayPage"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_PROCEED_PAGE_WP_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return buyCredit3DSProceedPageWorldpayFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return buyCredit3DSProceedPageWorldpayFragment.getCorrectURL();
	}


	private void setCardNumber(String cardNumberValue){
		
		buyCredit3DSProceedPageWorldpayFragment.setCardNumber(cardNumberValue);
	}

	private String getCardNumber(){
		
		return buyCredit3DSProceedPageWorldpayFragment.getCardNumber();
	}

	private void setCardholdersName(String cardholdersName){
		
		buyCredit3DSProceedPageWorldpayFragment.setCardholdersName(cardholdersName);
	}
	
	private String getCardholdersName(){
		
		return buyCredit3DSProceedPageWorldpayFragment.getCardholdersName();
	}

	private void selectExpireDateMonth(String expireDateMonth){
		
		buyCredit3DSProceedPageWorldpayFragment.selectExpireDateMonthByValue(expireDateMonth);
	}

	private String getSelectedExpireDateMonth(){
		
		return buyCredit3DSProceedPageWorldpayFragment.getSelectedExpireDateMonth();
	}

	private String getSelectedExpireDateMonthValue(){
		
		return buyCredit3DSProceedPageWorldpayFragment.getSelectedExpireDateMonthValue();
	}

	private void selectExpireDateYear(String expireDateYear){
		
		buyCredit3DSProceedPageWorldpayFragment.selectExpireDateYearByLCName(expireDateYear);
	}

	private String getSelectedExpireDateYear(){
		
		return buyCredit3DSProceedPageWorldpayFragment.getSelectedExpireDateYear();
	}

	private void setCVV(String cvvValue){
		
		buyCredit3DSProceedPageWorldpayFragment.setCVV(cvvValue);
	}
	
	private String getCVV(){
		
		return buyCredit3DSProceedPageWorldpayFragment.getCVV();
	}
	
	//TODO instead of void
	public BuyCredit3DSProceedPageWorldpay setCreditCardData(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		return this;
	}

	public BuyCredit3DSProceedPageWorldpay verifyDefaultData(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
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

	public BuyCredit3DSProceedPageWorldpay verifyDefaultData(){
		
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

	public BuyCredit3DSConfirmPageWorldpay set3DSCreditCardDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		BuyCredit3DSConfirmPageWorldpay buyCredit3DSConfirmPageWorldpay  = new BuyCredit3DSConfirmPageWorldpay(starter);
		PageNavigation<BuyCredit3DSConfirmPageWorldpay> navigation = new PageNavigation<BuyCredit3DSConfirmPageWorldpay>(buyCredit3DSConfirmPageWorldpay);
		navigation.NavigatedTo();
		return buyCredit3DSConfirmPageWorldpay;
	}

	public BuyCredit3DSConfirmPageWorldpay addNewCardSet3DSCreditCardDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		clickAddNewCard();
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		PageNavigation<BuyCredit3DSProceedPageWorldpay> navigation = new PageNavigation<BuyCredit3DSProceedPageWorldpay>(buyCredit3DSProceedPageWorldpay);
		navigation.NavigatedTo();
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		BuyCredit3DSConfirmPageWorldpay buyCredit3DSConfirmPageWorldpay  = new BuyCredit3DSConfirmPageWorldpay(starter);
		PageNavigation<BuyCredit3DSConfirmPageWorldpay> navigationConfirm = new PageNavigation<BuyCredit3DSConfirmPageWorldpay>(buyCredit3DSConfirmPageWorldpay);
		navigationConfirm.NavigatedTo();
		return buyCredit3DSConfirmPageWorldpay;
	}

	public PendingTransactionWorldpayPage set3DSAmexCreditCardDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage  = new PendingTransactionWorldpayPage(starter);
		PageNavigation<PendingTransactionWorldpayPage> navigation = new PageNavigation<PendingTransactionWorldpayPage>(pendingTransactionWorldpayPage);
		navigation.NavigatedTo();
		return pendingTransactionWorldpayPage;
	}

	public BuyCredit3DSConfirmPageWorldpay verify3DSDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
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
		BuyCredit3DSConfirmPageWorldpay buyCredit3DSConfirmPageWorldpay  = new BuyCredit3DSConfirmPageWorldpay(starter);
		PageNavigation<BuyCredit3DSConfirmPageWorldpay> navigation = new PageNavigation<BuyCredit3DSConfirmPageWorldpay>(buyCredit3DSConfirmPageWorldpay);
		navigation.NavigatedTo();
		return buyCredit3DSConfirmPageWorldpay;
	}

	public PendingTransactionWorldpayPage setCreditCardDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		clickAddNewCard();
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		PageNavigation<BuyCredit3DSProceedPageWorldpay> navigation = new PageNavigation<BuyCredit3DSProceedPageWorldpay>(buyCredit3DSProceedPageWorldpay);
		navigation.NavigatedTo();
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage  = new PendingTransactionWorldpayPage(starter);
		PageNavigation<PendingTransactionWorldpayPage> navigationPending = new PageNavigation<PendingTransactionWorldpayPage>(pendingTransactionWorldpayPage);
		navigationPending.NavigatedTo();
		return pendingTransactionWorldpayPage;
	}

	public PendingTransactionWorldpayPage addNewcardSetCreditCardDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage  = new PendingTransactionWorldpayPage(starter);
		PageNavigation<PendingTransactionWorldpayPage> navigation = new PageNavigation<PendingTransactionWorldpayPage>(pendingTransactionWorldpayPage);
		navigation.NavigatedTo();
		return pendingTransactionWorldpayPage;
	}

	public PendingTransactionWorldpayPage verifyDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
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
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage  = new PendingTransactionWorldpayPage(starter);
		PageNavigation<PendingTransactionWorldpayPage> navigation = new PageNavigation<PendingTransactionWorldpayPage>(pendingTransactionWorldpayPage);
		navigation.NavigatedTo();
		return pendingTransactionWorldpayPage;
	}

}
