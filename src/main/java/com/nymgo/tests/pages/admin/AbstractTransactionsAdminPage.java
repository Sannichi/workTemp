package com.nymgo.tests.pages.admin;

import java.util.Map;

import org.testng.asserts.SoftAssert;

import com.nymgo.tests.enums.CURRENCY_SIGNS;
import com.nymgo.tests.enums.GATEWAY_CONST;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.METHODS_CONST;
import com.nymgo.tests.fragments.admin.BaseTransactionsAdminPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.pages.admin.base.AbstractLoggedAdminPageWithSearch;
import com.nymgo.tests.starter.Starter;
import com.nymgo.tests.utils.CurrencyUtils;
import com.nymgo.tests.utils.DealDescriptionMap;
import com.nymgo.tests.utils.DealUtils;
import com.nymgo.tests.utils.Rounder;

public abstract class AbstractTransactionsAdminPage extends AbstractLoggedAdminPageWithSearch{

	BaseTransactionsAdminPageFragment transactionsAdminPageFragment;
	
	public AbstractTransactionsAdminPage(Starter starter) {

    	super(starter);
    	transactionsAdminPageFragment = new BaseTransactionsAdminPageFragment(driver);
    }

	private Map<String, String> getTransactionDetailsByID(String transactionID){
	
		return transactionsAdminPageFragment.getTransactionDetailsById(transactionID);
	}
	
	private boolean isTransactionUsernameCorrect(Map<String, String> transactionDetails, String username){

		return transactionsAdminPageFragment.isTransactionUsernameCorrect(transactionDetails, username);
	}

	private boolean isTransactionAmountCorrect(Map<String, String> transactionDetails, String amount){

		return transactionsAdminPageFragment.isTransactionAmountCorrect(transactionDetails, amount);
	}

	private boolean isTransactionCurrencyCorrect(Map<String, String> transactionDetails, String currency){

		return transactionsAdminPageFragment.isTransactionCurrencyCorrect(transactionDetails, currency);
	}

	private boolean isTransactionProductCorrect(Map<String, String> transactionDetails, String product){

		return transactionsAdminPageFragment.isTransactionProductCorrect(transactionDetails, product);
	}

	private boolean isTransactionServiceCorrect(Map<String, String> transactionDetails, String service){

		return transactionsAdminPageFragment.isTransactionServiceCorrect(transactionDetails, service);
	}

	private boolean isTransactionMethodCorrect(Map<String, String> transactionDetails, String method){

		return transactionsAdminPageFragment.isTransactionMethodCorrect(transactionDetails, method);
	}
	
	private boolean isTransactionCountryCorrect(Map<String, String> transactionDetails, String country){

		return transactionsAdminPageFragment.isTransactionCountryCorrect(transactionDetails, country);
	}
	
	private String getTransactionUsername(Map<String, String> transactionDetails){

		return transactionsAdminPageFragment.getTransactionUsername(transactionDetails);
	}

	private String getTransactionAmount(Map<String, String> transactionDetails){

		return transactionsAdminPageFragment.getTransactionAmount(transactionDetails);
	}

	private String getTransactionCurrency(Map<String, String> transactionDetails){

		return transactionsAdminPageFragment.getTransactionCurrency(transactionDetails);
	}

	private String getTransactionProduct(Map<String, String> transactionDetails){

		return transactionsAdminPageFragment.getTransactionProduct(transactionDetails);
	}

	private String getTransactionService(Map<String, String> transactionDetails){

		return transactionsAdminPageFragment.getTransactionService(transactionDetails);
	}

	private String getTransactionMethod(Map<String, String> transactionDetails){

		return transactionsAdminPageFragment.getTransactionMethod(transactionDetails);
	}
	
	private String getTransactionCountry(Map<String, String> transactionDetails){

		return transactionsAdminPageFragment.getTransactionCountry(transactionDetails);
	}
	
	public void verifyTransactionData(String transactionID, String username, String amount, String VAT, String currency, String service, String cardType, String country, String dealName, String dealCurrency){

		/*
		 * if amount == null - minimum value for current currency is got
		 * 
		 */
		String conversionRate = CurrencyUtils.getConversionRateByCurrencyName(currency);
		LOGGER.info("Conversion rate is '" + conversionRate + "'");
		Map<String, String> transactionDetails = getTransactionDetailsByID(transactionID);

		String currencyAmount = CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(amount)*Float.valueOf(VAT)/100 + Float.valueOf(amount));
		String conversionAmount = String.valueOf(Rounder.roundFloat((Float.valueOf(amount)*Float.valueOf(VAT)/100 + Float.valueOf(amount))/Float.valueOf(conversionRate), 2));
		String[] splitted = conversionAmount.split("\\.");
		conversionAmount = splitted[1].equals("0") ? splitted[0] : conversionAmount; 
		
		String fullAmount = "";
		String fullProduct = "";

		fullAmount = currencyAmount + currency + "|" +
				 conversionAmount +"$";
		if (dealName == null) {
			fullProduct = currency + " " + amount;
			if(currency.equals(CURRENCY_SIGNS.USD.toString())){
				if (getCurrentURL().equals(new NormalTransactionsAdminPage(starter).getPageURL())){
					fullProduct = "$" + amount;
				}
				else if(getCurrentURL().equals(new BusinessTransactionsAdminPage(starter).getPageURL())){
					fullProduct = "$" + " " + amount;
				}
			}
		}
		else {
			fullProduct = DealUtils.getFullDealName(dealName, dealCurrency);
		}
		
		String method = cardType;
		if(service.equals(GATEWAY_CONST.WORLDPAY.toString())){
			if(cardType.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.AMERICAN_EXPRESS))){
				method = METHODS_CONST.AMEX_SSL.toString();
			}
			else if(cardType.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.MASTER_CARD))){
				method = METHODS_CONST.MASTERCARD_SSL.toString();
			}
			else if(cardType.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.VISA)) || cardType.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.VISA_WP))){
				method = METHODS_CONST.VISA_SSL.toString();
			}
		}else if(service.equals(GATEWAY_CONST.ADYEN.toString())){
			if(cardType.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.MASTER_CARD))){
				method = METHODS_CONST.MASTERCARD.toString();
			}
			else if(cardType.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.AMERICAN_EXPRESS))){
				method = METHODS_CONST.AMEX.toString();
			}
			else if(cardType.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.VISA))){
				method = METHODS_CONST.VISA.toString();
			}
		}
				
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isTransactionUsernameCorrect(transactionDetails, username.toLowerCase()), "Username is not correct! Current value is '" + getTransactionUsername(transactionDetails) + 
				"', should be '" + username.toLowerCase() + "'");
		LOGGER.info("Username is correct");
		softAssert.assertTrue(isTransactionAmountCorrect(transactionDetails, fullAmount), "Amount is not correct! Current value is '" + getTransactionAmount(transactionDetails) + 
				"', should be '" + fullAmount + "'");
		LOGGER.info("Amount is correct");
		softAssert.assertTrue(isTransactionCurrencyCorrect(transactionDetails, currency), "Currency is not correct! Current value is '" + getTransactionCurrency(transactionDetails) + 
				"', should be '" + currency + "'");
		LOGGER.info("Currency is correct");
		softAssert.assertTrue(isTransactionProductCorrect(transactionDetails, fullProduct), "Product is not correct! Current value is '" + getTransactionProduct(transactionDetails) + 
				"', should be '" + fullProduct + "'");
		LOGGER.info("Product is correct");
		softAssert.assertTrue(isTransactionServiceCorrect(transactionDetails, service), "Service is not correct! Current value is '" + getTransactionService(transactionDetails) + 
				"', should be '" + service + "'");
		LOGGER.info("Service is correct");
		softAssert.assertTrue(isTransactionMethodCorrect(transactionDetails, method), "Method is not correct! Current value is '" + getTransactionMethod(transactionDetails) + 
				"', should be '" + method + "'");
		LOGGER.info("Methos is correct");
		softAssert.assertTrue(isTransactionCountryCorrect(transactionDetails, country), "Country is not correct! Current value is '" + getTransactionCountry(transactionDetails) + 
				"', should be '" + country + "'");
		LOGGER.info("Country is correct");
		softAssert.assertAll();
	}

	public void verifyDealData(String transactionID, String username, String amount, String VAT, String currency, String dealCurrency, String dealName, String service, String cardType, String country){

		/*
		 * if amount == null - minimum value for current currency is got
		 * 
		 */
		if(dealName == null){
			dealName = DealDescriptionMap.getFirstDealLocaleNameByCurrencySign(currency);
		}
		
		String conversionRate = CurrencyUtils.getConversionRateByCurrencyName(currency);
		LOGGER.info("Conversion rate is '" + conversionRate + "'");
		Map<String, String> transactionDetails = getTransactionDetailsByID(transactionID);

		String currencyAmount = CurrencyUtils.getStringCurrencyValueFromFloat(Float.valueOf(amount)*Float.valueOf(VAT)/100 + Float.valueOf(amount));
		String conversionAmount = String.valueOf(Rounder.roundFloat((Float.valueOf(amount)*Float.valueOf(VAT)/100 + Float.valueOf(amount))/Float.valueOf(conversionRate), 2));
		String[] splitted = conversionAmount.split("\\.");
		conversionAmount = splitted[1].equals("0") ? splitted[0] : conversionAmount; 
		String fullAmount = currencyAmount + currency + "/" +
			 conversionAmount +"$";
		
		String fullProduct = dealName;
		String method = cardType;

		if(service.equals(GATEWAY_CONST.WORLDPAY.toString())){
			if(cardType.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.AMERICAN_EXPRESS))){
				method = METHODS_CONST.AMEX_SSL.toString();
			}
			else if(cardType.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.MASTER_CARD))){
				method = METHODS_CONST.MASTERCARD_SSL.toString();
			}
			else if(cardType.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.VISA)) || cardType.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.VISA_WP))){
				method = METHODS_CONST.VISA_SSL.toString();
			}
		}else if(service.equals(GATEWAY_CONST.ADYEN.toString())){
			if(cardType.equals(LocaleGenerator.getLocaleKey(LOCALE_CONST.MASTER_CARD))){
				method = METHODS_CONST.MASTERCARD.toString();
			}
		}
				
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isTransactionUsernameCorrect(transactionDetails, username.toLowerCase()), "Username is not correct! Current value is '" + getTransactionUsername(transactionDetails) + 
				"', should be '" + username.toLowerCase() + "'");
		LOGGER.info("Username is correct");
		softAssert.assertTrue(isTransactionAmountCorrect(transactionDetails, fullAmount), "Amount is not correct! Current value is '" + getTransactionAmount(transactionDetails) + 
				"', should be '" + fullAmount + "'");
		LOGGER.info("Amount is correct");
		softAssert.assertTrue(isTransactionCurrencyCorrect(transactionDetails, currency), "Currency is not correct! Current value is '" + getTransactionCurrency(transactionDetails) + 
				"', should be '" + currency + "'");
		LOGGER.info("Currency is correct");
		softAssert.assertTrue(isTransactionProductCorrect(transactionDetails, fullProduct), "Product is not correct! Current value is '" + getTransactionProduct(transactionDetails) + 
				"', should be '" + fullProduct + "'");
		LOGGER.info("Product is correct");
		softAssert.assertTrue(isTransactionServiceCorrect(transactionDetails, service), "Service is not correct! Current value is '" + getTransactionService(transactionDetails) + 
				"', should be '" + service + "'");
		LOGGER.info("Service is correct");
		softAssert.assertTrue(isTransactionMethodCorrect(transactionDetails, method), "Method is not correct! Current value is '" + getTransactionMethod(transactionDetails) + 
				"', should be '" + method + "'");
		LOGGER.info("Methos is correct");
		softAssert.assertTrue(isTransactionCountryCorrect(transactionDetails, country), "Country is not correct! Current value is '" + getTransactionCountry(transactionDetails) + 
				"', should be '" + country + "'");
		LOGGER.info("Country is correct");
		softAssert.assertAll();
	}
}
