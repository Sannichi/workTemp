package com.nymgo.tests.starter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;

import com.nymgo.data.enums.ADMIN_PARAMS;
import com.nymgo.data.enums.CARD_PARAMS;
import com.nymgo.data.enums.USER_PARAMS;
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

import org.apache.log4j.Logger;

public class Starter {
	
    public Logger LOGGER;

    public static Properties PROPS;
    public static Properties PARAMS;
	
    public final  static String CONFIG_FILE_NAME = "config.file.name";
    public static String CONFIG_FILE = "config.properties";
    public static String PARAMS_FILE_NAME = "params.file.name";
    public static String PARAMS_FILE = "params.properties";
    public static String ADMIN_FILE_PATH = "D:\\work\\nymgo\\automation\\nymgoAutomation\\AdminUsers.xlsx"; //default value
    public static String USERS_FILE_PATH = "D:\\work\\nymgo\\automation\\nymgoAutomation\\NymgoUsers.xlsx"; //default value
    public static String TRANSACTIONS_FILE_PATH = "D:\\work\\nymgo\\automation\\nymgoAutomation\\Transactions.xlsx"; //default value
    public static String CREDIT_CARDS_FILE_PATH = "D:\\work\\nymgo\\automation\\nymgoAutomation\\CreditCards.xlsx"; //default value
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
        ADMIN_FILE_PATH = PARAMS.getProperty(ADMIN_PARAMS.ADMIN_FILE_PATH.name());
        USERS_FILE_PATH = PARAMS.getProperty(USER_PARAMS.USERS_FILE_PATH.name());
        TRANSACTIONS_FILE_PATH = PARAMS.getProperty(USER_PARAMS.TRANSACTIONS_FILE_PATH.name());
        CREDIT_CARDS_FILE_PATH = PARAMS.getProperty(CARD_PARAMS.CREDIT_CARDS_FILE_PATH.name());
        IMPLICITLY_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.IMPLICITLY_WAIT_TIME.name()));
        CORRECT_PAGE_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.CORRECT_PAGE_WAIT_TIME.name()));
        ELEMENT_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.ELEMENT_WAIT_TIME.name()));        
        INITIALIZED_ELEMENT_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.INITIALIZED_ELEMENT_WAIT_TIME.name()));
        IFRAME_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.IFRAME_WAIT_TIME.name()));
        ADMIN_TAB_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.ADMIN_TAB_WAIT_TIME.name()));

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

	private void initBrowser(){
		
        driver = getBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);   
        String homeURL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) + LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL); 
        LOGGER.info("Navigating to home page");
		driver.get(homeURL);
	}

    public void quiteDriver() {
        LOGGER.info("Going to quite the webDriver");
        driver.quit();
        driver = null;
        LOGGER.info("WebDriver was terminated and set to null");
    }
}
