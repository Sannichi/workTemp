package com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.worldpay;

import org.testng.asserts.SoftAssert;

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
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(getCardNumber().equals(cardNumberValue), "Card Number is not correct! Current value is '" + getCardNumber() + 
				"', should be '" + cardNumberValue + "'");
		LOGGER.info("Card Number is correct");
		softAssert.assertTrue(getCardholdersName().equals(cardholdersName), "Cardholder's Name is not correct! Current value is '" + getCardholdersName() + 
				"', should be '" + cardholdersName + "'");
		LOGGER.info("Cardholder's Name is correct");
		softAssert.assertTrue(getSelectedExpireDateMonthValue().equals(expireDateMonth), "Expire Date Month is not correct! Current value is '" + getSelectedExpireDateMonthValue() + 
				"', should be '" + expireDateMonth + "'");
		LOGGER.info("Expire Date Month is correct");
		softAssert.assertTrue(getSelectedExpireDateYear().equals(expireDateYear), "Expire Date Year is not correct! Current value is '" + getSelectedExpireDateYear() + 
				"', should be '" + expireDateYear + "'");
		LOGGER.info("Expire Date Year is correct");
		softAssert.assertTrue(getCVV().equals(cvvValue), "CVV is not correct! Current value is '" + getCVV() + 
				"', should be '" + cvvValue + "'");
		LOGGER.info("CVV is correct");
		softAssert.assertAll();
		return this;
	}

	public BuyCredit3DSProceedPageWorldpay verifyDefaultData(){
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(getCardNumber().equals(""), "Card Number is not correct! Current value is '" + getCardNumber() + 
				"', should be empty");
		LOGGER.info("Card Number is correct");
		softAssert.assertTrue(getCardholdersName().equals(""), "Cardholder's Name is not correct! Current value is '" + getCardholdersName() + 
				"', should be empty");
		LOGGER.info("Cardholder's Name is correct");
		String month = LocaleGenerator.getLocaleKey(LOCALE_CONST.MONTH);
		softAssert.assertTrue(getSelectedExpireDateMonth().equals(month), "Expire Date Month is not correct! Current value is '" + getSelectedExpireDateMonth() + 
				"', should be '" + month + "'");
		LOGGER.info("Expire Date Month is correct");
		String year = LocaleGenerator.getLocaleKey(LOCALE_CONST.YEAR);
		softAssert.assertTrue(getSelectedExpireDateYear().equals(year), "Expire Date Year is not correct! Current value is '" + getSelectedExpireDateYear() + 
				"', should be '" + year + "'");
		LOGGER.info("Expire Date Year is correct");
		softAssert.assertTrue(getCVV().equals(""), "CVV is not correct! Current value is '" + getCVV() + 
				"', should be empty");
		LOGGER.info("CVV is correct");
		softAssert.assertAll();
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

	public BuyCredit3DSConfirmPageWorldpay verify3DSDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(getCardNumber().equals(cardNumberValue), "Card Number is not correct! Current value is '" + getCardNumber() + 
				"', should be '" + cardNumberValue + "'");
		LOGGER.info("Card Number is correct");
		softAssert.assertTrue(getCardholdersName().equals(cardholdersName), "Cardholder's Name is not correct! Current value is '" + getCardholdersName() + 
				"', should be '" + cardholdersName + "'");
		LOGGER.info("Cardholder's Name is correct");
		softAssert.assertTrue(getSelectedExpireDateMonthValue().equals(expireDateMonth), "Expire Date Month is not correct! Current value is '" + getSelectedExpireDateMonthValue() + 
				"', should be '" + expireDateMonth + "'");
		LOGGER.info("Expire Date Month is correct");
		softAssert.assertTrue(getSelectedExpireDateYear().equals(expireDateYear), "Expire Date Year is not correct! Current value is '" + getSelectedExpireDateYear() + 
				"', should be '" + expireDateYear + "'");
		LOGGER.info("Expire Date Year is correct");
		softAssert.assertAll();
		clickPayButton();
		BuyCredit3DSConfirmPageWorldpay buyCredit3DSConfirmPageWorldpay  = new BuyCredit3DSConfirmPageWorldpay(starter);
		PageNavigation<BuyCredit3DSConfirmPageWorldpay> navigation = new PageNavigation<BuyCredit3DSConfirmPageWorldpay>(buyCredit3DSConfirmPageWorldpay);
		navigation.NavigatedTo();
		return buyCredit3DSConfirmPageWorldpay;
	}

	public PendingTransactionWorldpayPage setCreditCardDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
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

	public PendingTransactionWorldpayPage selectSavedCreditCardAndClickPay(){
		
		clickSavedCardLabel();
		clickPayButton();
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage  = new PendingTransactionWorldpayPage(starter);
		PageNavigation<PendingTransactionWorldpayPage> navigation = new PageNavigation<PendingTransactionWorldpayPage>(pendingTransactionWorldpayPage);
		navigation.NavigatedTo();
		return pendingTransactionWorldpayPage;
	}
		
	/*
	 * new credit card will be set recurrent
	 */
	public PendingTransactionWorldpayPage addNewCreditCardSetCreditCardDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		clickAddNewCard();
		BuyCredit3DSProceedPageWorldpay buyCredit3DSProceedPageWorldpay = new BuyCredit3DSProceedPageWorldpay(starter);
		PageNavigation<BuyCredit3DSProceedPageWorldpay> navigation = new PageNavigation<BuyCredit3DSProceedPageWorldpay>(buyCredit3DSProceedPageWorldpay);
		navigation.NavigatedTo();
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
//		setSaveCardCheckbox();
		checkSaveCardLabel();
		clickPayButton();
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage  = new PendingTransactionWorldpayPage(starter);
		PageNavigation<PendingTransactionWorldpayPage> navigationPending = new PageNavigation<PendingTransactionWorldpayPage>(pendingTransactionWorldpayPage);
		navigationPending.NavigatedTo();
		return pendingTransactionWorldpayPage;
	}

	public PendingTransactionWorldpayPage verifyDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(getCardNumber().equals(cardNumberValue), "Card Number is not correct! Current value is '" + getCardNumber() + 
				"', should be '" + cardNumberValue + "'");
		LOGGER.info("Card Number is correct");
		softAssert.assertTrue(getCardholdersName().equals(cardholdersName), "Cardholder's Name is not correct! Current value is '" + getCardholdersName() + 
				"', should be '" + cardholdersName + "'");
		LOGGER.info("Cardholder's Name is correct");
		softAssert.assertTrue(getSelectedExpireDateMonthValue().equals(expireDateMonth), "Expire Date Month is not correct! Current value is '" + getSelectedExpireDateMonthValue() + 
				"', should be '" + expireDateMonth + "'");
		LOGGER.info("Expire Date Month is correct");
		softAssert.assertTrue(getSelectedExpireDateYear().equals(expireDateYear), "Expire Date Year is not correct! Current value is '" + getSelectedExpireDateYear() + 
				"', should be '" + expireDateYear + "'");
		LOGGER.info("Expire Date Year is correct");
		softAssert.assertAll();
		clickPayButton();
		PendingTransactionWorldpayPage pendingTransactionWorldpayPage  = new PendingTransactionWorldpayPage(starter);
		PageNavigation<PendingTransactionWorldpayPage> navigation = new PageNavigation<PendingTransactionWorldpayPage>(pendingTransactionWorldpayPage);
		navigation.NavigatedTo();
		return pendingTransactionWorldpayPage;
	}

}
