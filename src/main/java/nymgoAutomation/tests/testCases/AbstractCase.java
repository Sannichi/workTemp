package nymgoAutomation.tests.testCases;

import java.lang.reflect.Method;

import nymgoAutomation.tests.enums.LOGS;
import nymgoAutomation.tests.navigation.Starter;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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

        initStarter();
//    	AbstractCase.LOGGER = starter.LOGGER;
    	starter.start(context);
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
	
    public void initStarter(){

        LOGGER.info("Initializing Starter");
        starter = Starter.getInstance();
        LOGGER.setLevel(Level.toLevel(starter.LOGGER_LEVEL));
        LOGGER.info("Setting LOGGER level to " + starter.LOGGER_LEVEL);
        starter.LOGGER = LOGGER;
        LOGGER.info("Finished to initialize Starter");
    }
}
