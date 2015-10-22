package nymgoAutomation.tests.testCases;

import java.lang.reflect.Method;

import nymgoAutomation.tests.enums.LOGS;
import nymgoAutomation.tests.pages.nymgo.HomePage;
import nymgoAutomation.tests.pages.nymgo.base.NymgoPage;
import nymgoAutomation.tests.starter.Starter;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class AbstractCase {
	
    public static Starter starter;
	public static Logger LOGGER;
			
    @BeforeSuite
    public void setUp(ITestContext context) throws Exception {
        
        LOGGER = Logger.getLogger(LOGS.LOGGER_NAME.toString());
        LOGGER.info("Initializing configuration");
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");        

        initStarter(context);
    }    

    @BeforeTest
    public void testName(ITestContext context){

    	LOGGER.info("Test '" + context.getName() + "' started");    	
    }
    
    @BeforeMethod
    public void methodNameStart(Method method){

    	LOGGER.info("Test method '" + method.getName() + "' started");
    }
    
    @AfterMethod
    public void methodNameFinish(Method method){

    	LOGGER.info("Test method '" + method.getName() + "' finished");
    }

    @AfterSuite
	public void finishTests(){
		
//		driver.close();
    	starter.quiteDriver();
	}
	
    public String getTestStatus(int status){

    	switch(status){
    		case 1: 
    			return "SUCCESS";
    		case 2: 
    			return "FAILURE";
    		case 3: 
    			return "SKIP";
    		case 4: 
    			return "SUCCESS_PERCENTAGE_FAILURE";
    		case 16: 
    			return "STARTED";
    		default:
    			return "UNDEFINED";
    	}
    }

    public void initStarter(ITestContext context){

        LOGGER.info("Initializing Starter");
        starter = Starter.getInstance();
        starter.LOGGER = LOGGER;
    	starter.start(context);
        LOGGER.setLevel(Level.toLevel(starter.LOGGER_LEVEL));
        LOGGER.info("Setting LOGGER level to " + starter.LOGGER_LEVEL);
        LOGGER.info("Finished to initialize Starter");
    }
}
