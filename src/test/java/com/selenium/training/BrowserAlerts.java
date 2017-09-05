package com.selenium.training;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Aby on 5/09/2017.
 */
public class BrowserAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("img.ib-img-default")).click();
        Thread.sleep(2000);

        //This step will result in an alert on screen
        driver.findElement(By.xpath("//*[@id='content']/p[4]/button")).click();

        //Once alert is present try to click on any button on the page
        //driver.findElement(By.xpath("//*[@id='content']/p[16]/button")).click();

        //Simple Alert

        Alert simpleAlert = driver.switchTo().alert();
        String alertText = simpleAlert.getText();
        System.out.println("Alert text is " + alertText);
        simpleAlert.accept();

        //Confirmation Alert

        WebElement element = driver.findElement(By.xpath("//*[@id='content']/p[8]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);

        Alert confirmationAlert = driver.switchTo().alert();
        alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.dismiss();

        //Prompt Alert

        element = driver.findElement(By.xpath("//*[@id='content']/p[11]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);

        Alert promptAlert  = driver.switchTo().alert();
        alertText = promptAlert .getText();
        System.out.println("Alert text is " + alertText);
        //Send some text to the alert
        promptAlert .sendKeys("Accepting the alert");
        Thread.sleep(4000); //This sleep is not necessary, just for demonstration
        promptAlert .accept();
    }
}
