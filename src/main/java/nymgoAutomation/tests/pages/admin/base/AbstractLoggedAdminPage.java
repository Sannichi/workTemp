package nymgoAutomation.tests.pages.admin.base;

import nymgoAutomation.tests.fragments.admin.base.AdminPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.admin.LoginAdminPage;
import nymgoAutomation.tests.pages.admin.MembersAdminPage;
import nymgoAutomation.tests.pages.admin.TransactionsAdminPage;
import nymgoAutomation.tests.starter.Starter;

public abstract class AbstractLoggedAdminPage extends AbstractAdminPage{

//	private BaseLoggedAdminFragment baseLoggedAdminFragment;
	private AdminPageFragment adminPageFragment;
	
	public AbstractLoggedAdminPage(Starter starter) {
        super(starter);
        adminPageFragment = new AdminPageFragment(driver);
    }

    private MembersAdminPage clickMembersLink()
	{
		
    	adminPageFragment.clickMembersLink();
		MembersAdminPage membersAdminPage = new MembersAdminPage(starter);
		PageNavigation<MembersAdminPage> navigation = new PageNavigation<MembersAdminPage>(membersAdminPage); 
		navigation.NavigatedTo();
		return membersAdminPage;
	}

    public MembersAdminPage navigateMembersTab()
	{
    	MembersAdminPage membersAdminPage = new MembersAdminPage(starter);
    	if (!getCurrentURL().equals(membersAdminPage.isCorrectPage())){
    		membersAdminPage = clickMembersLink();
    	}
    	LOGGER.info("Current page is already " + membersAdminPage.getPageName());
    	return membersAdminPage;
	}

    private TransactionsAdminPage clickTransactionsLink()
	{
		
    	adminPageFragment.clickTransactionsLink();
    	delay(1500);
    	TransactionsAdminPage transactionsAdminPage = new TransactionsAdminPage(starter);
		PageNavigation<TransactionsAdminPage> navigation = new PageNavigation<TransactionsAdminPage>(transactionsAdminPage); 
		navigation.NavigatedTo();
		return transactionsAdminPage;
	}

    public TransactionsAdminPage navigateTransactionsTab()
	{
    	TransactionsAdminPage transactionsAdminPage = new TransactionsAdminPage(starter);
    	if (!getCurrentURL().equals(transactionsAdminPage.isCorrectPage())){
    		LOGGER.info("Current URL is '" + getCurrentURL() + "', navigating to Transactions... ");
    		transactionsAdminPage = clickTransactionsLink();
    	}
    	LOGGER.info("Current page is already " + transactionsAdminPage.getPageName());
    	return transactionsAdminPage;
	}

    public TransactionsAdminPage navigateBusinessTransactionsTab()
	{
    	TransactionsAdminPage transactionsAdminPage = new TransactionsAdminPage(starter);
    	if (!getCurrentURL().equals(transactionsAdminPage.isCorrectPage())){
    		LOGGER.info("Current URL is '" + getCurrentURL() + "', navigating to Transactions... ");
    		transactionsAdminPage = clickTransactionsLink();
    	}
    	LOGGER.info("Current page is already " + transactionsAdminPage.getPageName());
    	return transactionsAdminPage;
	}

    public boolean isAdminLogged()
	{
		return adminPageFragment.isAdminLogged();
	}

	public LoginAdminPage logout()
	{
		adminPageFragment.clickLogout();
		return null;
		
	}
	
}
