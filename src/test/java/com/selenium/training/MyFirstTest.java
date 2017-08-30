package com.selenium.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {
    @Test
    public void  startWebDriver() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://www.google.com");
        Assert.assertTrue(driver.getTitle().startsWith("Google"), "Title should start with Google");
        driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
        driver.findElement(By.name("btnK")).click();
        driver.findElement(By.className("g")).click();
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

    @Test
    public void loginToGmail(){
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.gmail.com");
        driver.close();
        driver.quit();
    }
}
