package com.creatio.hrm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.hrm.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements {
	
	 public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Method to verify whether login page is displayed.
	public void verifyLoginPageIsDisplayed()  {
		waitForElement(loginPageHeader);
			
	}
	
	//Method to enter business email and password.
	public void userEntersUesrnameAndPassword(String uesrname, String password)  {
		waitForElement(usernameTextbox);
		enterText(usernameTextbox, uesrname);
		waitForElement(passwordTextbox);
		enterText(passwordTextbox, password);
				
	}
	
	//Method to enter business email and password.
		public void enterBusinessEmail(String username)  {
			waitForElement(usernameTextbox);
			enterText(usernameTextbox, username);
		}	
	//Method to click on login button.
	public void userClicksOntheLoginButton()  {
		waitForElement(loginButton);
		click(loginButton);
			
	}
	
	//Method to click on the forgotPasswordLink.
	public void clickOnForgotPasswordLink()  {
		waitForElement(forgotPasswordLink);
		click(forgotPasswordLink);
				
	}
	
	//Method to verify reset password confirmation message.
	public void verifyResetPasswordConfirmationMessageIsDisplayed()  {
		waitForElement(resetPasswordConfirmation);
			
	}
	 
	
	
	

}
