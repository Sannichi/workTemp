package nymgoAutomation.tests.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import nymgoAutomation.tests.testCases.AbstractCase;

/**
 * Created by Iuliia Khikmatova on Oct 19, 2015
 */
public class LoggerTestListener extends TestListenerAdapter{

	private int m_count = 0;
	private Logger LOGGER; 
 
	@Override
	public void onTestFailure(ITestResult tr) {
		log("Test Result is Failure");
	}
 
	@Override
	public void onTestSkipped(ITestResult tr) {
		log("Test Result is Skipped");
	}
 
	@Override
	public void onTestSuccess(ITestResult tr) {
		log("Test Result is Success");
	}
 
	private void log(String string) {
		LOGGER = AbstractCase.LOGGER;
		LOGGER.info(string);
		if (++m_count % 40 == 0) {
			LOGGER.info("");
		}
	}
}
