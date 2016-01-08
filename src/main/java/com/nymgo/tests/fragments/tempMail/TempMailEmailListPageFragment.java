package com.nymgo.tests.fragments.tempMail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 3, 2015
 */
public class TempMailEmailListPageFragment extends TempMailPageFragment{

	public TempMailEmailListPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private final static String mailsTableXpath = "//table[@id='mails']";

	@FindBy(xpath = mailsTableXpath)
	private WebElement mailsTable;

	@FindBy(xpath = mailsTableXpath + "/tbody/tr")
	private List<WebElement> mails;

	private WebElement getEmailSubject(WebElement email) throws StaleElementReferenceException{
		return email.findElement(By.xpath("//a[@class='title-subject']"));
	}
	
	private String getEmailSubjectText(WebElement email) throws StaleElementReferenceException{
		
		return getEmailSubject(email).getText(); 
	}
	
	private WebElement getFirstEmailBySubject(String emailSubject){
		try{
			for(int i = 0; i < mails.size(); i++){
				if (getEmailSubjectText(mails.get(i)).equals(emailSubject)){
					return mails.get(i);
				}
			}
		}
		catch(StaleElementReferenceException e){
			driver.navigate().refresh();
			LOGGER.info("TempMail page was refreshed");
			WebDriverWait wait = new WebDriverWait(driver, Starter.IMPLICITLY_WAIT_TIME);
			mails = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(mailsTableXpath + "/tbody/tr")));
			for(int i = 0; i < mails.size(); i++){
				if (getEmailSubjectText(mails.get(i)).equals(emailSubject)){
					return mails.get(i);
				}
			}
		}
		return null; 
	}
	
	public List<String> getAllEmailSubjects(){
		
		List<String> emailSubjects = new ArrayList<String>();
		for(WebElement e : mails){
			emailSubjects.add(getEmailSubjectText(e));
		}
		return emailSubjects;
	}
	
	public boolean isEmailBySubjectExists(String emailSubject){
		
		return getFirstEmailBySubject(emailSubject) != null ? true : false;
	}

	public void clickEmailBySubject(String emailSubject){
		
		WebElement email = getFirstEmailBySubject(emailSubject);
		if (email != null){
			getEmailSubject(email).click();
		}
		else {
			LOGGER.fatal("There is no email with the subject '" + emailSubject + "'");
		}
	}
}
