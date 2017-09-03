package com.selenium.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MyFirstTest {
    @Test
    public void googleSearch() throws InterruptedException {
        WebDriver driver=driverFactory("Chrome");
        driver.navigate().to("https://www.google.co.nz/");
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

    private WebDriver driverFactory(String browser){
        if (browser.equals("Chrome"))
            return new ChromeDriver();
        if (browser.equals("FF"))
            return new FirefoxDriver();
        throw new NotImplementedException();
    }
}
