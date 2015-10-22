package nymgoAutomation.tests.pages.nymgo.menu;

import nymgoAutomation.tests.fragments.nymgo.menu.SupportPageFragment;
import nymgoAutomation.tests.pages.nymgo.base.AbstractNymgoPage;
import nymgoAutomation.tests.starter.Starter;

public class SupportPage extends AbstractNymgoPage{
	
	private SupportPageFragment supportPageFragment;

	public SupportPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		supportPageFragment = new SupportPageFragment(driver);
	}

	private static final String SUPPORT_PAGE_NAME_EN = "SupportPage";
	
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return supportPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return SUPPORT_PAGE_NAME_EN;
	}
    
}
