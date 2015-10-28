package nymgoAutomation.tests.fragments.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nymgoAutomation.tests.enums.MEMBERS_TABLE_COLUMNS;
import nymgoAutomation.tests.enums.URL_CONST;
import nymgoAutomation.tests.fragments.admin.base.BaseLoggedAdminPageWithSearchFragment;
import nymgoAutomation.tests.generators.ServerGenerator;
import nymgoAutomation.tests.starter.Starter;

public class MembersAdminPageFragment extends BaseLoggedAdminPageWithSearchFragment{

	public MembersAdminPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String MEMBERS_PAGE_URL_ENG = ServerGenerator.getServerKey(URL_CONST.ADMIN_URL) + "/modules/users/index.php"; 
			
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	try {
    		wait.until(ExpectedConditions.urlMatches(MEMBERS_PAGE_URL_ENG));
    		return true;
    	}
    	catch(TimeoutException e){
    		return false;
    	}
	}

	public void clickEditUserByUsername(String username){

		int rowIndex = isValueDisplays(MEMBERS_TABLE_COLUMNS.USERNAME.toString(), username); 
		if (rowIndex != -1){
			WebElement rowToClick = getResultsList().get(rowIndex);
			WebElement editWidget = rowToClick.findElement(By.xpath(".//img[@class='edit']"));			
			clickWidget(editWidget);
		}
	}

	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return MEMBERS_PAGE_URL_ENG;
	}
}
