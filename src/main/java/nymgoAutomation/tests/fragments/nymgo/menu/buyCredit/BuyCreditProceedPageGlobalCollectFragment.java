package nymgoAutomation.tests.fragments.nymgo.menu.buyCredit;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BuyCreditProceedPageGlobalCollectFragment extends BaseBuyCreditProceedPageFragment{

	public BuyCreditProceedPageGlobalCollectFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	private static final String BUY_CREDIT_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
//			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/proceed";	
			
	@FindBy(id = "country_of_residence")
	private WebElement countryOfResidenceSelect;
	
	@FindBy(id = "fullname-el")
	private WebElement fullName;

	@FindBy(id = "email-el")
	private WebElement email;

	@FindBy(id = "mobile-el")
	private WebElement mobile;

//	@FindBy(id = "home-el")
	@FindBy(xpath = "//input[@id='home-el']")	
	private List<WebElement> phoneAndStreet;

	@FindBy(id = "pobox-el")
	private WebElement postalCode;
/*
//	@FindBy(id = "home-el")
	@FindBy(xpath = "//input[@id='home-el']")	
	private WebElement street;
*/
	@FindBy(id = "street-el")
	private WebElement address;

	/*
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	return wait.until(ExpectedConditions.urlToBe(BUY_CREDIT_PAGE_URL));
	}

	private void selectCountryOfResidenceByLCName(String localeName){
		
		Select select = new Select(countryOfResidenceSelect);
		select.selectByVisibleText(LocaleGenerator.getLocaleKeyByLocaleName(localeName));
	}
*/	
	public void selectCountryOfResidence(String countryOfResidence){
/*		
		String localeName = LocaleGenerator.getLocaleKeyNameByValue(countryOfResidence);
		selectCountryOfResidenceByLCName(localeName);
*/
		selectValueFromSelectByLocaleText(countryOfResidenceSelect, countryOfResidence);
	}

	public String getSelectedCountryOfResidence(){
		
		Select select = new Select(countryOfResidenceSelect);
		return select.getFirstSelectedOption().getText();
	}
	
	public String getFullName(){
		
		return fullName.getAttribute("value");
	}

	public String getEmail(){
		
		return email.getAttribute("value");
	}

	public String getMobile(){
		
		return mobile.getAttribute("value");
	}

	public String getPhone(){
		
//		return phone.getAttribute("value");
		return phoneAndStreet.get(0).getAttribute("value");		
	}

	public String getPostalCode(){
		
		return postalCode.getAttribute("value");
	}

	public String getStreet(){
		
		return phoneAndStreet.get(1).getAttribute("value");
	}

	public String getAddress(){
		
		return address.getAttribute("value");
	}
}
