package nymgoAutomation.tests.pages.admin;

import java.util.Map;

import org.testng.Assert;

import nymgoAutomation.tests.enums.CURRENCY_SIGNS;
import nymgoAutomation.tests.fragments.admin.TransactionsAdminPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.admin.base.AbstractLoggedAdminPageWithSearch;
import nymgoAutomation.tests.pages.admin.widgets.MemberPaymentHistoryWidget;

public class TransactionsAdminPage extends AbstractLoggedAdminPageWithSearch{

	TransactionsAdminPageFragment transactionsAdminPageFragment;
	
	public TransactionsAdminPage(Starter starter) {

    	super(starter);
    	transactionsAdminPageFragment = new TransactionsAdminPageFragment(driver);
    }

	private static final String TRANSACTIONS_PAGE_NAME_ENG = "AdminTransactionsPage"; 
	
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return transactionsAdminPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return TRANSACTIONS_PAGE_NAME_ENG;
	}
	
	public MemberPaymentHistoryWidget openViewTransactionsWidgedByID(String stringID){

		transactionsAdminPageFragment.clickViewTransactionsByID(stringID);
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = new MemberPaymentHistoryWidget(starter);
		PageNavigation<MemberPaymentHistoryWidget> navigation = new PageNavigation<MemberPaymentHistoryWidget>(memberPaymentHistoryWidget);
		navigation.NavigatedTo();
		return memberPaymentHistoryWidget;
	}

	public MemberPaymentHistoryWidget clickFirstViewTransactionsByUsername(String username){

		transactionsAdminPageFragment.clickFirstViewTransactionsByUsername(username);
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = new MemberPaymentHistoryWidget(starter);
		PageNavigation<MemberPaymentHistoryWidget> navigation = new PageNavigation<MemberPaymentHistoryWidget>(memberPaymentHistoryWidget);
		navigation.NavigatedTo();
		return memberPaymentHistoryWidget;
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
	
	public void verifyTransactionData(String transactionID, String username, String amount, String VAT, String conversionRate, String currency, String service, String method, String country){
		
		Map<String, String> transactionDetails = getTransactionDetailsByID(transactionID);
		
		String fullAmount = String.valueOf(Double.valueOf(amount)*Double.valueOf(VAT)/100 + Integer.valueOf(amount))+currency+"/"
		+(String.valueOf(String.valueOf((Double.valueOf(amount)*Double.valueOf(VAT)/100 + Integer.valueOf(amount))*Integer.valueOf(conversionRate))))+"$";
		
		String fullProduct = "";
		if(currency.equals(CURRENCY_SIGNS.USD.toString())){
			fullProduct = "$" + amount;
		}
		else{
			fullProduct = currency + " " + amount;
		}
				
		Assert.assertTrue(isTransactionUsernameCorrect(transactionDetails, username.toLowerCase()), "Username is not correct! Current value is '" + getTransactionUsername(transactionDetails) + 
				"', should be '" + username.toLowerCase() + "'");
		LOGGER.info("Username is correct");
		Assert.assertTrue(isTransactionAmountCorrect(transactionDetails, fullAmount), "Amount is not correct! Current value is '" + getTransactionAmount(transactionDetails) + 
				"', should be '" + fullAmount + "'");
		LOGGER.info("Amount is correct");
		Assert.assertTrue(isTransactionCurrencyCorrect(transactionDetails, currency), "Currency is not correct! Current value is '" + getTransactionCurrency(transactionDetails) + 
				"', should be '" + currency + "'");
		LOGGER.info("Currency is correct");
		Assert.assertTrue(isTransactionProductCorrect(transactionDetails, fullProduct), "Product is not correct! Current value is '" + getTransactionProduct(transactionDetails) + 
				"', should be '" + fullProduct + "'");
		LOGGER.info("Product is correct");
		Assert.assertTrue(isTransactionServiceCorrect(transactionDetails, service), "Service is not correct! Current value is '" + getTransactionService(transactionDetails) + 
				"', should be '" + service + "'");
		LOGGER.info("Service is correct");
		Assert.assertTrue(isTransactionMethodCorrect(transactionDetails, method), "Method is not correct! Current value is '" + getTransactionMethod(transactionDetails) + 
				"', should be '" + method + "'");
		LOGGER.info("Methos is correct");
		Assert.assertTrue(isTransactionCountryCorrect(transactionDetails, country), "Country is not correct! Current value is '" + getTransactionCountry(transactionDetails) + 
				"', should be '" + country + "'");
		LOGGER.info("Country is correct");
	}
}
