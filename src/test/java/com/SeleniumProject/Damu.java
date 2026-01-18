package com.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Damu {

	public static void main(String[] args) throws Exception
	{
		WebDriver driver= new ChromeDriver();
		driver.get("https://vinothqaacademy.com/mouse-event/");
		driver.manage().window().maximize();
//WebElement doubleClick =driver.findElement(By.xpath("//h3[normalize-space()='Mouse Actions - Tooltip']"));
//WebElement element=driver.findElement(By.xpath("//input[@id='textbox']"));
//		Actions act=new Actions(driver);
//		//Thread.sleep(3000);
//		act.moveToElement(doubleClick).moveToElement(element).sendKeys("Damu").perform();
		// Hover over input box
		// Locate the "Desktops" menu
        
		WebElement hoverBox = driver.findElement(By.xpath("//input[@id='textbox']"));//input[@id='textbox']
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.moveToElement(hoverBox).perform();
		

	}

}
