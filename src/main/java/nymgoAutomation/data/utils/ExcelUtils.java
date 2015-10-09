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

import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.testCases.AbstractCase;

public class ExcelUtils {
	
	private static Logger LOGGER = AbstractCase.LOGGER;

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

			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e)
		{

			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(tabArray);
	}

	public static Object[] getUserArray(String filePath, String sheetName)	
	{   

		String[] tabArray = null;
		try{

			setExcelFile(filePath, sheetName);
			int startCol = 1;
			int startRow = 0;
			int cj=0;
			int totalRows = 14;
			tabArray = new String[totalRows];;
			for (int j = startRow; j < totalRows; j++, cj++)
			{
				tabArray[cj]=getCellData(j, startCol);				
//				System.out.println(tabArray[ci][cj]);
			}
		}
		catch (FileNotFoundException e)
		{

			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e)
		{

			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(tabArray);
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

	private static int getRowContains(String sTestCaseName, int colNum) throws Exception{

		int i;
		try {
			int rowCount = ExcelUtils.getRowUsed();
			for ( i=0 ; i<rowCount; i++){
				if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
					break;
				}
			}
			return i;
		}
		catch (Exception e){
			throw(e);
		}
	}

	public static int getRowUsed() throws Exception {

		try{
			int rowCount = excelWSheet.getLastRowNum();
			return rowCount;
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}
	}
	
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	@SuppressWarnings("static-access")
//	private static void setCellData(String filePath, int RowNum, int ColNum, String str) throws Exception{
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
/*			
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(filePath);
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
*/						
		}
		catch (Exception e){
			throw (e);
		}
	}

//	public static boolean setTransactionDataFromStart(String filePath, String sheetName, String username, String transactionID){
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
	
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 

	private static int getFirstEmptyRow(){
		//hope 50 transactions are maximum for one test suite
		int i = 0;
		int maxRows = 50;
		try{
			while (excelWSheet.getRow(i) != null){
				if (i > maxRows){
					LOGGER.fatal("Rows number is more than 50");
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

//	public static boolean addTransactionData(String filePath, String sheetName, String username, String transactionID){
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
	
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		catch (IOException e)
		{
	
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 

	public static void clearSheet(String filePath, String sheetName){
		
		try {
			setExcelFile(filePath, sheetName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int lastRow = excelWSheet.getPhysicalNumberOfRows();
		try{
			for (int i = 0; i < lastRow; i++ ){
				excelWSheet.removeRow(excelWSheet.getRow(i));
			}
	          FileOutputStream fileOut = new FileOutputStream(filePath);
	          excelWBook.write(fileOut);
	          fileOut.flush();
	          fileOut.close();			
		}
		catch (Exception e){
			System.out.println("Could not clear sheet");
		}
	}

//	private static int getLastRowNumber(String filePath, String sheetName){
	private static int getLastRowNumber(){	
/*		
		try {
			setExcelFile(filePath, sheetName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
*/
		return excelWSheet.getPhysicalNumberOfRows();
	}

	public static String getLastTransactionByUsername(String username){

		try{
//			setExcelFile(filePath, sheetName);
			setExcelFile(Starter.TRANSACTIONS_FILE_PATH, "Transactions");			
			int startCol = 0;
			int startRow = 0;
			int lastRow = getLastRowNumber();
			for (int i = lastRow - 1; i >= startRow; i --)
			if (getCellData(i, startCol).equals(username)){
				return getCellData(i, startCol + 1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
}
