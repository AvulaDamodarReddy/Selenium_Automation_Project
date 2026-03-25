package com.SeleniumProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		//name
		//driver.findElement(By.name("search")).sendKeys("Mac");
		//id
//Boolean	logoDisplaystatus=driver.findElement(By.id("logo")).isDisplayed(); 
//System.out.println(logoDisplaystatus);
////linkText
//driver.findElement(By.linkText("Tablets"));
////Partial link Text
//driver.findElement(By.partialLinkText("Table"));
//ClassName		
//List<WebElement> headerLinks=driver.findElements(By.className("list-inline-item"));
//System.out.println("total number of  header links:"+headerLinks.size());
//tagname
List<WebElement>links=driver.findElements(By.tagName("a"));
System.out.println("total number of links:"+links.size());		
List<WebElement>images=driver.findElements(By.tagName("img"));
System.out.println("total number of images:"+images.size());

	}

}
