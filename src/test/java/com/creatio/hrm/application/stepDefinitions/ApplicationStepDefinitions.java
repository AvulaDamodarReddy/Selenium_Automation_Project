package com.creatio.hrm.application.stepDefinitions;


	import java.util.List;
	import java.util.Map;

	import org.openqa.selenium.WebDriver;


import com.creatio.hrm.application.steps.HomePageSteps;
import com.creatio.hrm.application.steps.LoginPageSteps;

import com.creatio.hrm.framework.base.BasePage;

import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class ApplicationStepDefinitions {

		public LoginPageSteps loginPage;
		public HomePageSteps homePage;
		

		@Given("Initialize the page objects")
		public void initializePages() {
			WebDriver driver = BasePage.getDriver();
			loginPage = new LoginPageSteps(driver);
			homePage = new HomePageSteps(driver);
			
		}

	@Given("User Launch the Application")
	public void launchApplication() {
	    loginPage.launchApplication();
	}
	@Given("Verify Login page is displayed")
	public void verifyLoginPageIsDisplayed() {
	 loginPage.verifyLoginPageIsDisplayed();   
	}

	@When("^User enters (.*) and (.*)$")
	public void UserEntersUesrnameAndPassword(String uesrname ,String password ) {
	  loginPage.userEntersUesrnameAndPassword(uesrname, password);
	}

	@When("User clicks on the Login button")
	public void userClicksOnLoginButton() {
	  loginPage.userClicksOntheLoginButton(); 
	}

	@Then("Login should be successful")
	public void verifyLoginIsSuccessful() {
		homePage.verifyHomePageIsDisplayed();
	}

	@When("Clicks on the user profile icon")
	public void ClicksOnUserProfileIcon() {
		homePage.clicksOnUserProfileIcon();   
	}

	@When("User select the Logout option")
	public void userSelectLogoutOption() {
		homePage.clickOnLogoutButton();
	}

	}
	/*
	 @When("User enter valid business email {string}")
	public void userEnterValidBusinessEmail(String email) {
		loginPage.enterBusinessEmail(email);
	}


	@When("User click on the Forgot Password link")
	public void userClicOnForgotPasswordLink() {
	  loginPage.clickOnForgotPasswordLink(); 
	}

	@Then("User should get reset password confirmation message")
	public void verifyResetPasswordConfirmationMessage() {
	loginPage.verifyResetPasswordConfirmationMessageIsDisplayed();	
	}

	 */
	

