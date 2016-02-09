package com.nymgo.tests.fragments.nymgo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALES;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.BaseFragment;
import com.nymgo.tests.fragments.HasURL;
import com.nymgo.tests.fragments.nymgo.account.BaseAccountPageFragment;
import com.nymgo.tests.fragments.nymgo.menu.AppsPageFragment;
import com.nymgo.tests.fragments.nymgo.menu.PricesPageFragment;
import com.nymgo.tests.fragments.nymgo.menu.ResellersPageFragment;
import com.nymgo.tests.fragments.nymgo.menu.SupportPageFragment;
import com.nymgo.tests.fragments.nymgo.menu.buyCredit.BuyCreditPageFragment;
import com.nymgo.tests.fragments.nymgo.menu.signIn.NormalUserSignInPageFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

public abstract class BaseNymgoFragment extends BaseFragment implements HasURL{
	
	public BaseNymgoFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static String homeURL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL);
	private static String secureHomeURL = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL) +
			LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL);
	private static final String nymgoHomepageXpath = "//a[@href='" + homeURL + "']";	
	private static final String nymgoAppsXpath = "//a[@href='" + AppsPageFragment.APPS_PAGE_URL + "']";	
	private static final String nymgoPricesXpath = "//a[@href='" + PricesPageFragment.PRICES_PAGE_URL + "']";	
	private static final String nymgoSupportXpath = "//a[@href='" + SupportPageFragment.SUPPORT_PAGE_URL + "']";	
	private static final String nymgoResellersXpath = "//a[@href='" + ResellersPageFragment.RESELLERS_PAGE_URL + "']";	
	private static final String nymgoBuyCreditXpath = "//a[@href='" + BuyCreditPageFragment.BUY_CREDIT_PAGE_URL + "']";	
	private static final String nymgoNormalUserSignInXpath = "//a[@href='" + NormalUserSignInPageFragment.NORMAL_ACCOUNT_PAGE_URL + "']";	
	protected static final String nymgoMyAccountXpath = ".//a[@href='" + BaseAccountPageFragment.ACCOUNT_PAGE_URL_EN + "']";	
	protected static final String nymgoLogOutXpath = ".//a[@href='" + secureHomeURL + "/logout']";	

	private WebElement nymgoHomepageLink;
	private WebElement appsLink;
	private WebElement pricesLink;
	private WebElement supportLink;
	private WebElement resellersLink;
	private WebElement buyCreditButton;
	private WebElement normalUserSignInButton;
	
	@FindBy(css = "div.logo")
	public WebElement nymgoLogo;

	@FindBy(css = "div[class='success-message']")
	private WebElement successMessage;

	@FindBy(css = "div[class='error-message']")
	private WebElement errorMessage;

	@FindBy(css = "div[class$='-message']")
	private WebElement upperMessage;

	@FindBy(xpath = ".//*[@class = 'selected-language']")
	private WebElement selectedLanguageButton;

	@FindBys({@FindBy(xpath = ".//*[@class = 'language-list']"),
		@FindBy(xpath = "//a[@href='/language/en']")
	})
	private WebElement englishLanguageButton;

	@FindBys({@FindBy(xpath = ".//*[@class = 'language-list']"),
		@FindBy(xpath = "//a[@href='/language/fr']")
	})
	private WebElement frenchLanguageButton;

	@FindBys({@FindBy(xpath = ".//*[@class = 'language-list']"),
		@FindBy(xpath = "//a[@href='/language/ar']")
	})
	private WebElement arabicLanguageButton;

	//accountSection
	
	@FindBys({@FindBy(xpath = "//*[@class = 'dropdown']"),
		@FindBy(xpath = ".//*[@class = 'signin']")
	})
	protected WebElement accountButton;


	private boolean isSuccessMessageEnabled(){
		
		return isElementEnabled(successMessage);
	}

	private boolean isErrorMessageEnabled(){
		
		return isElementEnabled(errorMessage);
	}

	private boolean isUpperMessageEnabled(){
		
		return isElementEnabled(upperMessage);
	}
	
	public String getSuccessMessage(){
		if (isSuccessMessageEnabled()){
			return successMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getErrorMessage(){
		if (isErrorMessageEnabled()){
			return errorMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getUpperMessage(){
		if (isUpperMessageEnabled()){
			return upperMessage.getText();
		}
		return "MessageDisabled";
	}

	public boolean getSuccessMessageState(){
		
		return isSuccessMessageEnabled();
	}

	private void initializeHomePageLink() throws NoSuchElementException{
		
		nymgoHomepageLink = driver.findElement(By.xpath(nymgoHomepageXpath));
	}
	
	private void initializeAppsLink() throws NoSuchElementException{
		
		appsLink = driver.findElement(By.xpath(nymgoAppsXpath));
	}

	private void initializePricesLink() throws NoSuchElementException{
		
		pricesLink = driver.findElement(By.xpath(nymgoPricesXpath));
	}
	
	private void initializeSupportLink() throws NoSuchElementException{
		
		supportLink = driver.findElement(By.xpath(nymgoSupportXpath));
	}

	private void initializeResellersLink() throws NoSuchElementException{
		
		resellersLink = driver.findElement(By.xpath(nymgoResellersXpath));
	}
	
	private void initializeBuyCreditButton() throws NoSuchElementException{
		
		buyCreditButton = driver.findElement(By.xpath(nymgoBuyCreditXpath));
	}

	private void initializeNormalUserSingInButton(){

		try{
			normalUserSignInButton = driver.findElement(By.xpath(nymgoNormalUserSignInXpath));
		} catch (NoSuchElementException e){
			LOGGER.fatal("Normal user Sign In button was not found");
		}
	}
	
	public String getHomeURL(){

		return homeURL;
	}
	
	public String getSecureHomeURL(){

		return secureHomeURL;
	}
	
    public void clickHomepageLink()
	{
		
    	initializeHomePageLink();
    	clickTitleLink(nymgoHomepageLink);
	}

	public void clickAppsLink()
	{
		
		initializeAppsLink();
		clickLink(appsLink);
	}

	public void clickPricesLink()
	{
		
		initializePricesLink();
		clickLink(pricesLink);
	}

	public void clickSupportLink()
	{
		
		initializeSupportLink();
		clickLink(supportLink);
	}

	public void clickResellersLink()
	{
		
		initializeResellersLink();
		clickLink(resellersLink);
	}

	public void clickMenuBuyCreditButton()
	{
		
		initializeBuyCreditButton();
		clickButton(buyCreditButton);
	}

	public void clickMenuNormalUserSignInButton()
    {

		initializeNormalUserSingInButton();
		clickButton(normalUserSignInButton);
    }
	
	public boolean isUserLogged()
	{
		boolean flag = false;

		
        try{
    		WebDriverWait wait = new WebDriverWait(driver, Starter.ELEMENT_WAIT_TIME);
    		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(accountButton)); 
            flag = true;
            LOGGER.debug("User is logged as " + webElement.getText() + ".");
        }
        catch (TimeoutException e){
            LOGGER.debug("User is not logged.");
        }
		
		return flag;
	}

	public boolean isUserLogged(String username)
	{
		
		boolean flag = false;
		if (isUserLogged()){
			flag = username.toLowerCase().equals(accountButton.getText());
		}
		return flag;
	}

	public String getCurrentLanguage(){

		return selectedLanguageButton.getText();
	}

	public void setLanguage(String language)
	{

		if (!getCurrentLanguage().toUpperCase().equals(language.toUpperCase()))
		{
			WebElement languageButton = null;
			LOCALES LOC = LOCALES.valueOf(language);
	        switch (LOC)
	        {
	            case ENGLISH:
	            	languageButton = englishLanguageButton;
	                break;
	            case FRENCH:
	            	languageButton = frenchLanguageButton;
	                break;
	            case ARABIC:
	            	languageButton = arabicLanguageButton;
	                break;
	            default:
	                break;
	        }
	        
			Actions actions = new Actions(driver);
			actions.moveToElement(selectedLanguageButton).perform();
    		WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(languageButton)); 
    		webElement.click();
		}
		LOGGER.info("Language is selected");
	}
}
