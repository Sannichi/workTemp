package com.nymgo.tests.starter;

import java.io.FileInputStream;
import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import com.nymgo.data.enums.ADMIN_PARAMS;
import com.nymgo.data.enums.CARD_PARAMS;
import com.nymgo.data.enums.USER_PARAMS;
import com.nymgo.data.enums.VERIFIES_PARAMS;
import com.nymgo.tests.enums.BROWSERS;
import com.nymgo.tests.enums.FILES_NAMES;
import com.nymgo.tests.enums.LOCALES;
import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.PROPERTIES;
import com.nymgo.tests.enums.SERVERS;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.enums.WAIT_TIME;
import com.nymgo.tests.generators.CurrencyConversionRateGenerator;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.generators.ServerGenerator;
//import com.thoughtworks.selenium.webdriven.WebDriverCommandProcessor;

import org.apache.log4j.Logger;

public class Starter {
	
    public Logger LOGGER;

    public static Properties PROPS;
    public static Properties PARAMS;
	
    public final  static String CONFIG_FILE_NAME = "config.file.name";
    public static String SECURE_PART;
//    public static String SECURE_PART = "config.properties";
//    public static String SECURE_PART = "config.properties";
    public static String CONFIG_FILE = "config.properties";
    public static String PARAMS_FILE_NAME = "params.file.name";
    public static String PARAMS_FILE = "params.properties";
    public static String WORKING_DIRECTORY = "D:\\work\\nymgo\\automation\\nymgoAutomation"; //default value
    private static String ADMIN_FILE_NAME = "AdminUsers.xlsx"; //default value
    private static String USERS_FILE_NAME = "NymgoUsers.xlsx"; //default value
    private static String TRANSACTIONS_FILE_NAME = "Transactions.xlsx"; //default value
    private static String CREDIT_CARDS_FILE_NAME = "CreditCards.xlsx"; //default value
    private static String ACTIVATION_FILE_NAME = "Activation.txt"; //default value
    private static String REGISTRATION_FILE_NAME = "Registration.txt"; //default value
    private static String VERIFIES_FILE_NAME = "Verifies.xlsx"; //default value
    public static String ADMIN_FILE_PATH = WORKING_DIRECTORY + "\\" + ADMIN_FILE_NAME; //default value
    public static String USERS_FILE_PATH = WORKING_DIRECTORY + "\\" + USERS_FILE_NAME; //default value
    public static String TRANSACTIONS_FILE_PATH = WORKING_DIRECTORY + "\\" + TRANSACTIONS_FILE_NAME; //default value
    public static String CREDIT_CARDS_FILE_PATH = WORKING_DIRECTORY + "\\" + CREDIT_CARDS_FILE_NAME; //default value
    public static String VERIFIES_FILE_PATH = WORKING_DIRECTORY + "\\" + VERIFIES_FILE_NAME; //default value
    public static String REGISTRATION_FILE_PATH = WORKING_DIRECTORY + "\\" + REGISTRATION_FILE_NAME; //default value
    public static String ACTIVATION_FILE_PATH = WORKING_DIRECTORY + "\\" + ACTIVATION_FILE_NAME; //default value
    public static int IMPLICITLY_WAIT_TIME = 30;
    public static int CORRECT_PAGE_WAIT_TIME = 5;
    public static int ELEMENT_WAIT_TIME = 5;
    public static int INITIALIZED_ELEMENT_WAIT_TIME = 2;
    public static int IFRAME_WAIT_TIME = 30;
    public static int ADMIN_TAB_WAIT_TIME = 30;
    public String VERSION;
    public String PLATFORM;
    public String BROWSER;
    public String LOCALE;
    public String SERVER;
    public String LOGGER_LEVEL;
    
    private static Starter instance;
	public WebDriver driver = null;
//    private ThreadLocal<RemoteWebDriver> threadDriver = null;
	
    public static Starter getInstance() {
        if (instance == null) {
            instance = new Starter();
        }
        return instance;
    }
	
    public void start(ITestContext context){
    	
    	initProperties(context);
    	initParams(context);
    	initTestServer();
    	initLocale();
    	initBrowser();
    }
    
    private void initProperties(ITestContext context){
        LOGGER.info("Initializing config.properties");
        PROPS = new Properties();
        try {
        	WORKING_DIRECTORY = System.getProperty("user.dir");
        	LOGGER.info("Working Directory = " + System.getProperty("user.dir"));
            try{
                String configFile = context.getCurrentXmlTest().getParameter(CONFIG_FILE_NAME);
                PROPS.load(new FileInputStream(configFile));
            }
            catch (NullPointerException e){
                LOGGER.warn("could not find the config file name in the xml suite, going to use the default " + CONFIG_FILE);
                try{
                    String configFile = CONFIG_FILE;
                    PROPS.load(new FileInputStream(configFile));
                }
                catch (NullPointerException e2){
                    LOGGER.fatal("could not find the default config file in the project");
                }
            }


        } catch (IOException e) {
            LOGGER.fatal("There was a problem to load the config file from " + CONFIG_FILE);
            e.printStackTrace();
        }
        VERSION = PROPS.getProperty(PROPERTIES.VERSION.name());
        PLATFORM = PROPS.getProperty(PROPERTIES.PLATFORM.name());
        BROWSER = PROPS.getProperty(PROPERTIES.BROWSER.name());
        LOCALE = PROPS.getProperty(PROPERTIES.LOCALE.name());
        SERVER = PROPS.getProperty(PROPERTIES.SERVER.name());
        LOGGER_LEVEL = PROPS.getProperty(PROPERTIES.LOGGER_LEVEL.name());
        LOGGER.info("Finished to initialize properties");
    }

    private void initParams(ITestContext context){
        LOGGER.info("Initializing params.properties");
        PARAMS = new Properties();
        try {
            try{
                String paramsFile = context.getCurrentXmlTest().getParameter(PARAMS_FILE_NAME);
                PARAMS.load(new FileInputStream(paramsFile));
            }
            catch (NullPointerException e){
                LOGGER.warn("could not find the params file name in the xml suite, going to use the default " + PARAMS_FILE);
                try{
                    String paramsFile = PARAMS_FILE;
                    PARAMS.load(new FileInputStream(paramsFile));
                }
                catch (NullPointerException e2){
                    LOGGER.fatal("could not find the default params file in the project");
                }
            }


        } catch (IOException e) {
            LOGGER.fatal("There was a problem to load the config file from " + PARAMS_FILE);
            e.printStackTrace();
        }
		ADMIN_FILE_NAME = PARAMS.getProperty(ADMIN_PARAMS.ADMIN_FILE_NAME.name());
		USERS_FILE_NAME = PARAMS.getProperty(USER_PARAMS.USERS_FILE_NAME.name());
		TRANSACTIONS_FILE_NAME = PARAMS.getProperty(USER_PARAMS.TRANSACTIONS_FILE_NAME.name());
		CREDIT_CARDS_FILE_NAME = PARAMS.getProperty(CARD_PARAMS.CREDIT_CARDS_FILE_NAME.name());
		VERIFIES_FILE_NAME = PARAMS.getProperty(VERIFIES_PARAMS.VERIFIES_FILE_NAME.name());
		ACTIVATION_FILE_NAME = PARAMS.getProperty(VERIFIES_PARAMS.ACTIVATION_FILE_NAME.name());
		REGISTRATION_FILE_NAME = PARAMS.getProperty(VERIFIES_PARAMS.REGISTRATION_FILE_NAME.name());
		
        IMPLICITLY_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.IMPLICITLY_WAIT_TIME.name()));
        CORRECT_PAGE_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.CORRECT_PAGE_WAIT_TIME.name()));
        ELEMENT_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.ELEMENT_WAIT_TIME.name()));        
        INITIALIZED_ELEMENT_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.INITIALIZED_ELEMENT_WAIT_TIME.name()));
        IFRAME_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.IFRAME_WAIT_TIME.name()));
        ADMIN_TAB_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.ADMIN_TAB_WAIT_TIME.name()));

        ADMIN_FILE_PATH = WORKING_DIRECTORY + "\\" + ADMIN_FILE_NAME;
        USERS_FILE_PATH = WORKING_DIRECTORY + "\\" + USERS_FILE_NAME;
        TRANSACTIONS_FILE_PATH = WORKING_DIRECTORY + "\\" + TRANSACTIONS_FILE_NAME;
        CREDIT_CARDS_FILE_PATH = WORKING_DIRECTORY + "\\" + CREDIT_CARDS_FILE_NAME;
        VERIFIES_FILE_PATH = WORKING_DIRECTORY + "\\" + VERIFIES_FILE_NAME;
        ACTIVATION_FILE_PATH = WORKING_DIRECTORY + "\\" + ACTIVATION_FILE_NAME;
        REGISTRATION_FILE_PATH = WORKING_DIRECTORY + "\\" + REGISTRATION_FILE_NAME;

        LOGGER.info("Finished to initialize parameters");
    }

    private void initLocale(){

        LOCALES LOC = LOCALES.valueOf(PROPS.getProperty(PROPERTIES.LOCALE.name()));
        switch (LOC)
        {
            case ENGLISH:
                LocaleGenerator.setProps(FILES_NAMES.LOCALE_EN.toString());
                break;
            case FRENCH:
                LocaleGenerator.setProps(FILES_NAMES.LOCALE_FR.toString());
                break;
            case ARABIC:
                LocaleGenerator.setProps(FILES_NAMES.LOCALE_AR.toString());
                break;
            case INDONESIAN:
                LocaleGenerator.setProps(FILES_NAMES.LOCALE_IN.toString());
                break;
            case TURKISH:
                LocaleGenerator.setProps(FILES_NAMES.LOCALE_TU.toString());
                break;
            default:
                LocaleGenerator.setProps(FILES_NAMES.LOCALE_EN.toString());
                break;
        }
    }

    private void initTestServer(){

        SERVERS SERV = SERVERS.valueOf(PROPS.getProperty(PROPERTIES.SERVER.name()));
        switch (SERV)
        {
            case DEV:
                ServerGenerator.setProps(FILES_NAMES.DEV.toString());
                CurrencyConversionRateGenerator.setProps(FILES_NAMES.CONVERSION_RATES_DEV.toString());
                break;
            case STAGING:
            	ServerGenerator.setProps(FILES_NAMES.STAGING.toString());
                CurrencyConversionRateGenerator.setProps(FILES_NAMES.CONVERSION_RATES_STAGING.toString());
                break;
            case LIVE:
            	ServerGenerator.setProps(FILES_NAMES.LIVE.toString());
                CurrencyConversionRateGenerator.setProps(FILES_NAMES.CONVERSION_RATES_LIVE.toString());
                break;
            default:
                ServerGenerator.setProps(FILES_NAMES.DEV.toString());
                CurrencyConversionRateGenerator.setProps(FILES_NAMES.CONVERSION_RATES_DEV.toString());
                break;
        }
//        SECURE_PART = ServerGenerator.getServerKey(URL_CONST.SECURE_HOME_URL);
        SECURE_PART = ServerGenerator.getServerKey(URL_CONST.HOME_URL);
//        SECURE_PART = ServerGenerator.getServerKey(URL_CONST.HOME_URL).replace("http", "https");
    }
/*
    public void initConversionRates(ITestContext context){
        LOGGER.info("Initializing conversionRates.file.properties");
        //TODO add testServer dependency
        try{
            CurrencyConversionRateGenerator.setProps(context.getCurrentXmlTest().getParameter(CONVERSION_RATES_FILE));
        }
        catch (NullPointerException e){
            LOGGER.warn("could not find the conversion rates file name in the xml suite, going to use the default " + CONVERSION_RATES_FILE);
        }
        LOGGER.info("Finished to initialize conversion rates");
    }
*/
	private WebDriver getBrowser() {
//	private RemoteWebDriver getBrowser() {    
		BROWSERS BROWSER = BROWSERS.valueOf(PROPS.getProperty(PROPERTIES.BROWSER.name()));
        switch (BROWSER)
        {
            case FIREFOX:
                return new FirefoxDriver();
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
                return new ChromeDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", "C:\\IEDriver\\IEDriverServer.exe");
                return new InternetExplorerDriver();
            default:
                return new FirefoxDriver();
        }
	}
/*
	private RemoteWebDriver getRemoteBrowser() {
		BROWSERS BROWSER = BROWSERS.valueOf(PROPS.getProperty(PROPERTIES.BROWSER.name()));
		DesiredCapabilities dc = new DesiredCapabilities();
	    FirefoxProfile fp = new FirefoxProfile();
	    URL newURL = null;
		try {
			newURL = new URL("http://localhost:4444/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        switch (BROWSER)
        {
            case FIREFOX:
    	        dc.setCapability(FirefoxDriver.PROFILE, fp);
    	        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
    	        return new RemoteWebDriver(newURL, dc);		
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();                
                ChromeOptions options = new ChromeOptions();
                options.addArguments("user-data-dir=C:/Users/iuliia.khikmatova/AppData/Local/Google/Chrome/User Data");
                options.addArguments("--start-maximized");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);                
                dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
                return new RemoteWebDriver(newURL, capabilities);
            case IE:
                System.setProperty("webdriver.ie.driver", "C:\\IEDriver\\IEDriverServer.exe");
                return new InternetExplorerDriver();
            default:
    	        dc.setCapability(FirefoxDriver.PROFILE, fp);
    	        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
    	        return new RemoteWebDriver(newURL, dc);		
        }
	}
*/
	private void initBrowser(){

        driver = getBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);   
        String homeURL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) + LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL); 
        LOGGER.info("Navigating to home page");
		driver.get(homeURL);

/*		
		threadDriver = new ThreadLocal<RemoteWebDriver>();
		threadDriver.set(getBrowser());
		driver = threadDriver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);   
        String homeURL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) + LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL); 
        LOGGER.info("Navigating to home page");
		driver.get(homeURL);
*/
	}

    public void quiteDriver() {
        LOGGER.info("Going to quite the webDriver");
        driver.quit();
        driver = null;
        LOGGER.info("WebDriver was terminated and set to null");
    }
}
