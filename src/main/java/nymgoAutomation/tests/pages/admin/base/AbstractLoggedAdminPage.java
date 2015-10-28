package nymgoAutomation.tests.pages.admin.base;

import nymgoAutomation.tests.fragments.admin.base.AdminPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.admin.BusinessMembersAdminPage;
import nymgoAutomation.tests.pages.admin.BusinessTransactionsAdminPage;
import nymgoAutomation.tests.pages.admin.LoginAdminPage;
import nymgoAutomation.tests.pages.admin.MembersAdminPage;
import nymgoAutomation.tests.pages.admin.NormalTransactionsAdminPage;
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

    private BusinessMembersAdminPage clickBusinessMembersLink()
	{
		
    	adminPageFragment.clickBusinessMembersLink();
    	BusinessMembersAdminPage businessMembersAdminPage = new BusinessMembersAdminPage(starter);
		PageNavigation<BusinessMembersAdminPage> navigation = new PageNavigation<BusinessMembersAdminPage>(businessMembersAdminPage); 
		navigation.NavigatedTo();
		return businessMembersAdminPage;
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

    public BusinessMembersAdminPage navigateBusinessMembersTab()
	{
    	BusinessMembersAdminPage businessMembersAdminPage = new BusinessMembersAdminPage(starter);
    	if (!getCurrentURL().equals(businessMembersAdminPage.isCorrectPage())){
    		businessMembersAdminPage = clickBusinessMembersLink();
    	}
    	LOGGER.info("Current page is already " + businessMembersAdminPage.getPageName());
    	return businessMembersAdminPage;
	}

    private NormalTransactionsAdminPage clickTransactionsLink()
	{
		
    	adminPageFragment.clickTransactionsLink();
    	delay(1500);
    	NormalTransactionsAdminPage transactionsAdminPage = new NormalTransactionsAdminPage(starter);
		PageNavigation<NormalTransactionsAdminPage> navigation = new PageNavigation<NormalTransactionsAdminPage>(transactionsAdminPage); 
		navigation.NavigatedTo();
		return transactionsAdminPage;
	}

    private BusinessTransactionsAdminPage clickBusinessTransactionsLink()
	{
		
    	adminPageFragment.clickBusinessTransactionsLink();
    	delay(1500);
    	BusinessTransactionsAdminPage businessTransactionsAdminPage = new BusinessTransactionsAdminPage(starter);
		PageNavigation<BusinessTransactionsAdminPage> navigation = new PageNavigation<BusinessTransactionsAdminPage>(businessTransactionsAdminPage); 
		navigation.NavigatedTo();
		return businessTransactionsAdminPage;
	}

    public NormalTransactionsAdminPage navigateTransactionsTab()
	{
    	NormalTransactionsAdminPage transactionsAdminPage = new NormalTransactionsAdminPage(starter);
    	if (!getCurrentURL().equals(transactionsAdminPage.isCorrectPage())){
    		LOGGER.info("Current URL is '" + getCurrentURL() + "', navigating to Transactions... ");
    		transactionsAdminPage = clickTransactionsLink();
    	}
    	LOGGER.info("Current page is already " + transactionsAdminPage.getPageName());
    	return transactionsAdminPage;
	}

    public BusinessTransactionsAdminPage navigateBusinessTransactionsTab()
	{
    	BusinessTransactionsAdminPage transactionsAdminPage = new BusinessTransactionsAdminPage(starter);
    	if (!getCurrentURL().equals(transactionsAdminPage.isCorrectPage())){
    		LOGGER.info("Current URL is '" + getCurrentURL() + "', navigating to Business Transactions... ");
    		transactionsAdminPage = clickBusinessTransactionsLink();
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
