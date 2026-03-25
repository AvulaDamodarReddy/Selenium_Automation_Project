package com.SeleniumProject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverAction {

    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

        // Locate the "Desktops" menu
        WebElement desktops = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));

        // Locate the "Mac (1)" submenu
        WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));

        // Perform hover and click 
        Actions act = new Actions(driver);
        act.moveToElement(desktops).moveToElement(mac).click().build().perform();

        // Optional: close browser
        //driver.quit();   
    }
}