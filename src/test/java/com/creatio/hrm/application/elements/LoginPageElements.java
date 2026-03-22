package com.creatio.hrm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.hrm.framework.web.commons.WebCommons;

public class LoginPageElements extends WebCommons{
	
	@FindBy(xpath = "//h5[text()='Login']")
	public WebElement loginPageHeader;
	
	@FindBy(xpath = "//input[@name='username']")
	public WebElement usernameTextbox;	
	
	
	@FindBy(xpath = "//input[@type='password']")
	public WebElement passwordTextbox;	
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;	
	
	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	public WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//h6[text()='Reset Password']")
	public WebElement resetPasswordConfirmation;
	
	

}
