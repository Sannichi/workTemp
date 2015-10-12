package nymgoAutomation.data.testCases;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import nymgoAutomation.data.utils.ExcelUtils;
import nymgoAutomation.tests.enums.LOGS;
import nymgoAutomation.tests.navigation.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 9, 2015
 */
public class ExcelCases {
	
	public static Logger EXCEL_LOGGER;

	@BeforeTest
	public void setUp(ITestContext context){

		EXCEL_LOGGER = Logger.getLogger(LOGS.LOGGER_NAME_EXCEL.toString());
	    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");        
	}
	
    @BeforeMethod
    public void methodNameStart(Method method){

    	EXCEL_LOGGER.info("Test method '" + method.getName() + "' started");
    }
    
    @AfterMethod
    public void methodNameFinish(Method method){

    	EXCEL_LOGGER.info("Test method '" + method.getName() + "' finished");
    }

	@Test
	public void clearTransactionsExcelTest(){

		ExcelUtils.clearSheet(Starter.TRANSACTIONS_FILE_PATH, "Transactions");
//		System.out.println("Transactions sheet was cleared");
		EXCEL_LOGGER.info("Transactions sheet was cleared");		
	}

}
