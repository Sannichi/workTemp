package com.nymgo.tests.fragments.nymgo.account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Oct 13, 2015
 */

public class NormalAccountPageFragment extends BaseAccountPageFragment{
	
    public NormalAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		WebDriverWait wait = new WebDriverWait(driver, Starter.IMPLICITLY_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.visibilityOf(viewFullAccountButton));
		}
		catch(TimeoutException e){
			LOGGER.fatal("There is no element viewFullAccountButton on the Page");
		}
	}

	@FindBy(xpath = "//a[@class='view-profile']")
	private WebElement viewFullAccountButton;
	
	@FindBy(xpath = "//div[@class='owl-item']//div[@class='innerPadding']/div[2]")
	private List<WebElement> dealsNamesList;

	@FindBy(xpath = "//div[starts-with(@class,'block package')]//span[@class='notification']")	
	private WebElement myDealsCounter;

	//	@FindBy(xpath = "//div[starts-with(@class,'block package')]//div[@class='daysCounter']//strong")
	@FindBy(xpath = "//div[@class='daysCounter']//strong")
	private List<WebElement> dealDaysCounter;

	@FindBy(xpath = "//section[@class='normal']/div[@class='safeArea']//p")
	private WebElement depositLimitMessage;

	public void clickViewFullAccountButton(){
		
		clickSubmitButton(viewFullAccountButton);
	}

	public String getDealName(int i){
		
		return dealsNamesList.get(i - 1).getText();
	}

	public String getMyDealsCounter(){
		
		try {
			return myDealsCounter.getText();
		}
		catch (NoSuchElementException e){
			return "0";
		}
	}

	public String getDealDaysCounter(int i){
		
		return dealDaysCounter.get(i - 1).getText();
	}

	public String getDealMinutes(int i){
		
//		WebElement minutes = driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='packageInfo']//strong)[" + (i * 2 - 1) + "]")); 
//		return minutes.getText();
		return driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='packageInfo']//strong)[" + (i * 2 - 1) + "]")).getText();
	}
	
	public String getDealTopUp(int i){
		
//		WebElement topUp = driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='packageInfo']//strong)[" + (i * 2) + "]")); 
//		return topUp.getText();
		return driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='packageInfo']//strong)[" + (i * 2) + "]")).getText();
	}

	public int navigateToDeal(String dealName){
		
		int i = 0;
		int dealsCount = getDealsList().size(); 
		for (i = 0; i <= dealsCount - 1; i++){
			if (!driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='innerPadding'])[" + 
					(Integer.valueOf(i) + 1) + "]/div[2]")).getText().equals(dealName)){
				clickNextDealButton();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				return i + 1;
			}
		}
		LOGGER.fatal("There is no Deal with name '" + dealName + "'");
		return -1;
	}

	public String getDepositLimitValue(){
		
		return depositLimitMessage.getText().replaceAll("\\D+","");
	}
}
