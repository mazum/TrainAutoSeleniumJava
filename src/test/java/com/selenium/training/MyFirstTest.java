package com.selenium.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {
    @Test
    public void  startWebDriver(){
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://www.google.com");
        Assert.assertTrue(driver.getTitle().startsWith("Google"), "Title should start with Google");
        driver.close();
        driver.quit();
    }
}
