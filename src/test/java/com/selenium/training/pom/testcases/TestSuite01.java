package com.selenium.training.pom.testcases;

import com.selenium.training.pom.pages.HomePage;
import com.selenium.training.pom.pages.HotelPage;
import com.selenium.training.pom.utils.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Aby on 5/09/2017.
 */
public class TestSuite01 {
    HomePage homePage;
    HotelPage hotelPage;

    @BeforeMethod
    public void beforeTest() throws MalformedURLException {
        DriverFactory.StartDriver("Chrome","");//http://localhost:4444/wd/hub");
        DriverFactory.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DriverFactory.driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
        DriverFactory.driver.navigate().to("https://www.cleartrip.com/");
    }

    @Test
    public void Test01() throws InterruptedException {
        homePage=new HomePage(DriverFactory.driver);
        homePage.EnterOrigin("New Delhi");
        homePage.EnterDestination("Auckland");
        homePage.ChooseADepartOnDate("21","October 2017");
        Thread.sleep(2000);
    }

    @Test
    public void Test02()throws InterruptedException{
        homePage=new HomePage(DriverFactory.driver);
        hotelPage=homePage.GoToHotelsPage();
        hotelPage.EnterDestination("Auckland");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void afterTest(){
        if(DriverFactory.driver != null)
            DriverFactory.QuitDriver();
    }
}
