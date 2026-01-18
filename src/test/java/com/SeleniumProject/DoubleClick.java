package com.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main(String[] args) throws Exception
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://vinothqaacademy.com/mouse-event/");
		driver.manage().window().maximize();
WebElement doubleClick =	driver.findElement(By.xpath("//button[@id='dblclick']"));
		Actions act=new Actions(driver);
		Thread.sleep(3000);
		act.doubleClick(doubleClick).perform();
		
//		WebElement mousehover =	driver.findElement(By.id("textbox"));	
//		Actions act=new Actions(driver);
//		Thread.sleep(1000);
//		act.moveToElement(mousehover).perform();
//		Thread.sleep(3000);
//		act.moveToElement(mousehover).click().sendKeys("ADBC").perform();
//		Thread.sleep(2000);
//		driver.quit();
 
	}

}
