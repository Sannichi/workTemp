package nymgoAutomation.tests.fragments.admin.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.starter.Starter;

public class BaseLoggedAdminPageWithSearchFragment extends BaseLoggedAdminFragment{

    public BaseLoggedAdminPageWithSearchFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "search")
	private WebElement searchCrieteriaInput;
    

  	@FindBy(id = "searchField")
	private WebElement searchFieldSelect;

	@FindBy(id = "serachType")
	private WebElement searchTypeSelect;

	@FindBys({@FindBy(id = "searchDisplay"),
		@FindBy(className = "but")
	})
	private WebElement goButton;

	@FindBy(id = "c_1")
	private WebElement firstRow;

	@FindBy(xpath = "//div[@class='ttrows'][last()]")
	private WebElement tableColumnsNames;
	
	public void typeCriteria(String criteria){
		
		setTextToEditField(searchCrieteriaInput, criteria);
	}

	public void selectField(String searchField){

		selectValueFromSelectByVisibleText(searchFieldSelect, searchField);
	}

	public void selectType(String searchType){

		selectValueFromSelectByVisibleText(searchTypeSelect, searchType);
	}
	
	public void clickGoButton(){
		
		clickInputButton(goButton);
	}

    protected void delay(final long amount) {
        try {
            Thread.sleep(amount);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	
	public void waitSearchCriteria(){

		delay(1000);
		WebDriverWait wait = new WebDriverWait(driver, Starter.ELEMENT_WAIT_TIME);
        try{
    		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("c_1"))));        	
            LOGGER.debug("First row is not displayed");    		
        }
        catch (TimeoutException e){
        	LOGGER.debug("First row was not become invisible");
        }
        try{
    		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("c_50"))));
    		LOGGER.debug("50th row is displayed");
        }
        catch (NoSuchElementException e){
        	LOGGER.debug("50th row was not displayed");
        }
	}

	protected List<WebElement> getResultsList(){

		List<WebElement> searchedElements = driver.findElements(By.cssSelector("div[id^='c_']"));
		return searchedElements;
	}

	public int getRowsCount(){
		
		return getResultsList().size();
	}

	public boolean isSearchResultEmpty(){
		
		List<WebElement> displayElements = getResultsList();
		if (displayElements.size() == 1){
			List<WebElement> spans = displayElements.get(0).findElements(By.cssSelector("span"));
			if (spans.size() == 0){
//				System.out.println("Search result is empty!");
				LOGGER.info("Search result is empty!");				
				return true;
			}
		}
		return false;
	}
	
	public List<String> getColumnNames(){

		List<String> columnsNames = new ArrayList<String>();
		List<WebElement> spans = tableColumnsNames.findElements(By.cssSelector("span"));
		for(WebElement element: spans){
			columnsNames.add(element.getText());
		}
		return columnsNames;
	}
	
	//return column index if exists, -1 if not
	public int isColumnPresent(String columnName){

		int result = -1;
		List<String> columnsNames = getColumnNames();
		for (int i = 0; i < columnsNames.size(); i ++){		
			if (columnsNames.get(i).equals(columnName)){
				return i;
			}
		}
//		System.out.println("Column with name " + columnName + "does not display on the screen.");
		LOGGER.warn("Column with name " + columnName + "does not display on the screen.");
		return result;
	}

	//return row index if exists, -1 if not
	public int isValueDisplays(String columnName, String fieldValue){
		
		int result = -1;
		List<WebElement> displayElements = getResultsList();
		String fieldValueInTable = " " + fieldValue;
		int columnIndex = isColumnPresent(columnName);
		if (columnIndex != -1){
			if(!isSearchResultEmpty()){
				for(int i = 0; i < displayElements.size(); i++){
					List<WebElement> spans = displayElements.get(i).findElements(By.cssSelector("span"));
					if (spans.size() >= 1){
						if (spans.get(columnIndex).getText().equals(fieldValueInTable)){
							return result = i;
						}
					}
					else{
						LOGGER.fatal("Search Result seems empty");
					}
				}
			}
		}
		LOGGER.info("Value " + fieldValue + " for column with name " + columnName + " does not display on the screen.");		
		return result;
	}
	
	public String getColumnRowValueByColumnRowValue( String columnNameBy, String fieldValueBy, String columnNameGet){
		
		List<WebElement> displayElements = getResultsList();
		String fieldValueByInTable = " " + fieldValueBy;
		int columnByIndex = isColumnPresent(columnNameBy); 
		int columnGetIndex = isColumnPresent(columnNameGet); 
		if ((columnByIndex != -1) && (columnGetIndex != -1)){
			if(!isSearchResultEmpty()){
				for(int i = 0; i < displayElements.size(); i++){
					List<WebElement> spans = displayElements.get(i).findElements(By.cssSelector("span"));
					if (spans.size() >= 1){
						if (spans.get(columnByIndex).getText().equals(fieldValueByInTable)){
							return spans.get(columnGetIndex).getText().substring(1);
						}
					}
					else{
						LOGGER.fatal("Search Result seems empty");
					}
				}
			}
		}
		LOGGER.info("Value " + fieldValueBy + " for column with name " + columnNameBy + " does not display on the screen"
				+ " or column with name " + columnNameGet + " does not display on the screen");		
		return "";
	}
}
