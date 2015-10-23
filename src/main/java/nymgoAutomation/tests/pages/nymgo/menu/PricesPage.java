package nymgoAutomation.tests.pages.nymgo.menu;

import nymgoAutomation.tests.fragments.nymgo.menu.PricesPageFragment;
import nymgoAutomation.tests.pages.nymgo.base.AbstractNymgoPage;
import nymgoAutomation.tests.starter.Starter;

public class PricesPage extends AbstractNymgoPage{
	
	private PricesPageFragment pricesPageFragment;
	
	public PricesPage(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		pricesPageFragment = new PricesPageFragment(driver);
	}

	private static final String PRICES_PAGE_NAME_EN = "PricesPage";
	
	@Override
	public boolean isCorrectPage() {
		// TODO Auto-generated method stub
		return pricesPageFragment.isCorrectURL();
	}

	@Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return PRICES_PAGE_NAME_EN;
	}

	@Override
	public String getPageURL() {
		// TODO Auto-generated method stub
		return pricesPageFragment.getCorrectURL();
	}
    
}
