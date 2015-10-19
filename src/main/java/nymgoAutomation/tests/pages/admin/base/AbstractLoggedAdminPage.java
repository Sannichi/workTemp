package nymgoAutomation.tests.pages.admin.base;

import nymgoAutomation.tests.fragments.admin.base.BaseLoggedAdminFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.admin.LoginAdminPage;
import nymgoAutomation.tests.pages.admin.MembersAdminPage;
import nymgoAutomation.tests.pages.admin.TransactionsAdminPage;

public abstract class AbstractLoggedAdminPage extends AbstractAdminPage{

	private BaseLoggedAdminFragment baseLoggedAdminFragment;
	
	public AbstractLoggedAdminPage(Starter starter) {
        super(starter);
        baseLoggedAdminFragment = new BaseLoggedAdminFragment(driver);
    }

    private MembersAdminPage clickMembersLink()
	{
		
		baseLoggedAdminFragment.clickMembersLink();
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
		
    	baseLoggedAdminFragment.clickTransactionsLink();
    	TransactionsAdminPage transactionsAdminPage = new TransactionsAdminPage(starter);
		PageNavigation<TransactionsAdminPage> navigation = new PageNavigation<TransactionsAdminPage>(transactionsAdminPage); 
		navigation.NavigatedTo();
		return transactionsAdminPage;
	}

    public TransactionsAdminPage navigateTransactionsTab()
	{
    	TransactionsAdminPage transactionsAdminPage = new TransactionsAdminPage(starter);
    	if (!getCurrentURL().equals(transactionsAdminPage.isCorrectPage())){
    		transactionsAdminPage = clickTransactionsLink();
    	}
    	LOGGER.info("Current page is already " + transactionsAdminPage.getPageName());
    	return transactionsAdminPage;
	}

    public boolean isAdminLogged()
	{
		return baseLoggedAdminFragment.isAdminLogged();
	}

	public LoginAdminPage logout()
	{
		baseLoggedAdminFragment.clickLogout();
		return null;
		
	}
	
}
