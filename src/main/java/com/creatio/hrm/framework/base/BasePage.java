package com.creatio.hrm.framework.base;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.creatio.hrm.framework.utilities.PropUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BasePage {

	// This class will contain all the common methods related to browser configurations and web-driver
	private static WebDriver driver;
	Properties prop = PropUtil.readData("Config.properties");

	// Common method to launch the browser window
	@Before
	public void setupBrowser() {
		String browserName = prop.getProperty("browser.name");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			Assert.fail("Browser not supported");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	// Common method to close the browser window
	@After(order=0)
	public void tearDownBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
	@After(order=1)
	public void reportFailure(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()+"_Screenshot");
		}
	}
	// Method to get the WebDriver instance
	public static WebDriver getDriver() {
		return driver;
	}
	
	// Method to set the WebDriver instance
	public static void setDriver(WebDriver driverInstance) {
		driver = driverInstance;
	}
	

}
