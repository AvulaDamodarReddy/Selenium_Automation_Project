package com.creatio.hrm.framework.web.commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.creatio.hrm.framework.base.BasePage;
import com.creatio.hrm.framework.constants.Constants;
import com.creatio.hrm.framework.utilities.PropUtil;

public class WebCommons {
	
	//This class will contain all the common methods related to web application automation by using Selenium.
	
	public WebDriver driver= BasePage.getDriver();
	public Properties prop = PropUtil.readData("Config.properties");
	
	
	//Common method to launch the application and verify the application title.
	public void launchApplication() {
		driver.get(prop.getProperty("app.url"));
		wait(2);
		String expectedTitle = prop.getProperty("app.title");
		String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.contains(expectedTitle) , "Application title does not match!");
	}
	
	//Common method to scroll to the element.
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	//Common method to click on the element.
	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}
	
	//Common method to click on the hidden element.
	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	//Common method to perform double-click on the element.
	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	//Common method to perform right-click on the element.
	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	//Common method to hover over the element.
	public void hoverOverElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	//Common method to type the text into the text box.
	public void enterText(WebElement element, String text) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(text);
	}
	
	//Common method to select the option from drop-down.
	public void selectDropdownOption(WebElement dropdown, String option, String selectBy) {
		scrollToElement(dropdown);
		Select select = new Select(dropdown);
		switch (selectBy.toLowerCase()) {
			case "visibletext":
				select.selectByVisibleText(option);
				break;
			case "value":
				select.selectByValue(option);
				break;
			case "index":
				select.selectByIndex(Integer.parseInt(option));
				break;
			default:
				Assert.fail("Invalid selection method: " + selectBy);
		}		
	}
	
	//Common method to get the text from an element.
	public String getElementText(WebElement element) {
		scrollToElement(element);
		return element.getText();
	}
	
	//Common method to select the checkbox.
	public void selectCheckbox(WebElement checkbox, boolean status) {
		scrollToElement(checkbox);
		if (!checkbox.isSelected()==status) {
			checkbox.click();
		}
	}
	
	//Common method to get the attribute value from an element.
	public String getElementAttribute(WebElement element, String attribute) {
		scrollToElement(element);
		return element.getAttribute(attribute);
	}
	
	//Common method to get the current browser URL.
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	//Common method to refresh the browser.
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	//Common method to verify the display status of an element.
	public boolean isElementDisplayed(WebElement element) {
		scrollToElement(element);
		return element.isDisplayed();
	}
	
	//Common method to verify the enable status of an element.
	public boolean isElementEnabled(WebElement element) {
		scrollToElement(element);
		return element.isEnabled();
	}
	
	//Common method to wait by using Java wait.
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Common Method to wait by using Implicit Weight.
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}
	 
	//Common method to wait for the element or locator
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//Common method to wait for the locator
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	//Common method to wait until element disappears.
	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	

	//Common method to switch to the frame from the main browser window.
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	//Common method to switch to the frame from the main browser window.
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	//Common method to switch back to the main browser window from the frame.
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	//Common method to accept or reject the alert.
	public void handleAlert(boolean accept) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		if (accept) {
			alert.accept();
		} else {
			alert.dismiss();
		}
	}
	
	// Common method to take the screenshot of entire browser window with parameters as driver and screenshot name.
	public static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\MavenProject\\Screenshots\\" + screenshotName + ".png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(filePath));
		return filePath;
	}

	// Common method to take the screenshot of webelement with parameters as driver and screenshot name.
	public static String takeScreenshot(WebElement element, String screenshotName) throws IOException {
		String filePath = System.getProperty("user.dir") + "\\MavenProject\\Screenshots\\" + screenshotName + ".png";
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(filePath));
		return filePath;
	}

}
