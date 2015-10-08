package nymgoAutomation.tests.pages.nymgo.menu.buyCredit;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BaseBuyCreditConfirmPageNextFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;
import nymgoAutomation.tests.pages.nymgo.account.NormalAccountPage;

public abstract class AbstractBuyCreditConfirmPageNext extends AbstractBuyCreditConfirmPage{

	BaseBuyCreditConfirmPageNextFragment baseBuyCreditConfirmPageNextFragment;
	
	public AbstractBuyCreditConfirmPageNext(Starter starter) {
		super(starter);
		// TODO Auto-generated constructor stub
		baseBuyCreditConfirmPageNextFragment = new BaseBuyCreditConfirmPageNextFragment(driver); 
	}

	public String getPaymentStatus(){
		
		return baseBuyCreditConfirmPageNextFragment.getPaymentStatus();		
	}

	//can return Normal user, Reseller and Master pages
	public void clickBackToDashboardButton(){
		
		baseBuyCreditConfirmPageNextFragment.clickBackToDashboardButton();
	}

	public NormalAccountPage clickBackToNormalUserDashboardButton(){
		
		clickBackToDashboardButton();
		NormalAccountPage normalAccountPage = new NormalAccountPage(starter);
		PageNavigation<NormalAccountPage> navigation = new PageNavigation<NormalAccountPage>(normalAccountPage);
		navigation.NavigatedTo();
		return normalAccountPage;
		
	}

	public String getTransactionAmountValue(){
		
		return baseBuyCreditConfirmPageNextFragment.getTransactionAmountValue();		
	}

	public String getTransactionNumber(){
		
		return baseBuyCreditConfirmPageNextFragment.getTransactionNumber();
	}

	public String getTransactionDate(){
		
		return baseBuyCreditConfirmPageNextFragment.getTransactionDate();
	}

	public String getTransactionTime(){
		
		return baseBuyCreditConfirmPageNextFragment.getTransactionTime();
	}
	
	public boolean isTransactionPending(){
		
		return baseBuyCreditConfirmPageNextFragment.isTransactionPending();
	}
}
