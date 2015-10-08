package nymgoAutomation.tests.pages.nymgo.menu.buyCredit;

import org.testng.Assert;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.BuyCreditProceedPageGlobalCollectFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.navigation.Starter;

public class BuyCreditProceedPageGlobalCollect extends AbstractBuyCreditProceedPage{

	private BuyCreditProceedPageGlobalCollectFragment buyCreditProceedPageGlobalCollectFragment;
	
	private static final String BUY_CREDIT_PROCEED_PAGE_GC_NAME_ENG = "BuyCreditProceedGlobalCollectPage"; 
			
	public BuyCreditProceedPageGlobalCollect(Starter starter) {
        super(starter);
        buyCreditProceedPageGlobalCollectFragment = new BuyCreditProceedPageGlobalCollectFragment(driver);
    }
    
    @Override
	public String getPageName() {
		// TODO Auto-generated method stub
		return BUY_CREDIT_PROCEED_PAGE_GC_NAME_ENG;
	}

	private String getSelectedCountryOfResidence(){
		
		return buyCreditProceedPageGlobalCollectFragment.getSelectedCountryOfResidence();
	}

	private String getFullName(){
		
		return buyCreditProceedPageGlobalCollectFragment.getFullName();
	}

	private String getEmail(){
		
		return buyCreditProceedPageGlobalCollectFragment.getEmail();
	}

	private String getMobile(){
		
		return buyCreditProceedPageGlobalCollectFragment.getMobile();
	}

	private String getPhone(){
		
		return buyCreditProceedPageGlobalCollectFragment.getPhone();
	}

	private String getPostalCode(){
		
		return buyCreditProceedPageGlobalCollectFragment.getPostalCode();
	}

	private String getStreet(){
		
		return buyCreditProceedPageGlobalCollectFragment.getStreet();
	}

	private String getAddress(){
		
		return buyCreditProceedPageGlobalCollectFragment.getAddress();
	}
	
	private void selectCountryOfResidence(String countryOfResidence){
		
		buyCreditProceedPageGlobalCollectFragment.selectCountryOfResidence(countryOfResidence);
		Assert.assertTrue(buyCreditProceedPageGlobalCollectFragment.getSelectedCountryOfResidence().equals(countryOfResidence), "Country of Residence was not selected!");
	}

	//Account Info block
	private void verifyAccountInfoBlock(String fullName, String email, String mobile, String phone){
		
		Assert.assertTrue(getFullName().equals(fullName), "Full Name is not correct! Current value is '" + getFullName() + 
				"', should be '" + fullName + "'");
		LOGGER.info("Full Name is correct");
		Assert.assertTrue(getEmail().equals(email), "Email is not correct! Current value is '" + getEmail() + 
				"', should be '" + email + "'");
		LOGGER.info("Email is correct");
		Assert.assertTrue(getMobile().equals(mobile), "Mobile is not correct! Current value is '" + getMobile() + 
				"', should be '" + mobile + "'");
		LOGGER.info("Mobile is correct");
		Assert.assertTrue(getPhone().equals(phone), "Phone is not correct! Current value is '" + getPhone() + 
				"', should be '" + phone + "'");
		LOGGER.info("Phone is correct");
	}

	public BuyCreditProceedPageGlobalCollect setAccountInfoBlockData(String fullName, String email, String mobile, String phone){
		
		return this;
	}
	
	//Address block
	private void verifyAddressBlock(String countryOfResidence, String postalCode, String street, String address){
		
		Assert.assertTrue(getSelectedCountryOfResidence().equals(countryOfResidence), "Country of Residence is not correct! Current value is '" + getSelectedCountryOfResidence() + 
				"', should be '" + countryOfResidence + "'");
		LOGGER.info("Country of Residence is correct");
		Assert.assertTrue(getPostalCode().equals(postalCode), "Postal code is not correct! Current value is '" + getPostalCode() + 
				"', should be '" + postalCode + "'");
		LOGGER.info("Postal code is correct");
		Assert.assertTrue(getStreet().equals(street), "Street is not correct! Current value is '" + getStreet() + 
				"', should be '" + street + "'");
		LOGGER.info("Street is correct");
		Assert.assertTrue(getAddress().equals(address), "Address is not correct! Current value is '" + getAddress() + 
				"', should be '" + address + "'");
		LOGGER.info("Address is correct");
	}
	
	public BuyCreditProceedPageGlobalCollect setAddressBlockData(String countryOfResidence, String postalCode, String street, String address){
		
		selectCountryOfResidence(countryOfResidence);
		return this;
	}
	
	public BuyCreditConfirmPageGlobalCollect verifyDataAndClickContinue(String fullName, String email, String mobile, String phone,
			String countryOfResidence, String postalCode, String street, String address,
			String cardType, String country,
			String nymgoCreditValue, String VAT, String totalAmountCharged){
		
		verifyAccountInfoBlock(fullName, email, mobile, phone);
		verifyAddressBlock(countryOfResidence, postalCode, street, address);
		verifyPaymentBlock(cardType, country);
		verifySkrillFooterBlock(nymgoCreditValue, VAT, totalAmountCharged);
		clickContinueButton();
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);
		PageNavigation<BuyCreditConfirmPageGlobalCollect> navigation = new PageNavigation<BuyCreditConfirmPageGlobalCollect>(buyCreditConfirmPageGlobalCollect);
		navigation.NavigatedTo();
		return buyCreditConfirmPageGlobalCollect;
	} 

	public void verifyDefaultData(String fullName, String email, String mobile, String phone,
			String countryOfResidence, String postalCode, String street, String address,
			String country,
			String nymgoCreditValue, String VAT, String totalAmountCharged){
		
		verifyAccountInfoBlock(fullName, email, mobile, phone);
		verifyAddressBlock(countryOfResidence, postalCode, street, address);
		verifyDefaultPaymentBlock(country);
		verifySkrillFooterBlock(nymgoCreditValue, VAT, totalAmountCharged);
	} 
}
