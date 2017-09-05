package com.selenium.training.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Aby on 5/09/2017.
 */
public class BasePage {
    protected WebDriver driver;
    //protected BasePage currentPage;

    protected By hotelsNavigationLink=By.linkText("Hotels");
    protected By trainNavigationLink=By.linkText("Trains");

    BasePage(WebDriver driver)
    {
        this.driver=driver;
        //currentPage=new HomePage();
    }

    public HotelPage GoToHotelsPage(){
        driver.findElement(hotelsNavigationLink).click();
        return new HotelPage(driver);
    }

    public void GoToTrainsPage(){
        driver.findElement(trainNavigationLink).click();
    }


}
