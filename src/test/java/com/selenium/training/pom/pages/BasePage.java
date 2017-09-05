package com.selenium.training.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Aby on 5/09/2017.
 */
public class BasePage {
    protected WebDriver driver;
    protected BasePage currentPage;

    void BasePage()
    {
        driver=new ChromeDriver();
        driver.navigate().to("https://www.cleartrip.com/");
    }
}
