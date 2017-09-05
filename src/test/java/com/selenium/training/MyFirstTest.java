package com.selenium.training;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.concurrent.TimeUnit;

public class MyFirstTest {
    private WebDriver driver;

    @Test
    public void googleSearch() throws InterruptedException {
        driver=driverFactory("Chrome");
        driver.navigate().to("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(),"Google");
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://www.google.co"),"URL is not in google domain");
        System.out.println(driver.findElement(By.className("logo-subtext")).getText());
        Assert.assertEquals(driver.findElement(By.className("logo-subtext")).getText(),"New Zealand");
        Thread.sleep(2000);
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))).click();
        driver.close();
        //driver.quit();
    }

    @Test
    public void gmailLogin() throws InterruptedException {
        driver=driverFactory("Chrome");
        driver.navigate().to("https://www.gmail.com/");
        driver.findElement(By.id("identifierId")).sendKeys("selenium");
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(2000);
        driver.close();
        //driver.quit();
    }

    @Test
    public void scrollUp() throws InterruptedException {
        driver=driverFactory("Chrome");
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("btnK")).click();

        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Vertical scroll - down by 150  pixels
        js.executeScript("window.scrollBy(0,150)");

        Thread.sleep(5000);

        driver.close();
        //driver.quit();

        //driver.findElement(By.id("pnnext")).click();
    }


    private WebDriver driverFactory(String browser){
        if (browser.equals("Chrome"))
            return new ChromeDriver();
        if (browser.equals("FF"))
            return new FirefoxDriver();
        throw new NotImplementedException();
    }
}
