package nymgoAutomation.data.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} 
		catch (Exception e){
			throw (e);
		}
	}

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception	
	{   

		String[][] tabArray = null;
		try{

			FileInputStream ExcelFile = new FileInputStream(FilePath);
			
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
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
		}
		return(tabArray);
	}

	public static Object[] getUserArray(String FilePath, String SheetName) throws Exception	
	{   

		String[] tabArray = null;
		try{

			FileInputStream ExcelFile = new FileInputStream(FilePath);
			
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
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
		}
		return(tabArray);
	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		}
		catch (Exception e){
			return"";
		}
	}

	public static String getTestUserName(String sTestCase)throws Exception{

		String value = sTestCase;
		try{

			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
		}
		catch (Exception e){
			throw (e);
		}
	}

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{

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
			int RowCount = ExcelWSheet.getLastRowNum();
			return RowCount;
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}
	}
	
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	public static void setCellData(int RowNum, int ColNum, String str) throws Exception{
		try{
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(str);
			} else {
				Cell.setCellValue(str);
			}
	          // Constant variables Test Data path and Test Data file name
	          FileOutputStream fileOut = new FileOutputStream("");
	          ExcelWBook.write(fileOut);
	          fileOut.flush();
	          fileOut.close();			
		}
		catch (Exception e){
			throw (e);
		}
	}

	public static boolean setTransactionData(String FilePath, String SheetName, String username, String transactionID){

		try{
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int startCol = 1;
			int startRow = 1;
			try {
				setCellData(startRow, startCol, username);
				setCellData(startRow, startCol + 1, transactionID);				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		}
		return false;
	} 
}
