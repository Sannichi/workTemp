package com.nymgo.tests.fragments.admin;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.TRANSACTIONS_TABLE_COLUMNS;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.admin.base.BaseLoggedAdminPageWithSearchFragment;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

public class BaseTransactionsAdminPageFragment extends BaseLoggedAdminPageWithSearchFragment{

	public BaseTransactionsAdminPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String TRANSACTIONS_PAGE_URL_ENG = ServerGenerator.getServerKey(URL_CONST.ADMIN_URL) + "/modules/transactions/index.php"; 
			
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.urlMatches(TRANSACTIONS_PAGE_URL_ENG));
			return true;
		}
    	catch(TimeoutException e){
    		return false;
    	}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return TRANSACTIONS_PAGE_URL_ENG;
	}

	public void clickViewTransactionsByID(String stringID){

		int rowIndex = isValueDisplays(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), stringID); 
		if (rowIndex != -1){
			WebElement rowToClick = getResultsList().get(rowIndex);
			WebElement viewWidget = rowToClick.findElement(By.xpath(".//img[@class='widjet']"));			
			clickWidget(viewWidget);
		}
	}

	public void clickFirstViewTransactionsByUsername(String username){

		int rowIndex = isValueDisplays(TRANSACTIONS_TABLE_COLUMNS.USERNAME.toString(), username); 
		if (rowIndex != -1){
			WebElement rowToClick = getResultsList().get(rowIndex);
			WebElement viewWidget = rowToClick.findElement(By.xpath(".//img[@class='widjet']"));			
			clickWidget(viewWidget);
		}
	}
	
	public Map<String, String> getTransactionDetailsById(String transactionID){
		
		Map<String, String> transactionDetails = new HashMap<String, String>();
		
		transactionDetails.put(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), 
				getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, TRANSACTIONS_TABLE_COLUMNS.ID.toString()));
		transactionDetails.put(TRANSACTIONS_TABLE_COLUMNS.USERNAME.toString(), 
				getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, TRANSACTIONS_TABLE_COLUMNS.USERNAME.toString()));
		transactionDetails.put(TRANSACTIONS_TABLE_COLUMNS.DATE.toString(), 
				getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, TRANSACTIONS_TABLE_COLUMNS.DATE.toString()));
		transactionDetails.put(TRANSACTIONS_TABLE_COLUMNS.AMOUNT.toString(), 
				getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, TRANSACTIONS_TABLE_COLUMNS.AMOUNT.toString()));
		transactionDetails.put(TRANSACTIONS_TABLE_COLUMNS.CURRENCY.toString(), 
				getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, TRANSACTIONS_TABLE_COLUMNS.CURRENCY.toString()));
		transactionDetails.put(TRANSACTIONS_TABLE_COLUMNS.PRODUCT.toString(), 
				getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, TRANSACTIONS_TABLE_COLUMNS.PRODUCT.toString()));
		transactionDetails.put(TRANSACTIONS_TABLE_COLUMNS.SERVICE.toString(), 
				getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, TRANSACTIONS_TABLE_COLUMNS.SERVICE.toString()));
		transactionDetails.put(TRANSACTIONS_TABLE_COLUMNS.METHOD.toString(), 
				getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, TRANSACTIONS_TABLE_COLUMNS.METHOD.toString()));
		transactionDetails.put(TRANSACTIONS_TABLE_COLUMNS.COUNTRY.toString(), 
				getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, TRANSACTIONS_TABLE_COLUMNS.COUNTRY.toString()));
		
		return transactionDetails;
	}

	public boolean isTransactionUsernameCorrect(Map<String, String> transactionDetails, String username){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.USERNAME.toString()).equals(username);
	}

	public boolean isTransactionAmountCorrect(Map<String, String> transactionDetails, String amount){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.AMOUNT.toString()).equals(amount);
	}

	public boolean isTransactionCurrencyCorrect(Map<String, String> transactionDetails, String currency){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.CURRENCY.toString()).equals(currency);
	}

	public boolean isTransactionProductCorrect(Map<String, String> transactionDetails, String product){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.PRODUCT.toString()).equals(product);
	}

	public boolean isTransactionServiceCorrect(Map<String, String> transactionDetails, String service){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.SERVICE.toString()).equals(service);
	}

	public boolean isTransactionMethodCorrect(Map<String, String> transactionDetails, String method){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.METHOD.toString()).equals(method);
	}
	
	public boolean isTransactionCountryCorrect(Map<String, String> transactionDetails, String country){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.COUNTRY.toString()).equals(country);
	}

	public String getTransactionUsername(Map<String, String> transactionDetails){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.USERNAME.toString());
	}

	public String getTransactionAmount(Map<String, String> transactionDetails){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.AMOUNT.toString());
	}

	public String getTransactionCurrency(Map<String, String> transactionDetails){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.CURRENCY.toString());
	}

	public String getTransactionProduct(Map<String, String> transactionDetails){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.PRODUCT.toString());
	}

	public String getTransactionService(Map<String, String> transactionDetails){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.SERVICE.toString());
	}

	public String getTransactionMethod(Map<String, String> transactionDetails){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.METHOD.toString());
	}
	
	public String getTransactionCountry(Map<String, String> transactionDetails){

		return transactionDetails.get(TRANSACTIONS_TABLE_COLUMNS.COUNTRY.toString());
	}
}
