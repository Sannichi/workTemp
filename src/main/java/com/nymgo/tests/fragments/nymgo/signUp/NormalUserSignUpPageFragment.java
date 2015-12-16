package com.nymgo.tests.fragments.nymgo.signUp;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nymgo.tests.enums.LOCALE_CONST;
import com.nymgo.tests.enums.URL_CONST;
import com.nymgo.tests.fragments.nymgo.base.BaseNymgoFragment;
import com.nymgo.tests.generators.LocaleGenerator;
import com.nymgo.tests.generators.ServerGenerator;
import com.nymgo.tests.starter.Starter;

/**
 * Created by Iuliia Khikmatova on Dec 1, 2015
 */
public class NormalUserSignUpPageFragment extends BaseNymgoFragment{

	public NormalUserSignUpPageFragment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final String fullNameId = "full_name-el";
	private static final String usernameId = "Username-Email-el";
	private static final String passwordXpath = "//input[@name='password']";
	private static final String confirmPasswordXpath = "//input[@name='confirm_password']";
	private static final String emailId = "Email-el";
	private static final String mobileId = "mobile-el";
	
	@FindBy(id = fullNameId)
	private WebElement fullNameEdit;

	@FindBy(id = usernameId)
	private WebElement usernameEdit;

	@FindBy(xpath = passwordXpath)
	private WebElement passwordEdit;

	@FindBy(xpath = confirmPasswordXpath)
	private WebElement confirmPasswordEdit;

	@FindBy(id = emailId)
	private WebElement emailEdit;

	@FindBy(id = mobileId)
	private WebElement mobileEdit;

	@FindBy(id = "send-btn-el")
	private WebElement joinButton;
	
	@FindBy(xpath = "//input[@id='" + fullNameId + "']/../div[@class='validation-msg']")
	private WebElement fullNameValidationMessage;

	@FindBy(xpath = "//input[@id='" + usernameId + "']/../div[@class='validation-msg']")
	private WebElement usernameValidationMessage;
	
	@FindBy(xpath = passwordXpath + "/../div[@class='validation-msg']")
	private WebElement passwordValidationMessage;
	
	@FindBy(xpath = confirmPasswordXpath + "/../div[@class='validation-msg']")
	private WebElement confirmPasswordValidationMessage;
	
	@FindBy(xpath = "//input[@id='" + emailId + "']/../div[@class='validation-msg']")
	private WebElement emailValidationMessage;
	
	@FindBy(xpath = "//input[@id='" + mobileId + "']/../div[@class='validation-msg']")
	private WebElement mobileValidationMessage;

	private static final String NORMAL_ACCOUNT_SIGN_UP_PAGE_URL = ServerGenerator.getServerKey(URL_CONST.HOME_URL) +
					LocaleGenerator.getLocaleKey(LOCALE_CONST.LANGUAGE_URL) + "/register";
	
	@Override
	public boolean isCorrectURL() {
		// TODO Auto-generated method stub
    	WebDriverWait wait = new WebDriverWait(driver, Starter.CORRECT_PAGE_WAIT_TIME);
    	try{
    		wait.until(ExpectedConditions.urlToBe(NORMAL_ACCOUNT_SIGN_UP_PAGE_URL));
    		return true;
    	}
    	catch(TimeoutException e){
    		return false;
    	}
	}

	@Override
	public String getCorrectURL() {
		// TODO Auto-generated method stub
		return NORMAL_ACCOUNT_SIGN_UP_PAGE_URL;
	}

	public void typeFullName(String fullName){
		
		setTextToEditField(fullNameEdit, fullName);
	}
	
	public String getFullName(){
		
		return fullNameEdit.getAttribute("value");
	}
	
	public void typeUsername(String username){
		
		setTextToEditField(usernameEdit, username);
	}

	public String getUsername(){
		
		return usernameEdit.getAttribute("value");
	}
	
	public void typePassword(String password){
		
		setTextToEditField(passwordEdit, password);
	}

	public String getPassword(){
		
		return passwordEdit.getAttribute("value");
	}
	
	public void typeConfirmPassword(String confirmPassword){
		
		setTextToEditField(confirmPasswordEdit, confirmPassword);
	}

	public String getConfirmPassword(){
		
		return confirmPasswordEdit.getAttribute("value");
	}
	
	public void typeEmail(String email){
		
		setTextToEditField(emailEdit, email);
	}

	public String getEmail(){
		
		return emailEdit.getAttribute("value");
	}
	
	public void typeMobile(String mobile){
		
		setTextToEditField(mobileEdit, mobile);
	}

	public String getMoblie(){
		
		return mobileEdit.getAttribute("value");
	}
	
	public void clickJoinButton(){
		
		clickInputButton(joinButton);
	}
	
	private boolean isFullNameValidationMessageEnabled(){
		
		return isElementEnabled(fullNameValidationMessage);
	}

	private boolean isUsernameValidationMessageEnabled(){
		
		return isElementEnabled(usernameValidationMessage);
	}

	private boolean isEmailValidationMessageEnabled(){
		
		return isElementEnabled(emailValidationMessage);
	}

	private boolean isPasswordValidationMessageEnabled(){
		
		return isElementEnabled(passwordValidationMessage);
	}

	private boolean isConfirmPasswordValidationMessageEnabled(){
		
		return isElementEnabled(confirmPasswordValidationMessage);
	}

	private boolean isMobileValidationMessageEnabled(){
		
		return isElementEnabled(mobileValidationMessage);
	}
	
	public String getFullNameValidationMessage(){
		
		if (isFullNameValidationMessageEnabled()){
			return fullNameValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getUsernameValidationMessage(){
		
		if (isUsernameValidationMessageEnabled()){
			return usernameValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getEmailValidationMessage(){
		
		if (isEmailValidationMessageEnabled()){
			return emailValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getPasswordValidationMessage(){
		
		if (isPasswordValidationMessageEnabled()){
			return passwordValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getConfirmPasswordValidationMessage(){
		
		if (isConfirmPasswordValidationMessageEnabled()){
			return confirmPasswordValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public String getMobileValidationMessage(){
		
		if (isMobileValidationMessageEnabled()){
			return mobileValidationMessage.getText();
		}
		return "MessageDisabled";
	}

	public void clearAllFields(){
		
		clearEdit(fullNameEdit);
		clearEdit(usernameEdit);
		clearEdit(passwordEdit);
		clearEdit(confirmPasswordEdit);
		clearEdit(emailEdit);
		clearEdit(mobileEdit);
	}
}
