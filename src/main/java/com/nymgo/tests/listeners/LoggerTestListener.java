package com.nymgo.tests.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.nymgo.tests.enums.LOGS;
import com.nymgo.tests.pages.admin.alerts.UnhandledAlert;
import com.nymgo.tests.starter.Starter;
/**
 * Created by Iuliia Khikmatova on Oct 19, 2015
 */
public class LoggerTestListener extends TestListenerAdapter{

	private int m_count = 0;
	private Logger LOGGER; 
	private Starter starter;
 
	private void takeScreenshot(){
		
		File scrFile = ((TakesScreenshot)starter.driver).getScreenshotAs(OutputType.FILE);
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");
    	String screenshotName = ft.format(dNow) + ".png";
        try {
        	FileUtils.copyFile(scrFile, new File(Starter.WORKING_DIRECTORY + "\\screenshots\\" + screenshotName));
        } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
        log("Screenshot with name '" + screenshotName + "' created");		
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		log("Test Result is Failure");
		starter = Starter.getInstance();
		try{
			log(tr.getThrowable().getMessage());
			File scrFile = ((TakesScreenshot)starter.driver).getScreenshotAs(OutputType.FILE);
			Date dNow = new Date( );
		    SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh.mm.ss");
	    	String screenshotName = ft.format(dNow) + ".png";
	        try {
	        	FileUtils.copyFile(scrFile, new File(Starter.WORKING_DIRECTORY + "\\screenshots\\" + screenshotName));
	        } catch (IOException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	        }
	        log("Screenshot with name '" + screenshotName + "' created");		
		}
		catch (UnhandledAlertException e){
			UnhandledAlert unhandledAlert = new UnhandledAlert(starter);
			String alertText = unhandledAlert.getAlertText();
			unhandledAlert.acceptAlert();
			LOGGER.fatal("Unhandled alert with text: '" + alertText + "' was closed");
			takeScreenshot();
		}
	}
 
	@Override
	public void onTestSkipped(ITestResult tr) {
		log("Test Result is Skipped");
		log(tr.getThrowable().getMessage());
	}
 
	@Override
	public void onTestSuccess(ITestResult tr) {
		log("Test Result is Success");
	}
 
	private void log(String string) {
		LOGGER = Logger.getLogger(LOGS.LOGGER_NAME.toString());
		LOGGER.info(string);
		if (++m_count % 40 == 0) {
			LOGGER.info("");
		}
	}
	
}
