package com.nymgo.tests.fragments.admin.widgets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nymgo.tests.enums.TRANSACTION_INFORMATION_ROWS;

/**
 * Created by Iuliia Khikmatova on Oct 28, 2015
 */
public class PaymentActionFragment extends BaseWidgetFragment{

	public PaymentActionFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath=".//input[@value='Accept Transaction']")
	private WebElement acceptTransactionButton;
	
	@FindBy(xpath=".//input[@value='Cancel Transaction']")
	private WebElement cancelTransactionButton;

	private WebElement getUserInformationTable(){

//		navigateToPaymentActionTab();
		return getWidgetContentArea().findElement(By.xpath(".//table[2]"));
	}

	private WebElement getTransactionInformationTable(){

//		navigateToPaymentActionTab();
		return getWidgetContentArea().findElement(By.xpath(".//table[3]"));
	}
	
	private WebElement getUserSummaryTable(){

//		navigateToPaymentActionTab();
		return getWidgetContentArea().findElement(By.xpath(".//table[4]"));
	}

	private String getTableRowName(WebElement row){
		
		return row.findElement(By.xpath(".//td[1]")).getText();
	}
	
	private String getTableRowValue(WebElement row){
		
		return row.findElement(By.xpath(".//td[2]")).getText();
	}

	private Map<String, String> getAllTableInformation(WebElement table){
		
		Map<String, String> tableInformation= new HashMap<String, String>();		
		List<WebElement> transactionInformationRows = table.findElements(By.xpath(".//tr"));		
//		for (WebElement row: transactionInformationRows){
		for (int i = 1; i < transactionInformationRows.size(); i++){//first row is a table name		
			tableInformation.put(getTableRowName(transactionInformationRows.get(i)), getTableRowValue(transactionInformationRows.get(i)));
		}
		return tableInformation;
	}

	private String getTableRowValueByRowName(WebElement table, String rowName){
		
		return getAllTableInformation(table).get(rowName);
	}

	public String getTransactionInformationRowValueByRowName(String rowName){
		
		return getTableRowValueByRowName(getTransactionInformationTable(), rowName);
	}

	public String getUserInformationRowValueByRowName(String rowName){
		
		return getTableRowValueByRowName(getUserInformationTable(), rowName);
	}

	public String getUserSummaryRowValueByRowName(String rowName){
		
		return getTableRowValueByRowName(getUserSummaryTable(), rowName);
	}

	public Map<String, String> getAllTransactionInformation(){
		
		return getAllTableInformation(getTransactionInformationTable());
	}
/*
	public Map<String, String> getAllUserInformation(){
		
		return getAllTableInformation(getUserInformationTable());
	}

	public Map<String, String> getAllUserSummary(){
		
		return getAllTableInformation(getUserSummaryTable());
	}
*/
	public void clickAcceptTransaction(){
		
		clickSubmitButton(acceptTransactionButton);
	}

	public void clickCancelTransaction(){
		
		clickButton(cancelTransactionButton);
	}
	
	public String getPaymentActionTransactionID(){
		
		Map<String, String> transactionInformation = getAllTransactionInformation();
		return transactionInformation.get(TRANSACTION_INFORMATION_ROWS.TRANSACTION_ID.toString());
	}
}

