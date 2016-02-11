package com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.adyen;

import org.testng.Assert;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.payments.adyen.BuyCredit3DSProceedPageAdyenFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.navigation.PageNavigation;
import com.nymgo.tests.pages.nymgo.menu.buyCredit.payments.base.AbstractBuyCredit3DSProceedPage;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCredit3DSProceedPageAdyen extends AbstractBuyCredit3DSProceedPage{
	
	private BuyCredit3DSProceedPageAdyenFragment buyCredit3DSProceedPageAdyenFragment;

	public BuyCredit3DSProceedPageAdyen(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCredit3DSProceedPageAdyenFragment = new BuyCredit3DSProceedPageAdyenFragment(driver);
	}

	private static final String BUY_CREDIT_PROCEED_PAGE_ADYEN_NAME_ENG = "BuyCreditProceedAdyenPage"; 
	
	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_PROCEED_PAGE_ADYEN_NAME_ENG;
	}

	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return buyCredit3DSProceedPageAdyenFragment.isCorrectURL();
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return buyCredit3DSProceedPageAdyenFragment.getCorrectURL();
	}


	private void setCardNumber(String cardNumberValue){
		
		buyCredit3DSProceedPageAdyenFragment.setCardNumber(cardNumberValue);
	}

	private String getCardNumber(){
		
		return buyCredit3DSProceedPageAdyenFragment.getCardNumber();
	}

	private void setCardholdersName(String cardholdersName){
		
		buyCredit3DSProceedPageAdyenFragment.setCardholdersName(cardholdersName);
	}
	
	private String getCardholdersName(){
		
		return buyCredit3DSProceedPageAdyenFragment.getCardholdersName();
	}

	private void selectExpireDateMonth(String expireDateMonth){
		
		buyCredit3DSProceedPageAdyenFragment.selectExpireDateMonthByValue(expireDateMonth);
	}

	private String getSelectedExpireDateMonth(){
		
		return buyCredit3DSProceedPageAdyenFragment.getSelectedExpireDateMonth();
	}

	private String getSelectedExpireDateMonthValue(){
		
		return buyCredit3DSProceedPageAdyenFragment.getSelectedExpireDateMonthValue();
	}

	private void selectExpireDateYear(String expireDateYear){
		
		buyCredit3DSProceedPageAdyenFragment.selectExpireDateYearByLCName(expireDateYear);
	}

	private String getSelectedExpireDateYear(){
		
		return buyCredit3DSProceedPageAdyenFragment.getSelectedExpireDateYear();
	}

	private void setCVV(String cvvValue){
		
		buyCredit3DSProceedPageAdyenFragment.setCVV(cvvValue);
	}
	
	private String getCVV(){
		
		return buyCredit3DSProceedPageAdyenFragment.getCVV();
	}
	
	public BuyCredit3DSProceedPageAdyen setCreditCardData(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		return this;
	}

	public BuyCredit3DSProceedPageAdyen verifyDefaultData(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
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

	public BuyCredit3DSProceedPageAdyen verifyDefaultData(){
		
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


	public PendingTransactionAdyenPage setCreditCardDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){	
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		PendingTransactionAdyenPage pendingTransactionAdyenPage = new PendingTransactionAdyenPage(starter);
		PageNavigation<PendingTransactionAdyenPage> navigation = new PageNavigation<PendingTransactionAdyenPage>(pendingTransactionAdyenPage);
		navigation.NavigatedTo();
		return pendingTransactionAdyenPage;
	}

	public PendingTransactionAdyenPage addNewCardSetCreditCardDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){	
		
		clickAddNewCard();
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		PageNavigation<BuyCredit3DSProceedPageAdyen> navigation = new PageNavigation<BuyCredit3DSProceedPageAdyen>(buyCredit3DSProceedPageAdyen);
		navigation.NavigatedTo();
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		PendingTransactionAdyenPage pendingTransactionAdyenPage = new PendingTransactionAdyenPage(starter);
		PageNavigation<PendingTransactionAdyenPage> navigationPending = new PageNavigation<PendingTransactionAdyenPage>(pendingTransactionAdyenPage);
		navigationPending.NavigatedTo();
		return pendingTransactionAdyenPage;
	}

	public DeclinedTransactionAdyenPage setCreditCardDataAndClickPayToDeclined(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){	
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		DeclinedTransactionAdyenPage declinedTransactionAdyenPage = new DeclinedTransactionAdyenPage(starter);
		PageNavigation<DeclinedTransactionAdyenPage> navigation = new PageNavigation<DeclinedTransactionAdyenPage>(declinedTransactionAdyenPage);
		navigation.NavigatedTo();
		return declinedTransactionAdyenPage;
	}

	public DeclinedTransactionAdyenPage verifyDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
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
		DeclinedTransactionAdyenPage declinedTransactionAdyenPage = new DeclinedTransactionAdyenPage(starter);
		PageNavigation<DeclinedTransactionAdyenPage> navigation = new PageNavigation<DeclinedTransactionAdyenPage>(declinedTransactionAdyenPage);
		navigation.NavigatedTo();
		return declinedTransactionAdyenPage;
	}

	public BuyCredit3DSConfirmPageAdyen setCreditCardDataAndClickPayToConfirm(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		BuyCredit3DSConfirmPageAdyen buyCredit3DSConfirmPageAdyen = new BuyCredit3DSConfirmPageAdyen(starter);
		PageNavigation<BuyCredit3DSConfirmPageAdyen> navigation = new PageNavigation<BuyCredit3DSConfirmPageAdyen>(buyCredit3DSConfirmPageAdyen);
		navigation.NavigatedTo();
		return buyCredit3DSConfirmPageAdyen;
	}

	public BuyCredit3DSConfirmPageAdyen addNewCreditCardSetCreditCardDataAndClickPayToConfirm(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		clickAddNewCard();
		BuyCredit3DSProceedPageAdyen buyCredit3DSProceedPageAdyen = new BuyCredit3DSProceedPageAdyen(starter);
		PageNavigation<BuyCredit3DSProceedPageAdyen> navigation = new PageNavigation<BuyCredit3DSProceedPageAdyen>(buyCredit3DSProceedPageAdyen);
		navigation.NavigatedTo();
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		BuyCredit3DSConfirmPageAdyen buyCredit3DSConfirmPageAdyen = new BuyCredit3DSConfirmPageAdyen(starter);
		PageNavigation<BuyCredit3DSConfirmPageAdyen> navigationConfirm = new PageNavigation<BuyCredit3DSConfirmPageAdyen>(buyCredit3DSConfirmPageAdyen);
		navigationConfirm.NavigatedTo();
		return buyCredit3DSConfirmPageAdyen;
	}

	public BuyCredit3DSConfirmPageAdyen verifyDataAndClickPayToConfirm(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
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
		BuyCredit3DSConfirmPageAdyen buyCredit3DSConfirmPageAdyen = new BuyCredit3DSConfirmPageAdyen(starter);
		PageNavigation<BuyCredit3DSConfirmPageAdyen> navigation = new PageNavigation<BuyCredit3DSConfirmPageAdyen>(buyCredit3DSConfirmPageAdyen);
		navigation.NavigatedTo();
		return buyCredit3DSConfirmPageAdyen;
	}

}
