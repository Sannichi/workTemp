package com.nymgo.tests.pages.admin.base;

import org.openqa.selenium.UnhandledAlertException;

import com.nymgo.tests.fragments.admin.base.AdminPageWithSearchFragment;
import com.nymgo.tests.pages.admin.alerts.UnhandledAlert;
import com.nymgo.tests.starter.Starter;

public abstract class AbstractLoggedAdminPageWithSearch extends AbstractLoggedAdminPage{

	private AdminPageWithSearchFragment adminPageWithSearchFragment;
	
    public AbstractLoggedAdminPageWithSearch(Starter starter) {

    	super(starter);
    	adminPageWithSearchFragment = new AdminPageWithSearchFragment(driver);
    }
	
	private void typeCriteria(String crieteria){
		
		adminPageWithSearchFragment.typeCriteria(crieteria);
	}

	private void selectField(String searchField){
		
		adminPageWithSearchFragment.selectField(searchField);
	}

	private void selectType(String searchType){
		
		adminPageWithSearchFragment.selectType(searchType);
	}
	
	private void clickGoButton(){
		
		adminPageWithSearchFragment.clickGoButton();
	}
	
	private void waitSearchCriteria(){
		
		adminPageWithSearchFragment.waitSearchCriteria();
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
		UnhandledAlert unhandledAlert = new UnhandledAlert(starter);
		clickGoButton();
		for (int i = 0; i < 5; i++){
			LOGGER.info("Searching...");
			try{
				waitSearchCriteria();
			}
			catch (UnhandledAlertException e){
				String alertText = unhandledAlert.getAlertText();
				unhandledAlert.acceptAlert();
				LOGGER.fatal("Unhandled alert with text: '" + alertText + "' was closed");
			}
			if (getRowsCount() <= 1){
				break;
			}
			if (i == 4){
				LOGGER.fatal("Search by Exact Match got more than 1 result :" + getRowsCount());
			}
		}
		return this;
	}

	public AbstractLoggedAdminPageWithSearch searchEmailExactMatch(String criteria){

		typeCriteria(criteria);
		selectField("Email");
		selectType("Exact Match");
		clickGoButton();
		for (int i = 0; i < 5; i++){
			LOGGER.info("Searching...");
			waitSearchCriteria();
			if (getRowsCount() <= 1){
				break;
			}
			if (i == 4){
				LOGGER.fatal("Search by Exact Match got more than 1 result :" + getRowsCount());
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
		
		return adminPageWithSearchFragment.isSearchResultEmpty();
	}
	
	public int getRowsCount(){
		
		return adminPageWithSearchFragment.getRowsCount();
	}
/*	
	private List<String> getColumnNames(){

		return adminPageWithSearchFragment.getColumnNames();
	}
	
	//return column index if exists, -1 if not
	private int isColumnPresent(String columnName){

		return adminPageWithSearchFragment.isColumnPresent(columnName);
	}

	//return row index if exists, -1 if not
	private int isValueDisplays(String columnName, String fieldValue){
		
		return adminPageWithSearchFragment.isValueDisplays(columnName, fieldValue);
	}
*/	
	public String getColumnRowValueByColumnRowValue( String columnNameBy, String fieldValueBy, String columnNameGet){
		
		return adminPageWithSearchFragment.getColumnRowValueByColumnRowValue(columnNameBy, fieldValueBy, columnNameGet);
	}
}
