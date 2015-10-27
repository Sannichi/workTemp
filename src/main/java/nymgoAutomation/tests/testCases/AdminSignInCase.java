package nymgoAutomation.tests.testCases;

import nymgoAutomation.data.entity.AdminEntity;
import nymgoAutomation.data.enums.PROVIDER_CONST;
import nymgoAutomation.data.providers.GeneralDataProvider;
import nymgoAutomation.tests.enums.TRANSACTIONS_TABLE_COLUMNS;
import nymgoAutomation.tests.enums.TRANSACTION_INFORMATION_ROWS;
import nymgoAutomation.tests.pages.admin.LoginAdminPage;
import nymgoAutomation.tests.pages.admin.MembersAdminPage;
import nymgoAutomation.tests.pages.admin.TransactionsAdminPage;
import nymgoAutomation.tests.pages.admin.base.AdminPage;
import nymgoAutomation.tests.pages.admin.widgets.MemberPaymentHistoryWidget;
import nymgoAutomation.tests.pages.nymgo.base.NymgoPage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.Assert;

public class AdminSignInCase extends AbstractCase{
	
    @Test(dataProvider = PROVIDER_CONST.ADMIN_PROVIDER, dataProviderClass = GeneralDataProvider.class)
	public void signInAdminTest(AdminEntity adminEntity){

    	String login = adminEntity.getUsername();
    	String password = adminEntity.getPassword();
    	
		NymgoPage nymgoPage = new NymgoPage(starter);
		LoginAdminPage loginAdminPage = nymgoPage.navigateToAdminLoginPage();
		
		MembersAdminPage membersAdminPage = loginAdminPage.signInUserSuccess(login, password);
		Assert.assertTrue(membersAdminPage.isAdminLogged());
	}

	@Test
	@Parameters({"criteria", "searchField", "searchType"})
	public void searchMembersAdminTest(String criteria, String searchField, String searchType){

		AdminPage adminPage = new AdminPage(starter);
/*		
		MembersAdminPage membersAdminPage = adminPage.clickMembersLink();

		List<WebElement> searched = membersAdminPage.searchCriteria(criteria, searchField, searchType);
		int count = searched.size();
		System.out.println("count = " + count);
		MemberListWidget memberListWidget = membersAdminPage.clickEditUserByUsername("turci.123");
//		memberListWidget.clickOnInfos();
		memberListWidget.clickOnTabByAltText("Infos");;		
		System.out.println("End");
*/
		TransactionsAdminPage transactionsAdminPage = adminPage.navigateTransactionsTab();
		String transactionID = "3324265152";
		String username = transactionsAdminPage.getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, 
				TRANSACTIONS_TABLE_COLUMNS.USERNAME.toString());
		String amount = transactionsAdminPage.getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, 
				TRANSACTIONS_TABLE_COLUMNS.AMOUNT.toString());
		String currency = transactionsAdminPage.getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, 
				TRANSACTIONS_TABLE_COLUMNS.CURRENCY.toString());
		String product = transactionsAdminPage.getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, 
				TRANSACTIONS_TABLE_COLUMNS.PRODUCT.toString());
		String service = transactionsAdminPage.getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, 
				TRANSACTIONS_TABLE_COLUMNS.SERVICE.toString());
		String method = transactionsAdminPage.getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, 
				TRANSACTIONS_TABLE_COLUMNS.METHOD.toString());
		String country = transactionsAdminPage.getColumnRowValueByColumnRowValue(TRANSACTIONS_TABLE_COLUMNS.ID.toString(), transactionID, 
				TRANSACTIONS_TABLE_COLUMNS.COUNTRY.toString());
		MemberPaymentHistoryWidget memberPaymentHistoryWidget = transactionsAdminPage.openViewTransactionsWidgedByID(transactionID);
//		Map<String, String> trInf = memberPaymentHistoryWidget.getAllTransactionInformation();
		String amountString = memberPaymentHistoryWidget.getTransactionInformationRowValueByRowName(TRANSACTION_INFORMATION_ROWS.AMOUNT_PAID.toString());
		memberPaymentHistoryWidget.clickOnCloseButton();
//		LOGGER.info("payment amount = " + paymentString);
		LOGGER.info("End");
	}
}
