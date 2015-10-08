package nymgoAutomation.tests.pages.admin.base;

import nymgoAutomation.tests.fragments.admin.base.BaseAdminFragment;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.AbstractPage;

public abstract class AbstractAdminPage extends AbstractPage{
	
	private BaseAdminFragment baseAdminFragment;

	public AbstractAdminPage(Starter starter) {
		
		super(starter);
		// TODO Auto-generated constructor stub
		baseAdminFragment = new BaseAdminFragment(driver);
	}
}
