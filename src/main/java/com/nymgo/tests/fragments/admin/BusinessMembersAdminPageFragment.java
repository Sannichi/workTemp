package com.nymgo.tests.fragments.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.MEMBERS_TABLE_COLUMNS;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.admin.base.BaseLoggedAdminPageWithSearchFragment;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;
/**
 * Created by Iuliia Khikmatova on Oct 27, 2015
 */
public class BusinessMembersAdminPageFragment extends BaseLoggedAdminPageWithSearchFragment{

	public BusinessMembersAdminPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String BUSINESS_MEMBERS_PAGE_URL_ENG = ServerGenerator.getServerKey(URL_CONST.ADMIN_URL) + "/modules/bus_users/index.php"; 
			
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	try {
    		wait.until(ExpectedConditions.urlMatches(BUSINESS_MEMBERS_PAGE_URL_ENG));	
    		return true;
    	}
    	catch(TimeoutException e){
    		return false;
    	}
    }
    	
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return BUSINESS_MEMBERS_PAGE_URL_ENG;
	}

	
	public void clickEditUserByUsername(String username){

		int rowIndex = isValueDisplays(MEMBERS_TABLE_COLUMNS.USERNAME.toString(), username); 
		if (rowIndex != -1){
			WebElement rowToClick = getResultsList().get(rowIndex);
			WebElement editWidget = rowToClick.findElement(By.xpath(".//img[@class='widjet']"));			
			clickWidget(editWidget);
		}
	}
}
