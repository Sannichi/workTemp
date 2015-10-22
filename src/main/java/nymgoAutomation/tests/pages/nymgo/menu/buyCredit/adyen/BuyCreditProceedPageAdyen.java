package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.adyen;

import org.testng.Assert;

import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.adyen.BuyCreditProceedPageAdyenFragment;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.base.AbstractLoggedInPage;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.BuyCreditConfirmPageCancelled;
import nymgoAutomation.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 20, 2015
 */
public class BuyCreditProceedPageAdyen extends AbstractLoggedInPage{
	
	private BuyCreditProceedPageAdyenFragment buyCreditProceedPageAdyenFragment;

	public BuyCreditProceedPageAdyen(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		buyCreditProceedPageAdyenFragment = new BuyCreditProceedPageAdyenFragment(driver);
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
		return buyCreditProceedPageAdyenFragment.isCorrectURL();
	}

	private void setCardNumber(String cardNumberValue){
		
		buyCreditProceedPageAdyenFragment.setCardNumber(cardNumberValue);
	}

	private String getCardNumber(){
		
		return buyCreditProceedPageAdyenFragment.getCardNumber();
	}

	private void setCardholdersName(String cardholdersName){
		
		buyCreditProceedPageAdyenFragment.setCardholdersName(cardholdersName);
	}
	
	private String getCardholdersName(){
		
		return buyCreditProceedPageAdyenFragment.getCardholdersName();
	}

	private void selectExpireDateMonth(String expireDateMonth){
		
		buyCreditProceedPageAdyenFragment.selectExpireDateMonthByValue(expireDateMonth);
	}

	private String getSelectedExpireDateMonth(){
		
		return buyCreditProceedPageAdyenFragment.getSelectedExpireDateMonth();
	}

	private String getSelectedExpireDateMonthValue(){
		
		return buyCreditProceedPageAdyenFragment.getSelectedExpireDateMonthValue();
	}

	private void selectExpireDateYear(String expireDateYear){
		
		buyCreditProceedPageAdyenFragment.selectExpireDateYearByLCName(expireDateYear);
	}

	private String getSelectedExpireDateYear(){
		
		return buyCreditProceedPageAdyenFragment.getSelectedExpireDateYear();
	}

	private void setCVV(String cvvValue){
		
		buyCreditProceedPageAdyenFragment.setCVV(cvvValue);
	}
	
	private String getCVV(){
		
		return buyCreditProceedPageAdyenFragment.getCVV();
	}

	private void clickPayButton(){
		
		buyCreditProceedPageAdyenFragment.clickPayButton();
	}
	
	private void clickCancelButton(){
		
		buyCreditProceedPageAdyenFragment.clickCancelButton();
	}
	
	//TODO instead of void
	public BuyCreditProceedPageAdyen setCreditCardData(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		return this;
	}

	public BuyCreditConfirmPageDeclinedAdyen setCreditCardDataAndClickPay(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		setCardholdersName(cardholdersName);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickPayButton();
		BuyCreditConfirmPageDeclinedAdyen buyCreditConfirmPageDeclinedAdyen = new BuyCreditConfirmPageDeclinedAdyen(starter);
		PageNavigation<BuyCreditConfirmPageDeclinedAdyen> navigation = new PageNavigation<BuyCreditConfirmPageDeclinedAdyen>(buyCreditConfirmPageDeclinedAdyen);
		navigation.NavigatedTo();
		return buyCreditConfirmPageDeclinedAdyen;
	}

	public BuyCreditProceedPageAdyen verifyDefaultData(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
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

	public BuyCreditProceedPageAdyen verifyDefaultData(){
		
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

	public BuyCreditConfirmPageDeclinedAdyen verifyDataAndClickContinue(String cardNumberValue, String cardholdersName, String expireDateMonth, String expireDateYear, String cvvValue){
		
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
		BuyCreditConfirmPageDeclinedAdyen buyCreditConfirmPageDeclinedAdyen = new BuyCreditConfirmPageDeclinedAdyen(starter);
		PageNavigation<BuyCreditConfirmPageDeclinedAdyen> navigation = new PageNavigation<BuyCreditConfirmPageDeclinedAdyen>(buyCreditConfirmPageDeclinedAdyen);
		navigation.NavigatedTo();
		return buyCreditConfirmPageDeclinedAdyen;
	}

	public BuyCreditConfirmPageCancelled setCreditCardDataAndClickCancel(String cardNumberValue, String expireDateMonth, String expireDateYear, String cvvValue){
		
		setCardNumber(cardNumberValue);
		selectExpireDateMonth(expireDateMonth);
		selectExpireDateYear(expireDateYear);
		setCVV(cvvValue);
		clickCancelButton();
		BuyCreditConfirmPageCancelled buyCreditConfirmPageCancelled = new BuyCreditConfirmPageCancelled(starter);
		PageNavigation<BuyCreditConfirmPageCancelled> navigation = new PageNavigation<BuyCreditConfirmPageCancelled>(buyCreditConfirmPageCancelled);
		navigation.NavigatedTo();
		return buyCreditConfirmPageCancelled;
	}
}
