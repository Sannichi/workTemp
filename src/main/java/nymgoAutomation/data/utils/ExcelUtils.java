package nymgoAutomation.data.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import nymgoAutomation.data.entity.AdminEntity;
import nymgoAutomation.data.entity.FullCardEntity;
import nymgoAutomation.data.entity.FullUserEntity;
import nymgoAutomation.data.enums.ADMIN_PARAMS;
import nymgoAutomation.data.enums.CARD_PARAMS;
import nymgoAutomation.data.enums.USER_PARAMS;
import nymgoAutomation.data.testCases.ExcelCases;
import nymgoAutomation.tests.enums.LOGS;
import nymgoAutomation.tests.starter.Starter;

public class ExcelUtils {
	
//	private static Logger LOGGER = ExcelCases.EXCEL_LOGGER;
	
	private static Logger LOGGER = Logger.getLogger(LOGS.LOGGER_NAME_EXCEL.toString());

	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;
	private static String transactionFilePath = Starter.TRANSACTIONS_FILE_PATH;
	private static String transactionSheetName = "Transactions";

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	private static void setExcelFile(String filePath,String sheetName) throws Exception{
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(filePath);

			// Access the required test data sheet
			excelWBook = new XSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
		} 
		catch (FileNotFoundException e){
			LOGGER.fatal("Excel file was not found on path '" + filePath + "'");
		}
		catch (Exception e){
			throw (e);
		}
	}

	private static void writeExcelFile(String filePath){
		
		// Constant variables Test Data path and Test Data file name
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(filePath);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object[][] getTableArray(String filePath, String sheetName){   

		String[][] tabArray = null;
		try{
			
			setExcelFile(filePath, sheetName);
			int startCol = 1;
			int startRow = 0;
			int ci=0,cj=0;
			int totalRows = 14;
			int totalCols = 1;
			tabArray = new String[totalCols][totalRows];;
			for (int j = startRow; j < totalRows; j++, cj++)
			{
				tabArray[ci][cj]=getCellData(j, startCol);				
//				System.out.println(tabArray[ci][cj]);
			}
		}
		catch (FileNotFoundException e)
		{

			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e)
		{

			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(tabArray);
	}

	private static String getParameterFromExcelSheet(String parameterName){
	
		String result = "";
		try{
			int paramCol = 0;
			int startRow = 0;
			int totalRows = getLastRowNumber();
			for (int j = startRow; j <= totalRows; j++)
			{
				if(getCellData(j, paramCol).equals(parameterName)){
					result = getCellData(j, paramCol + 1);
				}				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static AdminEntity getAdminEntity(String filePath, String sheetName)	
	{   

		AdminEntity adminEntity = new AdminEntity();
		try{

			setExcelFile(filePath, sheetName);
			adminEntity.setUsername(getParameterFromExcelSheet(ADMIN_PARAMS.USERNAME.toString()));
			adminEntity.setPassword(getParameterFromExcelSheet(ADMIN_PARAMS.PASSWORD.toString()));
		}
		catch (FileNotFoundException e)
		{

			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e)
		{

			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminEntity;
	}

	public static FullUserEntity getFullUserEntity(String filePath, String sheetName)	
	{   

		FullUserEntity fullUserEntity = new FullUserEntity();
		try{

			setExcelFile(filePath, sheetName);
			fullUserEntity.setUsername(getParameterFromExcelSheet(USER_PARAMS.USERNAME.toString()));
			fullUserEntity.setPassword(getParameterFromExcelSheet(USER_PARAMS.PASSWORD.toString()));
			fullUserEntity.setFullName(getParameterFromExcelSheet(USER_PARAMS.FULL_NAME.toString()));
			fullUserEntity.setEmail(getParameterFromExcelSheet(USER_PARAMS.EMAIL.toString()));
			fullUserEntity.setMobile(getParameterFromExcelSheet(USER_PARAMS.MOBILE.toString()));
			fullUserEntity.setPhone(getParameterFromExcelSheet(USER_PARAMS.PHONE.toString()));
			fullUserEntity.setCountryOfResidence(getParameterFromExcelSheet(USER_PARAMS.COUNTRY_OF_RESIDENCE.toString()));
			fullUserEntity.setCity(getParameterFromExcelSheet(USER_PARAMS.CITY.toString()));
			fullUserEntity.setFullAddress(getParameterFromExcelSheet(USER_PARAMS.FULL_ADDRESS.toString()));
			fullUserEntity.setStreet(getParameterFromExcelSheet(USER_PARAMS.STREET.toString()));
			fullUserEntity.setPostalCode(getParameterFromExcelSheet(USER_PARAMS.POSTAL_CODE.toString()));
			fullUserEntity.setDisplayCurrency(getParameterFromExcelSheet(USER_PARAMS.DISPLAY_CURRENCY.toString()));
			fullUserEntity.setPaymentCurrency(getParameterFromExcelSheet(USER_PARAMS.PAYMENT_CURRENCY.toString()));
			fullUserEntity.setLanguage(getParameterFromExcelSheet(USER_PARAMS.LANGUAGE.toString()));
			fullUserEntity.setGeoIpCountry(getParameterFromExcelSheet(USER_PARAMS.GEOIP_COUNTRY.toString()));
			fullUserEntity.setVat(getParameterFromExcelSheet(USER_PARAMS.VAT.toString()));
		}
		catch (FileNotFoundException e)
		{

			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e)
		{

			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fullUserEntity;
	}

	public static FullCardEntity getFullCardEntity(String filePath, String sheetName)	
	{   

		FullCardEntity fullCardEntity = new FullCardEntity();
		try{

			setExcelFile(filePath, sheetName);
			fullCardEntity.setCardNumber(getParameterFromExcelSheet(CARD_PARAMS.CARD_NUMBER.toString()));
			fullCardEntity.setExpirationMonth(getParameterFromExcelSheet(CARD_PARAMS.EXPIRATION_MONTH.toString()));
			fullCardEntity.setExpirationYear(getParameterFromExcelSheet(CARD_PARAMS.EXPIRATION_YEAR.toString()));
			fullCardEntity.setCvv(getParameterFromExcelSheet(CARD_PARAMS.CVV.toString()));
			fullCardEntity.setCardholdersName(getParameterFromExcelSheet(CARD_PARAMS.CARDHOLDERS_NAME.toString()));
		}
		catch (FileNotFoundException e)
		{

			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e)
		{

			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fullCardEntity;
	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	private static String getCellData(int RowNum, int ColNum){
		try{
			
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		}
		catch (Exception e){
			return"";
		}
	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	@SuppressWarnings("static-access")
	private static void setCellData(int RowNum, int ColNum, String str) throws Exception{	
		try{
			row = excelWSheet.getRow(RowNum);
			if (row == null){
				row = excelWSheet.createRow(RowNum);
			}
			cell = row.getCell(ColNum, row.RETURN_BLANK_AS_NULL);
			if (cell == null) {
				cell = row.createCell(ColNum);
			}  
			cell.setCellValue(str);
		}
		catch (Exception e){
			throw (e);
		}
	}

	public static boolean setTransactionDataFromStart(String username, String transactionID){	

		try{

			setExcelFile(transactionFilePath, transactionSheetName);
			int startCol = 0;
			int startRow = 0;
			try {
				setCellData(startRow, startCol, username);
				setCellData(startRow, startCol + 1, transactionID);				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writeExcelFile(transactionFilePath);
		}
		catch (FileNotFoundException e)
		{
	
			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 

	private static int getFirstEmptyRow(){
		//hope 100 transactions are maximum for one test suite
		int i = 0;
		int maxRows = 100;
		try{
			while (excelWSheet.getRow(i) != null){
				if (i > maxRows){
					break;
				}
				i++;
			}
			return i;
		}
		catch (Exception e){
			return maxRows;
		}
	}

	public static boolean addTransactionData(String transactionID){

		try{
			
			setExcelFile(transactionFilePath, transactionSheetName);
			int startCol = 0;
			int startRow = getFirstEmptyRow();
			LOGGER.info("Start row = " + startRow);
			try {
				setCellData(startRow, startCol + 1, transactionID);				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writeExcelFile(transactionFilePath);
		}
		catch (FileNotFoundException e)
		{
	
			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e)
		{
	
			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {

			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return false;
	} 

	public static boolean addTransactionData(String transactionID, String status){

		try{
			
			setExcelFile(transactionFilePath, transactionSheetName);
			int startCol = 0;
			int startRow = getFirstEmptyRow();
			try {
				setCellData(startRow, startCol + 1, transactionID);				
				setCellData(startRow, startCol + 2, status);				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writeExcelFile(transactionFilePath);
		}
		catch (FileNotFoundException e)
		{
	
			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e)
		{
	
			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 
/*
	public static boolean addTransactionData(String username, String transactionID){

		try{
			
			setExcelFile(transactionFilePath, transactionSheetName);
			int startCol = 0;
			int startRow = getFirstEmptyRow();
			try {
				setCellData(startRow, startCol, username);
				setCellData(startRow, startCol + 1, transactionID);				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writeExcelFile(transactionFilePath);
		}
		catch (FileNotFoundException e)
		{
	
			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e)
		{
	
			LOGGER.fatal("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 
*/
	public static void clearSheet(String filePath, String sheetName){
		
		try {
			setExcelFile(filePath, sheetName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int lastRow = getLastRowNumber();
		try{
			for (int i = 0; i <= lastRow; i++ ){
				excelWSheet.removeRow(excelWSheet.getRow(i));
			}
	          FileOutputStream fileOut = new FileOutputStream(filePath);
	          excelWBook.write(fileOut);
	          fileOut.flush();
	          fileOut.close();			
		}
		catch (Exception e){
//			System.out.println("Could not clear sheet");
			LOGGER.fatal("Could not clear sheet");			
		}
	}

	private static int getLastRowNumber(){	

		int result = excelWSheet.getLastRowNum();
//		LOGGER.debug("Last Row result = " + result + " " + getCellData(result, 1));
//		LOGGER.debug("Last Row result = " + result);
		if (result == 0){
			LOGGER.debug("PhysicalNumberOfRows result = " + excelWSheet.getPhysicalNumberOfRows());
			if (excelWSheet.getPhysicalNumberOfRows() == 1){
				return result;
			}
			else if (excelWSheet.getPhysicalNumberOfRows() == 0){
				LOGGER.warn("There are no any rows in the sheet");
				return -1;
			}
		}
		return result;
	}

	public static String getLastTransactionByUsername(String username){

		try{
			setExcelFile(transactionFilePath, transactionSheetName);			
			int startCol = 0;
			int startRow = 0;
			int lastRow = getLastRowNumber();
//			for (int i = lastRow - 1; i >= startRow; i --)
			for (int i = lastRow; i >= startRow; i --)			
			if (getCellData(i, startCol).equals(username)){
				return getCellData(i, startCol + 1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	} 

	public static String getLastTransaction(){

		try{
			setExcelFile(transactionFilePath, transactionSheetName);			
			int startCol = 0;
			int lastRow = getLastRowNumber();
			if (lastRow != -1){
				return getCellData(lastRow, startCol + 1);
			}
			else{
				LOGGER.fatal("There is no any transaction");
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	} 
}
