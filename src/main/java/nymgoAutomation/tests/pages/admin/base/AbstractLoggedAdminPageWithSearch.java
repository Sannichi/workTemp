package nymgoAutomation.tests.pages.admin.base;

import java.util.List;

import nymgoAutomation.tests.fragments.admin.base.BaseLoggedAdminPageWithSearchFragment;
import nymgoAutomation.tests.starter.Starter;

public abstract class AbstractLoggedAdminPageWithSearch extends AbstractLoggedAdminPage{

	private BaseLoggedAdminPageWithSearchFragment baseLoggedAdminPageWithSearchFragment;
	
    public AbstractLoggedAdminPageWithSearch(Starter starter) {

    	super(starter);
    	baseLoggedAdminPageWithSearchFragment = new BaseLoggedAdminPageWithSearchFragment(driver);
    }
	
	private void typeCriteria(String crieteria){
		
		baseLoggedAdminPageWithSearchFragment.typeCriteria(crieteria);
	}

	private void selectField(String searchField){
		
		baseLoggedAdminPageWithSearchFragment.selectField(searchField);
	}

	private void selectType(String searchType){
		
		baseLoggedAdminPageWithSearchFragment.selectType(searchType);
	}
	
	private void clickGoButton(){
		
		baseLoggedAdminPageWithSearchFragment.clickGoButton();
	}
	
	private void waitSearchCriteria(){
		
		baseLoggedAdminPageWithSearchFragment.waitSearchCriteria();
	}

	public AbstractLoggedAdminPageWithSearch searchCriteria(String criteria, String searchField, String searchType){

		typeCriteria(criteria);
		selectField(searchField);
		selectType(searchType);
		clickGoButton();
		waitSearchCriteria();
		return this;
	}

	public AbstractLoggedAdminPageWithSearch searchIDExactMatch(String criteria){

		typeCriteria(criteria);
		selectField("ID");
		selectType("Exact Match");
		clickGoButton();
		for (int i = 0; i < 5; i++){
			LOGGER.info("Searching...");
			waitSearchCriteria();
			if (getRowsCount() <= 1){
				break;
			}
			if (i == 4){
				LOGGER.fatal("Search by Exact Match got more than 1 result");
			}
		}
		return this;
	}

	public AbstractLoggedAdminPageWithSearch searchUsernameExactMatch(String criteria){

		typeCriteria(criteria);
		selectField("Username");
		selectType("Exact Match");
		clickGoButton();
		for (int i = 0; i < 5; i++){
			LOGGER.info("Searching...");
			waitSearchCriteria();
			if (getRowsCount() <= 1){
				break;
			}
			if (i == 4){
				LOGGER.fatal("Search by Exact Match got more than 1 result: " + getRowsCount());
			}
		}
		return this;
	}

	public boolean isSearchResultEmpty(){
		
		return baseLoggedAdminPageWithSearchFragment.isSearchResultEmpty();
	}
	
	public int getRowsCount(){
		
		return baseLoggedAdminPageWithSearchFragment.getRowsCount();
	}
	
	private List<String> getColumnNames(){

		return baseLoggedAdminPageWithSearchFragment.getColumnNames();
	}
	
	//return column index if exists, -1 if not
	private int isColumnPresent(String columnName){

		return baseLoggedAdminPageWithSearchFragment.isColumnPresent(columnName);
	}

	//return row index if exists, -1 if not
	private int isValueDisplays(String columnName, String fieldValue){
		
		return baseLoggedAdminPageWithSearchFragment.isValueDisplays(columnName, fieldValue);
	}
	
	public String getColumnRowValueByColumnRowValue( String columnNameBy, String fieldValueBy, String columnNameGet){
		
		return baseLoggedAdminPageWithSearchFragment.getColumnRowValueByColumnRowValue(columnNameBy, fieldValueBy, columnNameGet);
	}
}
