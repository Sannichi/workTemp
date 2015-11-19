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
	private static final String nymgoAppsXpath = "//a[@href='" + homeURL + "/download/']";	
	private static final String nymgoPricesXpath = "//a[@href='" + homeURL + "/prices/']";	
	private static final String nymgoSupportXpath = "//a[@href='" + homeURL + "/support/']";	
	private static final String nymgoResellersXpath = "//a[@href='" + secureHomeURL + "/reseller/home']";	
	private static final String nymgoBuyCreditXpath = "//a[@href='" + secureHomeURL + "/buy-credits']";	
	protected static final String nymgoNormalUserSignInXpath = "//a[@href='" + secureHomeURL + "/login']";
//	protected static final String nymgoNormalUserSignInXpath = "//a[@href='" + homeURL + "/login']";
	protected static final String nymgoMyAccountXpath = ".//a[@href='" + secureHomeURL + "/user/dashboard']";	
//	protected static final String nymgoMyAccountXpath = ".//a[@href='" + homeURL + "/user/dashboard']";	
	protected static final String nymgoLogOutXpath = ".//a[@href='" + secureHomeURL + "/logout']";	

	private WebElement nymgoHomepageLink;
	private WebElement appsLink;
	private WebElement pricesLink;
	private WebElement supportLink;
	private WebElement resellersLink;
	private WebElement buyCreditButton;
	private WebElement normalUserSignInButton;
	
	@FindBy(css = "div.logo")
	private WebElement nymgoLogo;

	
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