package nymgoAutomation.tests.pages.nymgo.base;

import nymgoAutomation.tests.fragments.nymgo.base.LoggedNymgoPageFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.SecureHomePage;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;
import nymgoAutomation.tests.pages.nymgo.account.ResellerAccountPage;
import nymgoAutomation.tests.starter.Starter;

public abstract class AbstractLoggedInPage extends AbstractNymgoPage{
	
	private LoggedNymgoPageFragment loggedNymgoPageFragment;
	
	public AbstractLoggedInPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		loggedNymgoPageFragment = new LoggedNymgoPageFragment(driver);
	}

	private void clickLogOut(){
		
		loggedNymgoPageFragment.clickLogOut();
	}

	public SecureHomePage logout(){

		clickLogOut();
		SecureHomePage secureHomePage = new SecureHomePage(starter);
		PageNavigation<SecureHomePage> navigation = new PageNavigation<SecureHomePage>(secureHomePage);
		navigation.NavigatedTo();
		return secureHomePage;

	}

	private void clickMyAccountDropdown(){
		
		loggedNymgoPageFragment.clickMyAccountDropdown();
	}

	public NormalAccountPage navigateToNormalUserMyAccountPage(){
		
		NormalAccountPage normalAccountPage = new NormalAccountPage(starter);
		if(!normalAccountPage.isCorrectPage()){
			clickMyAccountDropdown();
			PageNavigation<NormalAccountPage> navigation = new PageNavigation<NormalAccountPage>(normalAccountPage);
			navigation.NavigatedTo();
		} else {
			LOGGER.warn("Normal Account Page is already opened");
		}
		return normalAccountPage;
	}

	public ResellerAccountPage navigateToResellerMyAccountPage(){
		
		ResellerAccountPage resellerAccountPage = new ResellerAccountPage(starter);
		if(!resellerAccountPage.isCorrectPage()){
			clickMyAccountDropdown();
			PageNavigation<ResellerAccountPage> navigation = new PageNavigation<ResellerAccountPage>(resellerAccountPage);
			navigation.NavigatedTo();
		} else {
			LOGGER.warn("Reseller Account Page is already opened");
		}
		return resellerAccountPage;
	}
}
