package nymgoAutomation.tests.pages.nymgo.menu.buyCredit.globalCollect;

import org.testng.Assert;

import nymgoAutomation.tests.fragments.nymgo.menu.buyCredit.globalCollect.BuyCreditProceedPageGlobalCollectFragment;
import nymgoAutomation.tests.navigation.PageNavigation;
import nymgoAutomation.tests.pages.nymgo.menu.buyCredit.base.AbstractBuyCreditProceedPage;
import nymgoAutomation.tests.starter.Starter;

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

	private String getFullName(){
		
		return buyCreditProceedPageGlobalCollectFragment.getFullName();
	}

	private void setFullName(String fullName){
		
		buyCreditProceedPageGlobalCollectFragment.setFullName(fullName);
	}

	private String getEmail(){
		
		return buyCreditProceedPageGlobalCollectFragment.getEmail();
	}

	private void setEmail(String email){
		
		buyCreditProceedPageGlobalCollectFragment.setEmail(email);
	}

	private String getMobile(){
		
		return buyCreditProceedPageGlobalCollectFragment.getMobile();
	}

	private void setMobile(String mobile){
		
		buyCreditProceedPageGlobalCollectFragment.setMobile(mobile);
	}

	private String getPhone(){
		
		return buyCreditProceedPageGlobalCollectFragment.getPhone();
	}

	private void setPhone(String phone){
		
		buyCreditProceedPageGlobalCollectFragment.setPhone(phone);
	}

	private String getPostalCode(){
		
		return buyCreditProceedPageGlobalCollectFragment.getPostalCode();
	}

	private void setPostalCode(String postalCode){
		
		buyCreditProceedPageGlobalCollectFragment.setPostalCode(postalCode);
	}

	private String getStreet(){
		
		return buyCreditProceedPageGlobalCollectFragment.getStreet();
	}

	private void setStreet(String street){
		
		buyCreditProceedPageGlobalCollectFragment.setStreet(street);
	}

	private String getAddress(){
		
		return buyCreditProceedPageGlobalCollectFragment.getAddress();
	}
	
	private void setAddress(String address){
		
		buyCreditProceedPageGlobalCollectFragment.setAddress(address);
	}

	private String getSelectedCountryOfResidence(){
		
		return buyCreditProceedPageGlobalCollectFragment.getSelectedCountryOfResidence();
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
		
		boolean edited = false;
		if (fullName != null){
			if (!getFullName().equals(fullName)){
				setFullName(fullName);
				Assert.assertTrue(getFullName().equals(fullName), "Full Name was not updated. Current value is '"
				+ getFullName() + "', should be '" + fullName + "'");
				edited = true;
				LOGGER.info("Full Name is updated with " + fullName);
			}
		}
		if (email != null){
			if (!getEmail().equals(email)){
				setEmail(email);
				Assert.assertTrue(getEmail().equals(email), "Email was not updated. Current value is '"
				+ getEmail() + "', should be '" + email + "'");
				edited = true;
				LOGGER.info("Email is updated with " + email);
			}
		}
		if(mobile != null){
			if (!getMobile().equals(mobile)){
				setMobile(mobile);
				Assert.assertTrue(getMobile().equals(mobile), "Mobile was not updated. Current value is '"
				+ getMobile() + "', should be '" + mobile + "'");
				edited = true;
				LOGGER.info("Mobile is updated with " + mobile);
			}
		}
		if(phone != null){
			if (!getPhone().equals(phone)){
				setPhone(phone);
				Assert.assertTrue(getPhone().equals(phone), "Phone was not updated. Current value is '"
				+ getPhone() + "', should be '" + phone + "'");
				edited = true;
				LOGGER.info("Phone is updated with " + phone);
			}
		}
		if (!edited){
			LOGGER.info("Nothing to change in account info block");
		}
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
		
		boolean edited = false;
		if (countryOfResidence != null){
			if (!getSelectedCountryOfResidence().equals(countryOfResidence)){
				selectCountryOfResidence(countryOfResidence);
				Assert.assertTrue(getSelectedCountryOfResidence().equals(countryOfResidence), "Country of Residence was not updated. Current value is '"
				+ getSelectedCountryOfResidence() + "', should be '" + countryOfResidence + "'");
				edited = true;
				LOGGER.info("Country of Residence is updated with " + countryOfResidence);
			}
		}
		if (postalCode != null){
			if (!getPostalCode().equals(postalCode)){
				setPostalCode(postalCode);
				Assert.assertTrue(getPostalCode().equals(postalCode), "Postal Code was not updated. Current value is '"
				+ getPostalCode() + "', should be '" + postalCode + "'");
				edited = true;
				LOGGER.info("Postal Code is updated with " + postalCode);
			}
		}
		if(street != null){
			if (!getStreet().equals(street)){
				setStreet(street);
				Assert.assertTrue(getStreet().equals(postalCode), "Street was not updated. Current value is '"
				+ getStreet() + "', should be '" + street + "'");
				edited = true;
				LOGGER.info("Street is updated with " + street);
			}
		}
		if(address != null){
			if (!getAddress().equals(address)){
				setAddress(address);
				Assert.assertTrue(getAddress().equals(postalCode), "Address was not updated. Current value is '"
				+ getAddress() + "', should be '" + address + "'");
				edited = true;
				LOGGER.info("Address is updated with " + address);
			}
		}
		if (!edited){
			LOGGER.info("Nothing to change in address block");
		}
		return this;
	}
	
	public BuyCreditConfirmPageGlobalCollect verifyDataAndClickContinue(String fullName, String email, String mobile, String phone,
			String countryOfResidence, String postalCode, String street, String address,
			String cardType, String countryOfCredit,
			String nymgoCreditValue, String VAT, String totalAmountCharged){
		
		verifyAccountInfoBlock(fullName, email, mobile, phone);
		verifyAddressBlock(countryOfResidence, postalCode, street, address);
		verifyPaymentBlock(cardType, countryOfCredit);
		verifySkrillFooterBlock(nymgoCreditValue, VAT, totalAmountCharged);
		clickContinueButton();
		BuyCreditConfirmPageGlobalCollect buyCreditConfirmPageGlobalCollect = new BuyCreditConfirmPageGlobalCollect(starter);
		PageNavigation<BuyCreditConfirmPageGlobalCollect> navigation = new PageNavigation<BuyCreditConfirmPageGlobalCollect>(buyCreditConfirmPageGlobalCollect);
		navigation.NavigatedTo();
		return buyCreditConfirmPageGlobalCollect;
	} 
/*
	public void verifyDefaultData(String fullName, String email, String mobile, String phone,
			String countryOfResidence, String postalCode, String street, String address,
			String country,
			String nymgoCreditValue, String VAT, String totalAmountCharged){
*/		
	public void verifyDefaultData(String fullName, String email, String mobile, String phone,
			String countryOfResidence, String postalCode, String street, String address,
			String nymgoCreditValue, String VAT, String totalAmountCharged){
		verifyAccountInfoBlock(fullName, email, mobile, phone);
		verifyAddressBlock(countryOfResidence, postalCode, street, address);
		verifyDefaultPaymentBlock(countryOfResidence);
		verifySkrillFooterBlock(nymgoCreditValue, VAT, totalAmountCharged);
	}
}
