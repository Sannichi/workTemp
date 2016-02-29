package com.nymgo.tests.fragments.nymgo.account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.starter.Starter;

public class ResellerAccountPageFragment extends BaseAccountPageFragment{
	
    public ResellerAccountPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		WebDriverWait wait = new WebDriverWait(driver, Starter.IMPLICITLY_WAIT_TIME);
		try{
			wait.until(ExpectedConditions.visibilityOf(accountDetailsButton));
		}
		catch(TimeoutException e){
			LOGGER.fatal("There is no element accountDetailsButton on the Page");
		}
	}

    @FindBy(xpath = "//div[@id='account-details']//a[@class='button-edit']")
	private WebElement accountDetailsButton;

	@FindBy(xpath = "//div[@class='owl-item']//div[@class='innerPadding']/div[1]")
	private List<WebElement> resellerDealsNamesList;

	public void clickViewAccountDetailsButton(){
		
		scrollToElement(accountDetailsButton);
		clickSubmitButton(accountDetailsButton);
	}

	public String getDealsCount(int i){
		
		return resellerDealsNamesList.get(i - 1).getText().split(" ")[0];
	}

	public String getDealName(int i){
		
		return resellerDealsNamesList.get(i - 1).getText();
	}

	public String getDealDaysCounter(int i){
		
		return driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='packageInfo'])[" + (i) + "]/strong[3]")).getText();
	}

	public String getDealMinutes(int i){
		
		return driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='packageInfo'])[" + (i) + "]/strong[1]")).getText();
	}
	
	public String getDealTopUp(int i){
		
		return driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='packageInfo'])[" + (i) + "]/strong[2]")).getText();
	}

	public int navigateToDeal(String dealName){
		
		int i = 0;
		int dealsCount = getDealsList().size();
		String[] isAnyDeal = driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='innerPadding'])[1]/div[1]")).getText().split(" x ");
		if (isAnyDeal.length > 1){
			for (i = 0; i <= dealsCount - 1; i++){
				if (!driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='innerPadding'])[" + 
						(Integer.valueOf(i) + 1) + "]/div[1]")).getText().split(" x ")[1].equals(dealName)){
	//			LOGGER.debug(driver.findElement(By.xpath("(//div[starts-with(@class,'block package')]//div[@class='innerPadding'])[" + 
	//					(Integer.valueOf(i) + 1) + "]/div[1]")).getText());
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
			LOGGER.fatal("There is no Deal with name '" + dealName);
			return -1;
		}
		else{
			LOGGER.info("There is no any Deal yet");
			return -1;
		}
	}

}
