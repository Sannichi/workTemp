package nymgoAutomation.tests.navigation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import nymgoAutomation.data.enums.CARD_PARAMS;
import nymgoAutomation.data.enums.USER_PARAMS;
import nymgoAutomation.tests.enums.BROWSERS;
import nymgoAutomation.tests.enums.FILES_NAMES;
import nymgoAutomation.tests.enums.LOCALES;
import nymgoAutomation.tests.enums.LOCALE_CONST;
import nymgoAutomation.tests.enums.PROPERTIES;
import nymgoAutomation.tests.enums.SERVERS;
import nymgoAutomation.tests.enums.URL_CONST;
import nymgoAutomation.tests.enums.WAIT_TIME;
import nymgoAutomation.tests.generators.LocaleGenerator;
import nymgoAutomation.tests.generators.ServerGenerator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.apache.log4j.Logger;

public class Starter {
	
    public Logger LOGGER;

    public static Properties PROPS;
    public static Properties PARAMS;
	
    public final  static String CONFIG_FILE_NAME = "config.file.name";
    public static String CONFIG_FILE = "config.properties";
    public static String PARAMS_FILE = "params.file.name";
    public static String USERS_FILE_PATH = "";
    public static String TRANSACTIONS_FILE_PATH = "D:\\work\\nymgo\\Transactions.xlsx"; //default value
    public static String CREDIT_CARDS_FILE_PATH = "D:\\work\\nymgo\\CreditCards.xlsx"; //default value
    public static int IMPLICITLY_WAIT_TIME = 30;
    public static int CORRECT_PAGE_WAIT_TIME = 5;
    public static int ELEMENT_WAIT_TIME = 5;
    public static int INITIALIZED_ELEMENT_WAIT_TIME = 2;
    public static int IFRAME_WAIT_TIME = 30;
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
    
    public void initProperties(ITestContext context){
        LOGGER.info("Initializing config.properties");
        PROPS = new Properties();
        try {
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            try{
                String configFile = context.getCurrentXmlTest().getParameter(CONFIG_FILE_NAME);
                PROPS.load(new FileInputStream(configFile));
            }
            catch (NullPointerException e){
                LOGGER.warn("could not find the config file name in the xml suite, going to use the default " + CONFIG_FILE);
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

    public void initParams(ITestContext context){
        LOGGER.info("Initializing params.properties");
        PARAMS = new Properties();
        try {
            try{
                String paramsFile = context.getCurrentXmlTest().getParameter(PARAMS_FILE);
                PARAMS.load(new FileInputStream(paramsFile));
            }
            catch (NullPointerException e){
                LOGGER.warn("could not find the params file name in the xml suite, going to use the default " + PARAMS_FILE);
            }


        } catch (IOException e) {
            LOGGER.fatal("There was a problem to load the config file from " + PARAMS_FILE);
            e.printStackTrace();
        }
        USERS_FILE_PATH = PARAMS.getProperty(USER_PARAMS.USERS_FILE_PATH.name());
        TRANSACTIONS_FILE_PATH = PARAMS.getProperty(USER_PARAMS.TRANSACTIONS_FILE_PATH.name());
        CREDIT_CARDS_FILE_PATH = PARAMS.getProperty(CARD_PARAMS.CREDIT_CARDS_FILE_PATH.name());
        IMPLICITLY_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.IMPLICITLY_WAIT_TIME.name()));
        CORRECT_PAGE_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.CORRECT_PAGE_WAIT_TIME.name()));
        ELEMENT_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.ELEMENT_WAIT_TIME.name()));        
        INITIALIZED_ELEMENT_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.INITIALIZED_ELEMENT_WAIT_TIME.name()));
        IFRAME_WAIT_TIME = Integer.parseInt(PARAMS.getProperty(WAIT_TIME.IFRAME_WAIT_TIME.name()));
        
        LOGGER.info("Finished to initialize parameters");
    }

    public void initLocale(){

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

    public void initTestServer(){

        SERVERS SERV = SERVERS.valueOf(PROPS.getProperty(PROPERTIES.SERVER.name()));
        switch (SERV)
        {
            case DEV:
                ServerGenerator.setProps(FILES_NAMES.DEV.toString());
                break;
            case STAGING:
            	ServerGenerator.setProps(FILES_NAMES.STAGING.toString());
                break;
            case LIVE:
            	ServerGenerator.setProps(FILES_NAMES.LIVE.toString());
                break;
            default:
                ServerGenerator.setProps(FILES_NAMES.DEV.toString());
                break;
        }
    }

	public WebDriver getBrowser() {
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

	public void initBrowser(){
		
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
