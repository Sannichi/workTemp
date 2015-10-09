package nymgoAutomation.data.testCases;

import org.testng.annotations.Test;

import nymgoAutomation.data.utils.ExcelUtils;
import nymgoAutomation.tests.navigation.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 9, 2015
 */
public class ExcelCases {
	
	@Test
	public void clearTransactionsExcelTest(){

		ExcelUtils.clearSheet(Starter.TRANSACTIONS_FILE_PATH, "Transactions");
		System.out.println("Transactions sheet was cleared");
	}

}
