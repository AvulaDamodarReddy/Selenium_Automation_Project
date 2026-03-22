package com.creatio.hrm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.hrm.framework.web.commons.WebCommons;

public class HomePageElements extends WebCommons{
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	public WebElement dashboardHeader;
	
	@FindBy(xpath="//span[text()='Users']")
	public WebElement usersLink;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	public WebElement userProfileIcon;
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logoutButton;
	

}
