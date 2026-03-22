package com.creatio.hrm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.hrm.application.elements.HomePageElements;

public class HomePageSteps extends HomePageElements {
	
	public HomePageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Method to verify the landing page is displayed successfully.
	public void verifyHomePageIsDisplayed()  {
		waitForElement(dashboardHeader);
		
	}
	
	//Method to verify user profile icon is getting displayed.
	public void verifyUserProfileIconIsDisplayed()  {
		waitForElement(userProfileIcon);
			
	}
	
	//Method to click on the user profile icon.
	public void clicksOnUserProfileIcon()  {
		waitForElement(userProfileIcon);
		click(userProfileIcon);
		
	}
	
	//Method to click on logout button.
	public void clickOnLogoutButton()  {
		waitForElement(logoutButton);
		click(logoutButton);
				
	}

}
/*
 Scenario: Verify Forgot Password Link functionality.
    Given User Launch the Application
    And Verify Login page is displayed
    When User click on the Forgot Password link
    Then User should get reset password confirmation message
    When User enter valid username "test"
 */



